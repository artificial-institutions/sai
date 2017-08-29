package sai.main.institution;

import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;

/**
 * A (class implementing) ConstitutiveListener listens the updates in the constitutive state
 * 
 * @author maiquel
 *
 */


public interface ConstitutiveListener {
	public void addStateAssignment(String assignee, StateStatusFunction sf);
	public void addAgentAssignment(String assignee, AgentStatusFunction sf);
	public void addEventAssignment(String assignee, EventStatusFunction sf, AgentStatusFunction agent);
	
	public void removeStateAssignment(String assignee, StateStatusFunction sf);
	public void removeAgentAssignment(String assignee, AgentStatusFunction sf);
	public void removeEventAssignment(String assignee, EventStatusFunction sf, AgentStatusFunction agent);

}
