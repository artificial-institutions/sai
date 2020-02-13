package sai.main.institution;

import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.InstProgram_Reasoner;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;

public class SaiEngine/* implements Observer */{

	private InstProgram program;
	private ConcurrentLinkedQueue<Literal> environmentQueue = new ConcurrentLinkedQueue<Literal>();
	private ConstitutiveReasoner envHandler;


	public SaiEngine(){		
		envHandler = new ConstitutiveReasoner(environmentQueue);
		this.program = new InstProgram_Reasoner(envHandler.getReasoner());
		//this.program.addObserver(this);
		
		envHandler.start();
		
		
	}

	/**
	 * Returns the institutional program of the institution 
	 * @return
	 */
	public InstProgram getProgram() {
		return program;
	}
	
	/**
	 * Connects a normative engine to the SAI. 
	 * The connected normative engine is informed about the changes in the constitutive state. 
	 * @param normativeEngine
	 */
	public void addNormativeEngine(INormativeEngine normativeEngine){
		this.addConstitutiveListener(normativeEngine);
		this.envHandler.addNormativeEngine(normativeEngine);

		//update the normativeEngine with the current constitutive state
		try {
			Iterator<Unifier> un = envHandler.getReasoner().findall("sai__is(X,Y,M)");
			while(un.hasNext()) {
				Unifier current = un.next();
				normativeEngine.addStateAssignment(current.get("X").toString(), new StateStatusFunction(new Pred(parseLiteral(adaptTerm(current.get("Y").toString())))));
				normativeEngine.updateState();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Add a new environmental agent to $\X_a$. T
	 * The new agent identifier is properly formatted according to the Constitutive Reasoner patterns
	 * @param event
	 */
	public void addEnvironmentalAgent(Literal agent){
		Literal agentToAdd = createLiteral("sigmaA", agent);
		try {
			if(!envHandler.getReasoner().check(agentToAdd.toString()))
			   this.environmentQueue.add(agentToAdd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Add a new environmental event to $\X_e$. T
	 * The new event is properly formatted according to the Reasoner patterns
	 * @param event
	 */
	public void addEnvironmentalEvent(Literal event, Atom agent){
		this.addEnvironmentalAgent(agent); //the agent must be added before the event because when the reason reasons about the event, it must "know" the agent.
		Pred annot = new Pred(createLiteral("sai__agent"));
		annot.addTerm(agent);
		event.addAnnot(annot);		
		Literal eventToAdd = createLiteral("sigmaE", event);				
		this.environmentQueue.add(eventToAdd);		
	}



	/**
	 * Add a new environmental event to $\X_a$. T
	 * The new event is properly formatted according to the Constitutive Reasoner patterns
	 * @param event
	 */
	public void addEnvironmentalProperty(Literal prop) throws Exception{
		this.environmentQueue.add(prop);
	}

	public void removeEnvironmentalProperty(Literal prop) throws Exception{
		this.environmentQueue.add(createLiteral("retract", prop));
	}


	/**
	 * Replaces, in the constitutive reasoner, the oldProp by the newProp. The reasoning occurs only when the replacement is done.  
	 * 
	 * @param oldProp
	 * @param newProp
	 */
	public void replaceEnvironmentalProperty(Literal oldProp, Literal newProp){
		Literal lit = createLiteral("sai__replace", oldProp,newProp);
		this.environmentQueue.add(lit);
	}



	private String adaptTerm(String term){
		return term.replaceAll("((_)(\\d)+(Var)?)+", "Var");
	}
	
	public void addConstitutiveListener(ConstitutiveListener listener){
		this.envHandler.addConstitutiveListener(listener);
		try {
			Iterator<Unifier> it = this.envHandler.getReasoner().findall("sai__is(X,Y,M)&sai__af(Y)");			
			while(it.hasNext()){
				Unifier un = it.next();
				listener.addAgentAssignment(adaptTerm(un.get("X").toString()), new AgentStatusFunction(createAtom(adaptTerm(un.get("Y").toString()))));
			}
			it = this.envHandler.getReasoner().findall("sai__is(X,Y,M)&sai__sf(Y)");
			while(it.hasNext()){
				Unifier un = it.next();
				listener.addStateAssignment(adaptTerm(un.get("X").toString()), new StateStatusFunction(new Pred(parseLiteral(adaptTerm(un.get("Y").toString())))));
			}
			it = this.envHandler.getReasoner().findall("sai__is(X,Y,A,M)&sai__ef(Y)");
			while(it.hasNext()){
				Unifier un = it.next();
				listener.addEventAssignment(adaptTerm(un.get("X").toString()), new EventStatusFunction(new Pred(parseLiteral(adaptTerm(un.get("Y").toString())))),  createAtom(adaptTerm(un.get("A").toString())));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


/*
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof InstProgram){ 
			try {
				this.addEnvironmentalProperty(createLiteral("program_updated"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

*/	
	/**
	 * Returns a List with all the assignments. The assignments are given as a predicate sai__is(X,Y,M).
	 * @return
	 */
	public List<Literal> getConstitutiveState(){
		ArrayList<Literal> result = new ArrayList<Literal>();
		Iterator<Literal> it = envHandler.getReasoner().getBeliefs();
		while(it.hasNext()){
			Literal l = it.next();
			l.delSources();
			if(l.getFunctor().toString().equals("sai__is")){
				result.add(l);
			}
		}
		return result;
	}

	public ArrayList<Literal> getCurrentState(){
		ArrayList<Literal> result = new ArrayList<Literal>();
		Iterator<Literal> it = envHandler.getReasoner().getBeliefs();
		while(it.hasNext()){
			Literal l = it.next();
			l.delSources();
			if((!l.getFunctor().toString().equals("sai__af"))&
					(!l.getFunctor().toString().equals("sai__ef"))&
					(!l.getFunctor().toString().equals("sai__sf"))&
					(!l.getFunctor().toString().equals("sai__norm"))&
					(!l.getFunctor().toString().equals("sai__crule"))&
					(!l.getFunctor().toString().equals("inGa"))&
					(!l.getFunctor().toString().equals("inGe"))&
					(!l.getFunctor().toString().equals("inGs"))&
					(!l.getFunctor().toString().equals("sai__is"))&
					(!l.getFunctor().toString().equals("sai__freestandingY"))&
					(!l.getFunctor().toString().equals("program_updated"))&
					(!l.getFunctor().toString().equals("true"))&
					(!l.isRule())
					)
				result.add(l);
		}		
		return result;
	}

}
