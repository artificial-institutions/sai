package sai.main.institution;

import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.createLiteral;
import jason.RevisionFailedException;
import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import sai.main.exception.SaiException;
import sai.main.lang.semantics.environment.Event;




public class Institution {

	
	private Agent sigma;
	
	public Institution(){
		super();
		sigma = new Agent();
		sigma.initAg();
	}
	
	
	/*
	 * Environmental events cannot have variables
	 */
	public void addEnvironmentalEvent(Event event) throws RevisionFailedException, SaiException{	
		Literal litEvent = event2literal(event);
		if(!litEvent.isGround()){
			throw new SaiException("Variables are not admitted in environmental events");
		}
		sigma.addBel(event2literal(event));
	}
	
	private Literal event2literal(Event event){
		Literal lit = createLiteral("happened", event.getName(),createAtom(event.getAgent().getName()));		
		return lit;
	}
	
	public boolean checkEvent(Event event){
		return sigma.believes(event2literal(event), new Unifier());
	}
	
	
}
