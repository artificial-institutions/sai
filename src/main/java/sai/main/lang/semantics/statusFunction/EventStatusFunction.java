package sai.main.lang.semantics.statusFunction;

import jason.asSyntax.Pred;


public class EventStatusFunction extends StatusFunction  implements IAchievableStatusFunction{

	
	public EventStatusFunction(Pred event) {
		super();
		setId(event);
	}

	public Pred getEvent() {
		return (Pred) getId();
	}

	public void setEvent(Pred event) {
		setId(event);
	}


	@Override
	public String toString() {
		return getId().toString();
	}



	


}
