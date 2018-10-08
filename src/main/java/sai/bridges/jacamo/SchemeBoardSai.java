package sai.bridges.jacamo;

import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import static jason.asSyntax.ASSyntax.parseFormula;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import cartago.AgentIdCredential;
import cartago.ArtifactConfig;
import cartago.ArtifactId;
import cartago.CartagoContext;
import cartago.CartagoException;
import cartago.INTERNAL_OPERATION;
import cartago.LINK;
import cartago.OPERATION;
import cartago.Op;
import cartago.OpFeedbackParam;
import cartago.util.agent.ActionFailedException;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.norms.npl.nopl2sai.IScheme2SaiListener;
import sai.norms.npl.nopl2sai.NOpl2Sai;
import moise.common.MoiseException;
import moise.os.OS;
import npl.NormativeFailureException;
import npl.parser.ParseException;
import ora4mas.nopl.JasonTermWrapper;
import ora4mas.nopl.NormativeBoard;
import ora4mas.nopl.Operation;
import ora4mas.nopl.SchemeBoard;
import ora4mas.nopl.oe.CollectiveOE;
import ora4mas.nopl.oe.Group;
import ora4mas.nopl.oe.Player;
import ora4mas.nopl.oe.Scheme;
import ora4mas.nopl.tools.os2nopl;

public class SchemeBoardSai extends SchemeBoard implements IScheme2SaiListener{

	private NOpl2Sai npl2sai;
	private SaiEngine institution;
	//private List<Commitment> commitmentsList = Collections.synchronizedList(new ArrayList<Commitment>());	
	//private List<Goal> achievementsList = Collections.synchronizedList(new ArrayList<Goal>());
	private List<Commitment> commitmentsList = new ArrayList<Commitment>();	
	private List<Goal> achievementsList = new ArrayList<Goal>();
	private CommitmentChecker commitmentChecker = new CommitmentChecker();
	
	private moise.os.fs.Scheme spec; //could be protected in the superclass - requires for method UpdateRolePlayers

	
	private CartagoContext cartagoCtx;


//@Override
	public void init(final String osFile, final String schType, final String workspacename) throws ParseException, MoiseException {
		super.init(osFile, schType);		
		
		final OS os = OS.loadOSFromURI(osFile);
        spec = os.getFS().findScheme(schType);

		this.npl2sai = new NOpl2Sai(getNormativeEngine());
	
		this.npl2sai.addSchemeListener(this);		
		 
		commitmentChecker.start();
		
		cartagoCtx = new CartagoContext(new AgentIdCredential("sai__institution__sc"), workspacename);
		try {
			cartagoCtx.joinWorkspace(workspacename, new AgentIdCredential("sai__institution__sc"));
		} catch (CartagoException e) {
			e.printStackTrace();
		}		
		
	}



	/**
	 * Set the institution which the SchemeBoard belongs to. 
	 * An institution is actually a SaiEngine
	 */
    @OPERATION
    public void setInstitution(SaiEngine institution){
    	this.institution = institution;
    	institution.addNormativeEngine(this.getNormEngine());
    }
    
    public SaiEngine getInstitution(){
    	return this.institution;
    }
	 
	
    @Override
	public INormativeEngine getNormEngine() {	
		return this.npl2sai;
	}
    
	@OPERATION
	public void getNormativeEngine(OpFeedbackParam<INormativeEngine> nEngine){
		nEngine.set(this.npl2sai);
	}
	
	
	


	@Override
	public void sai_goalAchieved(String agent, String goal) {		
		synchronized (achievementsList) {
			achievementsList.add(new Goal(agent, goal)); //adds to the list to be consumed by a thread
		}
		commitmentChecker.interrupt();		
	}


