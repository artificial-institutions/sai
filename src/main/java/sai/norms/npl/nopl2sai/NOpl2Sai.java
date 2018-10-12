package sai.norms.npl.nopl2sai;

import java.util.ArrayList;

import npl.NPLInterpreter;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.norms.npl.npl2sai.Npl2Sai;


/**
 * An INormativeEngine that with special behaviors to handle facts coming from the constitutive state that are 
 * related to the Moise/ORA4MAS semantics 
 *  
 * @author maiquel
 *
 */

public class NOpl2Sai extends Npl2Sai{

	public ArrayList<IScheme2SaiListener> schemeListeners = new ArrayList<IScheme2SaiListener>();
	public ArrayList<IGroup2SaiListener> groupListeners = new ArrayList<IGroup2SaiListener>();
	public ArrayList<INormativeBoard2SaiListener> normListeners = new ArrayList<INormativeBoard2SaiListener>();

	public NOpl2Sai(NPLInterpreter nengine) {
		super(nengine);

	}

	public void addSchemeListener(IScheme2SaiListener listener){
		schemeListeners.add(listener);
	}

	public void removeSchemeListener(IScheme2SaiListener listener){
		schemeListeners.remove(listener);
	}

	public void addGroupListener(IGroup2SaiListener listener){
		groupListeners.add(listener);
	}

	public void removeGroupListener(IGroup2SaiListener listener){
		groupListeners.remove(listener);
	}
	
	public void addNormListener(INormativeBoard2SaiListener listener){
		normListeners.add(listener);
	}
	
	public void removeNormListener(INormativeBoard2SaiListener listener){
		normListeners.remove(listener);
	}
	
	/**
	 * Overloading the superclass method to handle state-status functions corresponding to organizaitional states
	 * If some environmental state count as achieved(...), play(...), committed(...), responsible(...), or formationStatusOk(...)
	 * then the organizational then the listeners are informed.
	 *  
	 * Organizational artifacts must be listeners to handle the informations comming from the constitutive state.
	 * In this case, the organizational artifacts are responsible to handle the NPL engine. 
	 *  
	 */
	@Override	
	public void addStateAssignment(String arg0, StateStatusFunction arg1) {
		//System.out.println("[NOpl2Sai] adding state assignment " + arg0.toString() + " count-as " + arg1.toString() + " listeners " + schemeListeners.size());
		if(arg1.getState().getFunctor().equals("achieved"))
			for(IScheme2SaiListener listener:schemeListeners){
				listener.sai_goalAchieved(arg1.getState().getTerm(2).toString(),arg1.getState().getTerm(1).toString());
			}
		else if(arg1.getState().getFunctor().equals("play")){	
			for(IGroup2SaiListener listener:groupListeners){
				listener.sai_play(arg1.getState().getTerm(0).toString(), arg1.getState().getTerm(1).toString(), arg1.getState().getTerm(2).toString());
			}

		}
		else if(arg1.getState().getFunctor().equals("committed")){
			for(IScheme2SaiListener listener:schemeListeners){
				listener.sai_committed(arg1.getState().getTerm(0).toString(), arg1.getState().getTerm(1).toString(), arg1.getState().getTerm(2).toString());
			}			
			for(INormativeBoard2SaiListener listener:normListeners){
				listener.sai_committed(arg1.getState().getTerm(0).toString(), arg1.getState().getTerm(1).toString(), arg1.getState().getTerm(2).toString());
			}
		}
		else if(arg1.getState().getFunctor().equals("responsible")){			
			for(IGroup2SaiListener listener:groupListeners){
				listener.sai_responsible(arg1.getState().getTerm(0).toString(), arg1.getState().getTerm(1).toString());
			}
		}
		else if(arg1.getState().getFunctor().equals("formationStatusOk")){			
			//TODO: handle formation status 
		}		

		else{
			super.addStateAssignment(arg0, arg1);
		}
	}


}
