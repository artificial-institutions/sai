package sai.bridges.jacamo;

import static jason.asSyntax.ASSyntax.parseFormula;

import java.util.ArrayList;
import java.util.Iterator;

import cartago.AgentIdCredential;
import cartago.CartagoEvent;
import cartago.CartagoException;
import cartago.ICartagoCallback;
import cartago.ICartagoContext;
import cartago.Op;
import cartago.Workspace;
import cartago.util.agent.ActionFailedException;
import jason.asSemantics.Unifier;
import moise.common.MoiseException;
import npl.parser.ParseException;

public class SchemeBoardSaiJaCaMo extends SchemeBoardSai {

	@Override
	public void init(final String osFile, final String schType) throws ParseException, MoiseException {
		super.init(osFile, schType);
	}

	protected void launchCommitmentChecker() {
		commitmentChecker  = new CommitmentCheckerJaCamo();
		commitmentChecker.start();
	}




	private class CommitmentCheckerJaCamo extends CommitmentChecker{

		@Override
		public void run() {         
			ArrayList<Commitment> added = new ArrayList<>();
			ArrayList<Goal> addedAchievement = new ArrayList<>();
			cartago.CartagoEnvironment cenv = cartago.CartagoEnvironment.getInstance(); 
			Workspace main = cenv.getRootWSP().getWorkspace();
			Workspace instWks = main.getChildWSP(getOEId()).get().getWorkspace();
			ICartagoContext context = null;
			try {
				context= instWks.joinWorkspace(new AgentIdCredential("JaCaMoLauncherAgOrg"), new ICartagoCallback() {
					public void notifyCartagoEvent(CartagoEvent a) {    }
				});
			} catch (CartagoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

                        //wait for some responsible group
			while (getSchState().getIdsGroupsResponsibleFor().isEmpty()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}
			}

			while (true) {
				synchronized (commitmentsList) {

					if (commitmentsList.size() > 0) {
						added.clear();

						for (Commitment c : commitmentsList) {
							try {
								context.doAction(1, SchemeBoardSaiJaCaMo.this.getId().toString(),
										new Op("internal_commitMission", new Object[] { c.getAgent(), c.getMission() }),
										null, -1);
								added.add(c);

                                                               //wait until the commitment is processed by the orgnanization
								while(!orgState.hasPlayer( c.getAgent(), c.getMission() )){
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {
									}
								}
							} catch (ActionFailedException e) {
								e.printStackTrace();
							} catch (CartagoException e) {
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
								if(nengine.holds(parseFormula("fulfilled(obligation("+c.getAgent()+",_,done("+getSchState().getId()+","+c.getGoal()+","+c.getAgent()+"),_))"))){
									addedAchievement.add(c);
								}
								else{
									toAchieve = nengine.holds(parseFormula("enabled("+getSchState().getId()+","+c.getGoal()+")"));
									if (toAchieve) {
										//execInternalOp("internal_goalAchieved", c.getAgent(), c.getGoal());
										try {
											context.doAction(1, SchemeBoardSaiJaCaMo.this.getId().toString(),
													new Op("internal_goalAchieved",
															new Object[] { c.getAgent(), c.getGoal() }),
													null, -1);
										} catch (CartagoException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							} catch (jason.asSyntax.parser.ParseException e) {
								e.printStackTrace();
							}
						}       
						for(Goal a:addedAchievement) {              
							for(Iterator<Goal> it = achievementsList.iterator(); it.hasNext();) {
								Goal g = it.next();
								if(a.getAgent().equals(g.getAgent())&&a.getGoal().equals(g.getGoal())) {
									it.remove();
								}
							}
						}
					}

				}

				try {
					Thread.sleep(1000);                 
				} catch (InterruptedException e) {
				}               


			}

		}
	}


}