	@LINK protected void updateRolePlayers(final String grId, final Collection<Player> rp) throws NormativeFailureException, CartagoException {
        ora4masOperationTemplate(new Operation() {
            public void exec() throws NormativeFailureException, Exception {
                Group g = new Group(grId);
                for (Player p: rp)
                    g.addPlayer(p.getAg(), p.getTarget());
                g.addResponsibleForScheme(orgState.getId());
                
                boolean newLink = !getSchState().getGroupsResponsibleFor().contains(g);
                getSchState().addGroupResponsibleFor(g);
        
                nengine.verifyNorms();
        
                getObsProperty(obsPropGroups).updateValue(getSchState().getResponsibleGroupsAsProlog());
                if (newLink) {
                    // first time the group is linked to this scheme, create normative board
                    // create normative board
                    String nbId = grId+"."+orgState.getId();
                    ArtifactId aid = makeArtifact(nbId, NormativeBoardSai.class.getName(), new ArtifactConfig() );
                    execLinkedOp(aid, "load", os2nopl.transform(spec, false));
                    execLinkedOp(aid, "doSubscribeDFP", orgState.getId());
                    execLinkedOp(aid,"setInstitution", getInstitution());
                    
                    String nplProgram = spec.getFS().getOS().getNS().getNPLNorms();
                    if (nplProgram != null) {
                        StringBuilder out = new StringBuilder();
                        out.append("scope npl_norms_for_"+spec.getId()+" {\n");
                        out.append(nplProgram);
                        out.append("\n}");
                        execLinkedOp(aid, "load", out.toString());
                    }
                }
            }
        }, null);
    }
    
	
	public Scheme getSchState() {
		return (Scheme)orgState;
	}

	/*private void updateMonitorScheme() throws CartagoException {
		if (monitorSchArt != null) {
			execLinkedOp(monitorSchArt, "updateMonitoredScheme", orgState);
		}
	}*/

