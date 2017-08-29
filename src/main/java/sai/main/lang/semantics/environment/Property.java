package sai.main.lang.semantics.environment;

import jason.asSyntax.Pred;
import sai.main.lang.semantics.SaiElement;

public class Property extends SaiElement {
	
	private Pred name = null;

	public Property(Pred name) {
		super();
		this.name = name;
	}

	public Pred getName() {
		return name;
	}

	public void setName(Pred name) {
		this.name = name;
	}
	
	

}
