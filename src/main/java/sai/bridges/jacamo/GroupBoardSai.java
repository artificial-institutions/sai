/**
 * This class implements a general purpose GroupBoard that takes part in a SAI institution.
 * 
 * For JaCaMo applications, use a GroupBoardSaiJaCaMo.
 */


package sai.bridges.jacamo;

import cartago.ArtifactId;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.OpFeedbackParam;
import cartago.OperationException;
import moise.common.MoiseException;
import npl.NormativeFailureException;
import npl.parser.ParseException;
import ora4mas.nopl.GroupBoard;
import ora4mas.nopl.JasonTermWrapper;
import ora4mas.nopl.oe.CollectiveOE;
import ora4mas.nopl.oe.Group;
import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import sai.norms.npl.nopl2sai.IGroup2SaiListener;
import sai.norms.npl.nopl2sai.NOpl2Sai;

public class GroupBoardSai extends GroupBoard implements IGroup2SaiListener {

    private NOpl2Sai npl2sai;

	@Override
	public void init(final String osFile, final String grType) throws ParseException, MoiseException, OperationException {
		super.init(osFile, grType);

		this.npl2sai = new NOpl2Sai(getNormativeEngine());
		this.npl2sai.addGroupListener(this);
	}


	@OPERATION
	public void getNormativeEngine(OpFeedbackParam<INormativeEngine> nEngine){
		nEngine.set(this.npl2sai);
	}


	public void sai_play(String agent, String role, String group) {
		if (orgState.hasPlayer(agent, role))
			return;
		adoptRole(agent, role);
	}


	@INTERNAL_OPERATION
	private void internal_adoptRole(String ag, String role){
		adoptRole(ag, role);        
	}

	public void sai_responsible(String group, String scheme) {      
		if(group.replaceAll("\"", "").equals(this.getId().getName())){
			while(!this.isWellFormed()){ //TODO: put this in a thread
			}			
			internal_addScheme(scheme.replaceAll("\"", ""));
		}	

	}

	//@INTERNAL_OPERATION 
	//implemented in the superclass as the operation addScheme
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

	
	/**
	 * Set the institution which the SchemeBoard belongs to. 
	 * An institution is actually a SaiEngine
	 */
	@OPERATION
	public void setInstitution(SaiEngine institution){
		institution.addNormativeEngine(this.getNormEngine());

	}



	public INormativeEngine getNormEngine() {	
		return this.npl2sai;
	}



}