	@INTERNAL_OPERATION
	void internal_goalAchieved(String agent, String goal){
		try {	
			this.goalDone(agent, goal);
		} catch (CartagoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*This method is a copy from the superclass.
	 * TODO: (?) make this method protected in the superclass?
	 * */
	private void goalDone(final String agent, final String goal) throws CartagoException {
        ora4masOperationTemplate(new Operation() {
            public void exec() throws NormativeFailureException, Exception {
                getSchState().addDoneGoal(agent, goal);
                nengine.verifyNorms();
                if (getSchState().computeSatisfiedGoals()) { // add satisfied goals
                    //nengine.setDynamicFacts(orgState.transform());        
                    nengine.verifyNorms();
                }
                //updateMonitorScheme();
    
                updateGoalStateObsProp();
            }
        },"Error achieving goal "+goal);
    }

	/*private void goalAchieved(String agent, String goal) throws CartagoException {
		if (!running) return;
		CollectiveOE bak = orgState.clone();
		getSchState().addGoalAchieved(agent, goal);		
		try {
			nengine.verifyNorms();			
			if (getSchState().computeSatisfiedGoals()) { // add satisfied goals
				nengine.verifyNorms();
			}
			updateMonitorScheme();

			updateGoalStateObsProp();

			updateGuiOE();
		} catch (NormativeFailureException e) {
			orgState = bak; // takes the backup as the current model since the action failed
			failed("Error achieving goal "+goal, "reason", new JasonTermWrapper(e.getFail()));
		} catch (Exception e) {
			orgState = bak; 
			failed(e.toString());
			e.printStackTrace();
		}
	}

*/
	
	


	@Override
	public void sai_committed(String agent, String mission, String scheme) {
		if(getSchState().getId().replaceAll("\"", "").equals(scheme.replaceAll("\"", ""))){
			synchronized (commitmentsList) {
				Commitment c = new Commitment(agent, mission);
				if(!commitmentsList.contains(c))
				   commitmentsList.add(c); //adds to the list to be consumed by a thread
			}			
			commitmentChecker.interrupt();
		}		
	}

	
	
	public void teste(Commitment c){
		 try {
			 	String ag = c.agent;
			 	String mission = c.mission;
				cartagoCtx.doAction(this.getId(), new Op("internal_commitMission", new Object[] {ag,mission}));
			} catch (ActionFailedException e) {
				e.printStackTrace();
			} catch (CartagoException e) {
				e.printStackTrace();
			}
	}


	@INTERNAL_OPERATION
	private void internal_commitMission(String agent, String mission){
		try {	
		     this.commitMission(agent, mission);
		} catch (CartagoException e) {
			e.printStackTrace();
		}
		/*orgState.addPlayer(agent, mission);
		try {
			nengine.verifyNorms();
		} catch (NormativeFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	private void commitMission(final String ag, final String mission) throws CartagoException {
        ora4masOperationTemplate(new Operation() {        	
            public void exec() throws NormativeFailureException, Exception {            	
            	//log("commitMission starting: " + ag + ";" + mission );
            	if (orgState.hasPlayer(ag, mission))
                    return;
                orgState.addPlayer(ag, mission);
                nengine.verifyNorms();
                
                defineObsProperty(obsPropCommitment, 
                        new JasonTermWrapper(ag), 
                        new JasonTermWrapper(mission), 
                        new JasonTermWrapper(SchemeBoardSai.this.getId().getName()));
                updateGoalStateObsProp();
                //log("commitMission done: " + ag + ";" + mission );
                //updateMonitorScheme();
            }
        }, "Error committing to mission "+mission);
    }
    



	private class Commitment{

		private String agent;
		private String mission;

		public Commitment(String agent, String mission) {
			super();
			this.agent = agent;
			this.mission = mission;
		}

		public String getAgent() {
			return agent;
		}

		public String getMission() {
			return mission;
		}

		@Override
		public String toString() {
			return "Commitment [agent=" + agent + ", mission=" + mission + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Commitment)) { return false;}
			Commitment c = (Commitment) obj;
			if(!c.getAgent().equals(this.getAgent())&&c.getMission().equals(this.getMission()))
				return false;
				
			return true;
		}
		
		
		

	}

	private class Goal{
		private String agent;
		private String goal;

		public Goal(String agent, String goal) {
			super();
			this.agent = agent;
			this.goal = goal;
		}

		public String getAgent() {
			return agent;
		}

		public String getGoal() {
			return goal;
		}

		@Override

		public String toString() {
			return "Goal [agent=" + agent + ", goal=" + goal + "]";
		}


	}


	private class CommitmentChecker extends Thread{

		@Override
		public void run() {			
			ArrayList<Commitment> added = new ArrayList<Commitment>();
			ArrayList<Goal> addedAchievement = new ArrayList<Goal>();
			boolean toCommit;
			while(true){			
                                //log("commitment checker - size: " + commitmentsList.size());
				if(commitmentsList.size()>0){                                        
					added.clear();

					synchronized (commitmentsList) {						
						for(Commitment c:commitmentsList){
							try {
								//toCommit = nengine.getAg().believes(parseFormula("active(obligation("+c.getAgent()+",R,committed("+c.getAgent()+","+c.getMission()+",\""+getSchState().getId()+"\"),D)[created(_)])"), new Unifier());
								toCommit = nengine.getAg().believes(parseFormula("active(obligation("+c.getAgent()+",R,committed("+c.getAgent()+","+c.getMission()+","+getSchState().getId()+"),D)[created(_)])"), new Unifier());
								//if(toCommit){
									//execInternalOp("internal_commitMission",c.getAgent(),c.getMission());
									
								//teste(c);
								try {
									cartagoCtx.doAction(SchemeBoardSai.this.getId(), new Op("internal_commitMission", new Object[] {c.getAgent(),c.getMission()}));
								} catch (ActionFailedException e) {
									e.printStackTrace();
								} catch (CartagoException e) {
									e.printStackTrace();
								}
									added.add(c);
								/*}else{
									log("do not believe " + parseFormula("active(obligation("+c.getAgent()+",R,committed("+c.getAgent()+","+c.getMission()+",\""+getSchState().getId()+"\"),D)[created(_)])"));
									Iterator<Literal> it =   nengine.getAg().getBB().iterator();
									while(it.hasNext()){
										log("iterator: " + it.next());
									}
								}*/
							} catch (jason.asSyntax.parser.ParseException e) {
								e.printStackTrace();
							}
						}	
					}
					commitmentsList.removeAll(added);
				}


				boolean toAchieve;
				if(achievementsList.size()>0){
					addedAchievement.clear();
					synchronized (achievementsList) {
						for(Goal c:achievementsList){
							try {																		
								if(nengine.getAg().believes(parseFormula("fulfilled(obligation("+c.getAgent()+",_,achieved(\""+getSchState().getId()+"\","+c.getGoal()+","+c.getAgent()+"),_))"), new Unifier())){
									addedAchievement.add(c);
								}
								else{
									toAchieve = nengine.getAg().believes(parseFormula("enabled("+getSchState().getId()+","+c.getGoal()+")"), new Unifier());
									if(toAchieve){
										execInternalOp("internal_goalAchieved",c.getAgent(),c.getGoal());
									}	
								}
							} catch (jason.asSyntax.parser.ParseException e) {
								e.printStackTrace();
							}
						}	
					}
					achievementsList.removeAll(addedAchievement);
				}
				try {
					Thread.sleep(1000);					
				} catch (InterruptedException e) {
				}				


			}

		}
	}


	

}
