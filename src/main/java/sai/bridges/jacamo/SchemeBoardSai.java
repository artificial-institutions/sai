package sai.bridges.jacamo;

import static jason.asSyntax.ASSyntax.parseFormula;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartago.AgentIdCredential;
import cartago.CartagoContext;
import cartago.CartagoException;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.Op;
import cartago.OpFeedbackParam;
import cartago.util.agent.ActionFailedException;
import jason.asSemantics.Unifier;
import moise.common.MoiseException;
import npl.parser.ParseException;
import ora4mas.nopl.SchemeBoard;
import ora4mas.nopl.oe.Scheme;
import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import sai.norms.npl.nopl2sai.IScheme2SaiListener;
import sai.norms.npl.nopl2sai.NOpl2Sai;

public class SchemeBoardSai extends SchemeBoard implements IScheme2SaiListener{

    private NOpl2Sai npl2sai;
    private SaiEngine institution;
    //private List<Commitment> commitmentsList = Collections.synchronizedList(new ArrayList<Commitment>()); 
    //private List<Goal> achievementsList = Collections.synchronizedList(new ArrayList<Goal>());
    private List<Commitment> commitmentsList = new ArrayList<>(); 
    private List<Goal> achievementsList = new ArrayList<>();
    private CommitmentChecker commitmentChecker = new CommitmentChecker();

    private CartagoContext cartagoCtx;


    @Override
    public void init(final String osFile, final String schType) throws ParseException, MoiseException {
        super.init(osFile, schType);        

        this.npl2sai = new NOpl2Sai(getNormativeEngine());

        this.npl2sai.addSchemeListener(this);       

        commitmentChecker.start();
        String workspacename = getCreatorId().getWorkspaceId().getName();

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


    public INormativeEngine getNormEngine() {   
        return this.npl2sai;
    }

    @OPERATION
    public void getNormativeEngine(OpFeedbackParam<INormativeEngine> nEngine){
        nEngine.set(this.npl2sai);
    }





    public void sai_goalAchieved(String agent, String goal) {       
        synchronized (achievementsList) {           
            achievementsList.add(new Goal(agent, goal)); //adds to the list to be consumed by a thread
        }       
        commitmentChecker.interrupt();      
    }


    public Scheme getSchState() {
        return (Scheme)orgState;
    }


    @INTERNAL_OPERATION
    void internal_goalAchieved(String agent, String goal){
        try {   
            this.goalDone(agent, goal);
        } catch (CartagoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




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
            ArrayList<Commitment> added = new ArrayList<>();
            ArrayList<Goal> addedAchievement = new ArrayList<>();
            boolean toCommit;
            while(true){            
                if(commitmentsList.size()>0){                                        
                    added.clear();

                    synchronized (commitmentsList) {                        
                        for(Commitment c:commitmentsList){
                            try {
                                toCommit = nengine.getAg().believes(parseFormula("active(obligation("+c.getAgent()+",R,committed("+c.getAgent()+","+c.getMission()+","+getSchState().getId()+"),D)[created(_)])"), new Unifier());
                                try {
                                    cartagoCtx.doAction(SchemeBoardSai.this.getId(), new Op("internal_commitMission", new Object[] {c.getAgent(),c.getMission()}));
                                } catch (ActionFailedException e) {
                                    e.printStackTrace();
                                } catch (CartagoException e) {
                                    e.printStackTrace();
                                }
                                added.add(c);
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
                                if(nengine.getAg().believes(parseFormula("fulfilled(obligation("+c.getAgent()+",_,done("+getSchState().getId()+","+c.getGoal()+","+c.getAgent()+"),_))"), new Unifier())){
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
