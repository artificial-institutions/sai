/**
 * This class implements a GroupBoard that takes part in a SAI institution in JaCaMo applications.
*/

package sai.bridges.jacamo;

import cartago.AgentIdCredential;
import cartago.ArtifactId;
import cartago.CartagoEvent;
import cartago.CartagoException;
import cartago.ICartagoCallback;
import cartago.ICartagoContext;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.Op;
import cartago.OperationException;
import cartago.Workspace;
import moise.common.MoiseException;
import npl.NormativeFailureException;
import npl.parser.ParseException;
import ora4mas.nopl.JasonTermWrapper;
import ora4mas.nopl.oe.CollectiveOE;
import ora4mas.nopl.oe.Group;

public class GroupBoardSaiJaCaMo extends GroupBoardSai {

	protected String institution = null;


	@Override
	public void init(final String osFile, final String grType) throws ParseException, MoiseException, OperationException {
		super.init(osFile, grType);
	}


	@OPERATION public void setInstitutionName(String institutionName) {
		this.institution = institutionName;
	}



	@Override
	public void sai_responsible(String group, String scheme) {      
		if(group.replaceAll("\"", "").equals(this.getId().getName())){
			while(!this.isWellFormed()){ //TODO: put this in a thread
			}			

			cartago.CartagoEnvironment cenv = cartago.CartagoEnvironment.getInstance(); 
			Workspace main = cenv.getRootWSP().getWorkspace();
			Workspace instWks = main.getChildWSP(this.getOEId()).get().getWorkspace();
			ICartagoContext context;
			try {
				context = instWks.joinWorkspace(new AgentIdCredential("JaCaMoLauncherAgOrg"), new ICartagoCallback() {
					public void notifyCartagoEvent(CartagoEvent a) {    }
				});
				context.doAction(1, this.getId().toString(), new Op("internal_addScheme", new Object[] {scheme.replaceAll("\"", "")}), null, -1);
			} catch (CartagoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}		
	}

	@INTERNAL_OPERATION //implemented in the superclass as the operation addScheme
	private void internal_addScheme(String schId) {		
		if (!running) return;
		CollectiveOE bak = orgState.clone();
		try {
			ArtifactId schAr = lookupArtifact(schId);
			getGrpState().addResponsibleForScheme(schId);			
			nengine.verifyNorms();


			getObsProperty(obsPropSchemes).updateValue(getGrpState().getResponsibleForAsProlog());


			schemes.add(schAr);
			notifyObservers();

			updateGuiOE();

			// update in subgroups
			for (Group sg: getGrpState().getSubgroups()) {
				ArtifactId sgid = lookupArtifact(sg.getId());
				execLinkedOp(sgid, "addScheme", schId);                
			}



		} catch (NormativeFailureException e) {
			orgState = bak; // takes the backup as the current model since the action failed
			failed("Error adding scheme "+schId, "reason", new JasonTermWrapper(e.getFail()));
		} catch (Exception e) {
			orgState = bak; // takes the backup as the current model since the action failed
			failed(e.toString());
		}   
	}
}
