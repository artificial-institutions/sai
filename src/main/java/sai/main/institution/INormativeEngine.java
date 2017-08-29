package sai.main.institution;

import sai.main.lang.semantics.InstProgram;


/**
 * A (class implementing) INormativeEngine implements the methods required, from SAI perspective, to manage the normative state.
 * This interface extends ConstitutiveListener as, in SAI, the normative engines consume informations about the constitutive state.
 * @author maiquel
 *
 */



public interface INormativeEngine extends ConstitutiveListener{
	
	/**
	 * Handle the reasoner updating the normative state
	 */
	public void updateState();
	
	
	/**
	 * Set to the normative engine the considered status function and constitutive rules. 
	 * TODO: maybe change to setConstitutiveProgram
	 * @param instProgram
	 */
	public void setInstitutionalProgram(InstProgram instProgram);
	
	
	
	
	
	

}
