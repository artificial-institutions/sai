package sai.main.lang.semantics;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import static jason.asSyntax.ASSyntax.parseLiteral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import sai.norms.sai.semantics.Norm;
import sai.main.exception.SaiException;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.main.lang.semantics.statusFunction.StatusFunction;


/**
 * This class represents an institutional program
 * 
 * 
 * @author maiquel
 *
 */
public class InstProgram extends Observable {
	Map<Integer, Norm> norms = new HashMap<Integer, Norm>();
	Map<Integer, AgentStatusFunction> agentStatusFunctions = new HashMap<Integer, AgentStatusFunction>();
	Map<Integer, EventStatusFunction> eventStatusFunctions = new HashMap<Integer, EventStatusFunction>();
	Map<Integer, StateStatusFunction> stateStatusFunctions = new HashMap<Integer, StateStatusFunction>();
	Map<Integer, ConstitutiveRule> constitutiveRules = new HashMap<Integer, ConstitutiveRule>();	
	Map<Integer, Literal> relevantEvent = new HashMap<Integer, Literal>();


	public InstProgram(){
	}



	
	public StatusFunction addStatusFunction(StatusFunction sf)throws Exception {
		if (sf instanceof AgentStatusFunction) {
			agentStatusFunctions.put(sf.hashCode(), (AgentStatusFunction) sf);

		}else
			if (sf instanceof EventStatusFunction) {
				eventStatusFunctions.put(sf.hashCode(), (EventStatusFunction) sf);

			}else
				if (sf instanceof StateStatusFunction) {
					stateStatusFunctions.put(sf.hashCode(), (StateStatusFunction) sf);

				}
		notifyObservers(this);
		return sf;
	}


	public ConstitutiveRule addConstitutiveRule(ConstitutiveRule crule) throws Exception{
		if(getStatusFunctionByName(crule.getY().toString())==null){
			throw new SaiException("Invalid status function: " + crule.getY().toString());
		}	
		constitutiveRules.put(crule.hashCode(), crule);		
		this.setChanged();		
		notifyObservers(this);
		return crule;
	}







	@Override
	public String toString(){

		String s = "\n\nagents: \n";
		Iterator<AgentStatusFunction> agentsIterator = this.agentStatusFunctions.values().iterator();
		while(agentsIterator.hasNext()){
			s = s.concat(agentsIterator.next().toString());
			if(agentsIterator.hasNext())
				s = s.concat(",");
			else
				s = s.concat(".");
		}	

		s = s.concat("\n\nevents: \n");
		Iterator<EventStatusFunction> eventsIterator = this.eventStatusFunctions.values().iterator();
		while(eventsIterator.hasNext()){
			s = s.concat(eventsIterator.next().toString());
			if(eventsIterator.hasNext())
				s = s.concat(",");
			else
				s = s.concat(".");
		}	

		s = s.concat("\n\nstates: \n");
		Iterator<StateStatusFunction> stateIterator = this.stateStatusFunctions.values().iterator();
		while(stateIterator.hasNext()){
			s = s.concat(stateIterator.next().toString());
			if(stateIterator.hasNext())
				s = s.concat(",");
			else
				s = s.concat(".");
		}	

		s = s.concat("\n\nnorms: \n");
		Iterator<Norm> normIterator = this.norms.values().iterator();
		while(normIterator.hasNext()){
			s = s.concat(normIterator.next().toString()).concat(".").concat("\n");
		}

		s = s.concat("\n\nconstitutive_rules: \n");
		Iterator<ConstitutiveRule> cruleIterator = this.constitutiveRules.values().iterator();
		while(cruleIterator.hasNext())
			s = s.concat(cruleIterator.next().toString()).concat("\n");

		return s;
	}

	/**
	 * Returns a map with all status functions of the program
	 * @return
	 */

	private Map<Integer, StatusFunction> getStatusFunctions(){
		Map<Integer, StatusFunction> result = new HashMap<Integer, StatusFunction>();
		result.putAll(agentStatusFunctions);
		result.putAll(eventStatusFunctions);
		result.putAll(stateStatusFunctions);
		return result;
	}



	/* (non-Javadoc)
	 * @see lang.semantics.InstProgram#getStatusFunctionByName(java.lang.String)
	 */
	/*
	 * Test cases:
	 * 1. Try to get an agent sf that exists in the program
	 * 2. Try to get an agent sf that does not exist in the program
	 * 3. Try to get an event sf that exists in the program
	 * 4. Try to get an event sf that does not exist in the program
	 * 5. Try to get an state sf that exists in the program
	 * 6. Try to get an state sf that does not exist in the program
	 */
	public StatusFunction getStatusFunctionByName(String name){

		StatusFunction result = null;
		AgentStatusFunction agent = new AgentStatusFunction(new Atom(name));
		result = agentStatusFunctions.get(agent.hashCode()); //agent-status functions does not have arguments. Just check if exists
		if(result!=null)
			return result;

		//if the result is null, checks the event-status functions 
		EventStatusFunction event;
		try {

			event = new EventStatusFunction(new Pred(parseLiteral(name)));
			//get all event-status functions
			Collection<EventStatusFunction> eventSfs = eventStatusFunctions.values();
			Iterator<EventStatusFunction> eventSfsIt = eventSfs.iterator();
			//iterating over the event-status functions
			while(eventSfsIt.hasNext()){
				EventStatusFunction currentEventSf = eventSfsIt.next();
				if(currentEventSf.getEvent().getFunctor().equals(event.getEvent().getFunctor())){
					if(currentEventSf.getEvent().getTerms().size()==event.getEvent().getTerms().size()){						
						boolean find = true;
						if(currentEventSf.getEvent().getTerms().size()>0) 
							for(int i=0;i<currentEventSf.getEvent().getTerms().size();i++){
								if((!currentEventSf.getEvent().getTerms().get(i).isVar())& //if both are var
										(!currentEventSf.getEvent().getTerms().get(i).toString().equals(event.getEvent().getTerms().get(i).toString()))){ //if they are not var, must be equal terms
									find = false;
									break;
								}

							}
						if(find==true){
							return event;
						}
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}


		//if the result is null, checks the state-status functions 
		StateStatusFunction state;
		try {
			state = new StateStatusFunction(new Pred(parseLiteral(name)));
			//get all event-status functions
			Collection<StateStatusFunction> stateSfs = stateStatusFunctions.values();
			Iterator<StateStatusFunction> stateSfsIt = stateSfs.iterator();
			//iterating over the event-status functions
			while(stateSfsIt.hasNext()){
				StateStatusFunction currentStateSf = stateSfsIt.next();
				if(currentStateSf.getState().getFunctor().equals(state.getState().getFunctor()))
					if(currentStateSf.getState().getTerms().size()==state.getState().getTerms().size()){
						boolean find = true;
						if(currentStateSf.getState().getTerms().size()>0){
							for(int i=0;i<currentStateSf.getState().getTerms().size();i++){							
								if((!currentStateSf.getState().getTerms().get(i).isVar())& //if both are var
										(!currentStateSf.getState().getTerms().get(i).equals(state.getState().getTerms().get(i)))){ //if they are not var, must be equal terms
									find = false;
									break;
								}							
							}
						}
						if(find==true){
							return state;
						}
					}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	

	public List<ConstitutiveRule> getConstitutiveRules(){
		Iterator<ConstitutiveRule> it = this.constitutiveRules.values().iterator();
		ArrayList<ConstitutiveRule> list = new ArrayList<ConstitutiveRule>();
		while(it.hasNext()){
			list.add(it.next());
		} 
		return list;
	}
	

}




