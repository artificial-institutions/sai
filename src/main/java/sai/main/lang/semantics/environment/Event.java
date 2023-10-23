package sai.main.lang.semantics.environment;

import jason.asSyntax.Pred;
import sai.main.lang.semantics.SaiElement;

public class Event extends SaiElement {

	private Pred name = null;	
	private Agent agent = null;
	
	public Event(){
		super();
	}
	
	public Event(Pred name, Agent agent) {
		super();
		this.name = name;
		this.agent = agent;
	}

	public Pred getName() {
		return name;
	}

	public void setName(Pred name) {
		this.name = name;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "("+name + ", " + agent.getName() + ")";
	}

	
	
}
