package sai.main.lang.semantics.statusFunction;


import jason.asSyntax.Pred;


public class StateStatusFunction extends StatusFunction implements IAchievableStatusFunction{
	
	

	public StateStatusFunction(Pred state) {
		setId(state);
	}

	public Pred getState() {
		return (Pred) getId();
	}

	public void setState(Pred state) {
		setId(state);
	}

	@Override
	public String toString() {
		return getId().toString();
	}

	

}
