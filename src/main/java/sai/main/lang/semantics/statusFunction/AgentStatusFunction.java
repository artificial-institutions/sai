package sai.main.lang.semantics.statusFunction;

import jason.asSyntax.Atom;


public class AgentStatusFunction extends StatusFunction {
	
	//private Atom agent;

	public AgentStatusFunction(Atom agent)  {		
		setId(agent);
	}

	@Override
	public String toString() {		
		return getId().toString();
	}

	
	
}
