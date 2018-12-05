package sai.norms.npl.npl2sai;

import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSyntax.parser.ParseException;

import java.util.Hashtable;
import java.util.Map;

import npl.NPLInterpreter;
import npl.NormativeFailureException;
import sai.main.institution.INormativeEngine;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;


/**
 * This class is a wrapper for the NPL engine when it is to be coupled with SAI constitutive state 
 * 
 *  As it implements the INormativeEngine interface, it can be registered as a listener
 *  to be informed about changes in the constitutive state and to update the normative state
 *  when a new constitutive state is calculated.
 *     
 * 
 * @author maiquel
 *
 */

public class Npl2Sai implements INormativeEngine{

	protected NPLInterpreter nengine;
	private Map<String, Integer> stateAssignments = new Hashtable<>();

	public Npl2Sai(NPLInterpreter nengine){
		this.nengine = nengine; 
	}



	/**
	 * Add agent-status function assignments to the set of facts of the NPL interpreter
	 */
	@Override 
	public void addAgentAssignment(String arg0, AgentStatusFunction arg1) {
		synchronized (nengine) {					
			try {				
				nengine.getAg().getBB().add(parseLiteral("sai__is("+arg0.toString()+","+arg1.toString()+")"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

	}

	/**
	 * Add event-status function assignments to the set of facts of the NPL interpreter
	 */
	@Override
	public void addEventAssignment(String arg0, EventStatusFunction arg1,
			AgentStatusFunction arg2) {
		try {
			synchronized (nengine) {				
				nengine.getAg().getBB().add(parseLiteral("sai__event("+arg1.toString()+"[sai__agent("+arg2.toString()+")])"));				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Add state-status function assignments to the set of facts of the NPL interpreter
	 */
	@Override
	public void addStateAssignment(String arg0, StateStatusFunction arg1) {
		try {
			if(stateAssignments.get(arg1.toString())==null){
				stateAssignments.put(arg1.toString(), 1);
			}
			else{				
				Integer v = stateAssignments.get(arg1.toString());
				v++;
				stateAssignments.put(arg1.toString(),v);
			}
			synchronized (nengine) {					
				nengine.getAg().getBB().add(parseLiteral(arg1.toString()));
			}
			updateState();
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove agent-status function assignments from the set of facts of the NPL interpreter
	 */
	@Override
	public void removeAgentAssignment(String arg0, AgentStatusFunction arg1) {
		try {
			nengine.getAg().getBB().remove(parseLiteral("sai__is("+arg0.toString()+","+arg1.toString()+")"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	/**
	 * Remove event-status function assignments from the set of facts of the NPL interpreter
	 */
	@Override
	public void removeEventAssignment(String arg0, EventStatusFunction arg1,
			AgentStatusFunction arg2) {
		try {
			nengine.getAg().getBB().remove(parseLiteral("sai__is("+arg1.toString()+"[sai__agent("+arg2.toString()+")])"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Remove state-status function assignments from the set of facts of the NPL interpreter
	 */
	@Override
	public void removeStateAssignment(String arg0, StateStatusFunction arg1) {
		try {
			Integer v=-1;
			if(stateAssignments.get(arg1.toString())!=null){				
				v = stateAssignments.get(arg1.toString());
				v--;
				stateAssignments.put(arg1.toString(), v);
			}
			if(v==0)
			   nengine.getAg().getBB().remove(parseLiteral(arg1.toString()));
		} catch (ParseException e) {
			e.printStackTrace();			
		}
	}

	
	
	
	@Override
	public void setInstitutionalProgram(InstProgram arg0) {

	}



	/**
	 * Called by the constitutive engine every time a new consistent constitutive state is achieved
	 * 	 
	 */
	@Override 
	public void updateState() {
		try {		
			nengine.verifyNorms();				

		} catch (NormativeFailureException e) {
			e.printStackTrace();
		}
	}

	
	

}
