package sai.main.lang.semantics.environment;

import sai.main.lang.semantics.SaiElement;

/**
 * Represents an agent acting in the environment (belonging to $\Sigma_a$)
 * @author maiquel
 *
 */

public class Agent extends SaiElement {
	
	private String name = "";

	public Agent(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	

}
