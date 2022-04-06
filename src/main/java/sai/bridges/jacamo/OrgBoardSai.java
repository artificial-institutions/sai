package sai.bridges.jacamo;

import java.util.logging.Level;
import java.util.logging.Logger;

import cartago.AgentIdCredential;
import cartago.ArtifactId;
import cartago.CartagoEvent;
import cartago.CartagoException;
import cartago.ICartagoCallback;
import cartago.ICartagoContext;
import cartago.OPERATION;
import cartago.Op;
import cartago.OpFeedbackParam;
import cartago.OperationException;
import cartago.Workspace;
import jason.asSyntax.ASSyntax;
import moise.common.MoiseException;
import npl.parser.ParseException;
import ora4mas.nopl.OrgBoard;
import sai.main.institution.SaiEngine;

public class OrgBoardSai extends OrgBoard {

    protected Logger logger = Logger.getLogger(OrgBoardSai.class.getName());
    
    protected String institution = null;
    protected Object saiEngine   = null;

    @OPERATION
    public void setInstitution(String instId, Object instAId) throws ParseException, MoiseException, OperationException {
        try {
            cartago.CartagoEnvironment cenv = cartago.CartagoEnvironment.getInstance(); 
            Workspace main = cenv.getRootWSP().getWorkspace();
            Workspace instWks = main.getChildWSP(instId).get().getWorkspace();
            ICartagoContext context = instWks.joinWorkspace(new AgentIdCredential("JaCaMoLauncherAgOrg"), new ICartagoCallback() {
                public void notifyCartagoEvent(CartagoEvent a) {    }
            });
            
            // get listener object from SAI
            OpFeedbackParam<SaiEngine> fbre = new OpFeedbackParam<>();
            context.doAction(1, ((ArtifactId)instAId).getName(), new Op("getSaiEngine", new Object[] {  fbre} ), null, -1);            
            int i=0;
            while(fbre.get()==null && i++<30) {Thread.sleep(50);}	
            
            this.institution = instId;
            this.saiEngine   = fbre.get();
            defineObsProperty("institution", ASSyntax.createAtom(instId));            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getGroupBoardClass() {
        return GroupBoardSaiJaCaMo.class.getName();
    }

    @Override
    protected void grPostCreation(String id, ArtifactId artId) {
        setInstitution(id, artId);
        try {
        	cartago.CartagoEnvironment cenv = cartago.CartagoEnvironment.getInstance(); 
            Workspace main = cenv.getRootWSP().getWorkspace();
            Workspace instWks = main.getChildWSP(this.getOEId()).get().getWorkspace();
        	ICartagoContext context = instWks.joinWorkspace(new AgentIdCredential("JaCaMoLauncherAgOrg"), new ICartagoCallback() {
                public void notifyCartagoEvent(CartagoEvent a) {    }
            });
                
			context.doAction(1, artId.getName(), new Op("setInstitutionName",new Object[] { this.institution } ), null, -1);
		} catch (CartagoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @OPERATION public void createGroup(String id, String type, OpFeedbackParam<ArtifactId> gaid) throws OperationException {    	
    	super.createGroup(id, type, gaid);        	                   

    }
    
    @OPERATION public void createScheme(String id, String type, OpFeedbackParam<ArtifactId> said) throws OperationException {
       super.createScheme(id, type, said);
    }
    
    @Override
    protected String getSchemeBoardClass() {
        return SchemeBoardSaiJaCaMo.class.getName();
    }

    @Override
    protected void schPostCreation(String id, ArtifactId artId) {
    	try {
			execLinkedOp(artId, "setInstitution", this.saiEngine);
		} catch (OperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    protected String getNormativeBoardClass() {
        return NormativeBoardSai.class.getName();
    }
    @Override
    protected void normBoardPostCreation(String aName, ArtifactId aid) {
    	setInstitution(aName, aid);
    }


    protected void setInstitution(String id, ArtifactId artId) {
        try {
            execLinkedOp(artId, "setInstitution", saiEngine );
        } catch (OperationException e) {
            logger.log(Level.WARNING, "Error setting institution "+id+" for "+getId(), e);
        }
    }

}
