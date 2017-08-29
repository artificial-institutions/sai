package sai.main.institution;

import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import sai.util.reasoner.BasicReasonerHttpGUI;
import sai.util.reasoner.jason.JasonReasoner;
import sai.main.log.SaiLogger;
import sai.main.lang.parser.FormulaAdapter;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;


/**
 * Implements the strategy of updating the constitutive and normative states
 * @author maiquel
 *
 */
public class ConstitutiveReasoner extends Thread {

	private JasonReasoner reasoner;
	private AbstractQueue<Literal> queue;
	private int globalCicle = 0;
	private SaiLogger logger = SaiLogger.getInstance();
	//private ArrayList<ConstitutiveListener> constitutiveListeners = new ArrayList<ConstitutiveListener>();
	private CopyOnWriteArrayList<ConstitutiveListener> constitutiveListeners = new CopyOnWriteArrayList<ConstitutiveListener>();
	//private NormativeReasoner2Sai norm2sai = NormativeReasoner2Sai.getInstance();
	private ArrayList<INormativeEngine> normativeEngines = new ArrayList<INormativeEngine>(); //the list of normative engines on top of the constitutive state



	public ConstitutiveReasoner(AbstractQueue<Literal> queue) {
		super();
		//this.reasoner = reasoner;
		this.reasoner = new JasonReasoner(new BasicReasonerHttpGUI(8003));
		this.queue = queue;
		//addConstitutiveListener(NormativeReasoner2Sai.getInstance());

		try {
			this.reasoner.assertValue("sigmaE(true)");
			this.reasoner.assertValue("sai__freestandingY");
			//this.reasoner.assertValue("inGa(Ag,Sf,M):- sai__crule(Ag,Sf,T,M)&T&sai__af(Sf)&sigmaA(Ag)&not(sai__is(Ag,Sf,M))&M");
			this.reasoner.assertValue("inGa(Ag,Sf,M):- sai__crule(Ag,Sf,T,M)&T&M&sai__af(Sf)&sigmaA(Ag)&not(sai__is(Ag,Sf,M))");
			//this.reasoner.assertValue("inGs(St,Sf,M):- sai__crule(St,Sf,T,M)&T&sai__sf(Sf)&not(sai__is(St,S)&M&Stf,M)");
			this.reasoner.assertValue("inGs(St,Sf,M):- sai__crule(St,Sf,T,M)&T&sai__sf(Sf)&M&St&not(sai__is(St,Sf,M))");
			//this.reasoner.assertValue("inGe(event(Ev),Ef,TriggerAgent,M):-sai__crule(event(Ev),Ef,T,M)&sai__ef(Ef)&(sigmaE(Ev[sai__agent(TriggerAgent)]))&T&M&not(sai__is(event(Ev),Ef,TriggerAgent,M))");			
			this.reasoner.assertValue("inGe(event(Ev),Ef,TriggerAgent,M):-sai__crule(event(Ev),Ef,T,M)&sai__ef(Ef)&(sigmaE(Ev[sai__agent(TriggerAgent)]))&T&M&not(sai__is(event(Ev),Ef,TriggerAgent,_))");
			//this.reasoner.assertValue("to_remove(X,Y,M):-sai__is(X,Y,M)&(((sai__af(Y)|sai__sf(Y))&(not(M)|(sai__sf(Y)&not(X))))|sai__ef(Y))");
			this.reasoner.assertValue("to_remove_agent(X,Y,M):-sai__is(X,Y,M)&sai__af(Y)&not(M)");
			//this.reasoner.assertValue("to_remove_state(X,Y,M):-sai__is(X,Y,M)&(((sai__sf(Y))&(not(M)|(sai__sf(Y)&not(X)))))");
			this.reasoner.assertValue("to_remove_state(X,Y,M):-sai__is(X,Y,M)&sai__sf(Y)&(not(M)|not(X))"); //the term X is included in the term M when the rule is added to InstProgram_Reasoner
			this.reasoner.assertValue("to_remove_event(X,Y,A):-sai__is(X,Y,A)&sai__ef(Y)");
			this.reasoner.assertValue("to_activate(A,D,I,C,O,R):-sai__norm(A,D,I,C,O,R)&sai__ef(C)&sai__is(_,C,_,_)");
			this.reasoner.assertValue("violated(A,obliged,I,C,O,R):-sai__active__norm(A,obliged,I,C,O,R)&R&not(I)");
			//this.reasoner.assertValue("violated(A,prohibited,I,C,O,R):-sai__active__norm(A,D,I,C,O,R)&not(R)&(I)");
			this.reasoner.assertValue("violated(A,prohibited,I,C,O,R):-sai__active__norm(A,D,I,C,O,R)&not(R)&I&sai__is(Agent,A,_)&not(sai__ef(I))"); //not valid when the aim is event-sf
			this.reasoner.assertValue("violated(A,prohibited,I,C,O,R):-sai__active__norm(A,D,I,C,O,R)&not(R)&sai__is(event(XX),I,Agent,_)&sai__is(Agent,A,_)&sai__ef(I)");
			this.reasoner.assertValue("fulfilled(A,obliged,I,C,O,R):-sai__active__norm(A,D,I,C,O,R)&not(R)&I");
			this.reasoner.assertValue("fulfilled(A,prohibited,I,C,O,R):-sai__active__norm(A,D,I,C,O,R)&R&not(I)");
			this.reasoner.assertValue("to_remove_norm(A,D,I,C,O,R):-sai__active__norm(A,D,I,C,O,R)&((D==obliged&(I|R))|(D==prohibited&R))");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JasonReasoner getReasoner(){
		return this.reasoner;
	}



	public void addConstitutiveListener(ConstitutiveListener listener){
		this.constitutiveListeners.add(listener);
	}

	public void removeConstitutiveListener(ConstitutiveListener listener){
		this.constitutiveListeners.remove(listener);
	}

	public void addNormativeEngine(INormativeEngine engine){
		this.normativeEngines.add(engine);
	}

	public void removeNormativeEngine(INormativeEngine engine){
		this.normativeEngines.remove(engine);
	}


	private String adaptTerm(String term){
		return term.replaceAll("((_)(\\d)+(Var)?)+", "Var");
	}


	@Override
	public void run(){
		Literal s;
		while(true){
			globalCicle++;
			s = queue.poll();
			if(s!=null){
				logger.finest("***** Started cycle #" + globalCicle + " *****");
				logger.finest("[cycle "+globalCicle+ "] environmental fact: " + s);
				try {
					
					if(s.getFunctor().equals("retract")){
						reasoner.retract(s.getTerm(0).toString());
					}
					else
						if(s.getFunctor().equals("sai__replace")){	
							reasoner.retract(s.getTerm(0).toString());
							reasoner.assertValue(s.getTerm(1).toString());
						}
						else
							reasoner.assertValue(s.toString());
				
					calculate();

				} catch (Exception e) {				
					e.printStackTrace();
				}
			}
			else{
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}
	}


	private synchronized void calculate() throws Exception{
		boolean changed;		
		int cicle=0;
		ArrayList<String> sToAdd = new ArrayList<String>();
		ArrayList<String> sToRemove = new ArrayList<String>();
		synchronized (reasoner) {
			//when a new constitutive state is calculated, event assignments are dropped
			//first, remove the assignments from the listeners
			Iterator<Unifier> toRemoveEvents = reasoner.findall("sai__is(X,Y,A,H)");
			while(toRemoveEvents.hasNext()){
				Unifier un = toRemoveEvents.next();
				for( ConstitutiveListener l : constitutiveListeners){					
					l.removeEventAssignment(un.get("X").toString(), new EventStatusFunction(new Pred(parseLiteral(un.get("Y").toString()))),new AgentStatusFunction(createAtom(un.get("A").toString())));
				}
			}
			//after, remove from the internal constitutive state representation
			reasoner.retract("sai__is(X,Y,A,H)");
			do{
				changed=false;


				Iterator<Unifier> it = reasoner.findall("inGa(X,Y,M)");
				String assignee = "";
				while(it.hasNext()){				
					Unifier un = it.next();					
					if(reasoner.check( adaptTerm(un.get("M").toString()))){
						changed=true;
						if(un.get("X")!=null){
							sToAdd.add("sai__is("+ adaptTerm(un.get("X").toString()) + ","+ adaptTerm(un.get("Y").toString())+","+adaptTerm(un.get("M").toString())  +")");
							assignee = adaptTerm(un.get("X").toString());
						}
						else{
							sToAdd.add("sai__is(_,"+ adaptTerm(un.get("Y").toString())+","+ adaptTerm(un.get("M").toString())  +")");
							assignee = "_";							
						}

						for( ConstitutiveListener l : constitutiveListeners){
							l.addAgentAssignment(assignee, new AgentStatusFunction(createAtom(adaptTerm(un.get("Y").toString()))));

						}
					}				
				}

				it = reasoner.findall("inGs(X,Y,M)");
				while(it.hasNext()){				
					Unifier un = it.next();
					if(reasoner.check( adaptTerm(un.get("M").toString()))){
						changed=true;
						if(un.get("X")!=null){
							sToAdd.add("sai__is("+ adaptTerm(un.get("X").toString()) + ","+ adaptTerm(un.get("Y").toString())+","+FormulaAdapter.adaptFormula1(adaptTerm(un.get("M").toString()),false)+")");
							assignee = adaptTerm(un.get("X").toString());
							
						}
						else{
							sToAdd.add("sai__is(_,"+ adaptTerm(un.get("Y").toString())+","+FormulaAdapter.adaptFormula1(adaptTerm(un.get("M").toString())) +")");						
							assignee = "_";
						}						
																	
						for( ConstitutiveListener l : constitutiveListeners){
							l.addStateAssignment(assignee, new StateStatusFunction(new Pred(parseLiteral(adaptTerm(un.get("Y").toString())))));
						}						
					}



				}

				it = reasoner.findall("inGe(X,Y,A,M)");
				while(it.hasNext()){								
					Unifier un = it.next();		
					changed=true;
					if(un.get("X")!=null)
						sToAdd.add("sai__is("+ adaptTerm(un.get("X").toString()) + ","+ adaptTerm(un.get("Y").toString())+","+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("M").toString())  +")");
					else
						sToAdd.add("sai__is(_,"+ adaptTerm(un.get("Y").toString())+","+adaptTerm(un.get("A").toString()) +","+adaptTerm(un.get("M").toString()) +")");
					
					for( ConstitutiveListener l : constitutiveListeners){
						l.addEventAssignment(adaptTerm(un.get("X").toString()), new EventStatusFunction(new Pred(parseLiteral(un.get("Y").toString()))),new AgentStatusFunction(createAtom(adaptTerm(un.get("A").toString()))));
					}
				}






				//remove assignments that does not make sense anymore
				Iterator<Unifier> toRemove = reasoner.findall("to_remove_agent(X,Y,M)");			
				while(toRemove.hasNext()){					
					changed=true;
					Unifier un = toRemove.next();
					if(un.get("X")!=null)
						sToRemove.add("sai__is("+ adaptTerm(un.get("X").toString()) + ","+ adaptTerm(un.get("Y").toString())+","+adaptTerm(un.get("M").toString())  +")");
					else
						sToRemove.add("sai__is(_,"+ adaptTerm(un.get("Y").toString())+","+(un.get("M").toString())  +")");

					for( ConstitutiveListener l : constitutiveListeners){
						l.removeAgentAssignment(adaptTerm(un.get("X").toString()), new AgentStatusFunction(createAtom(adaptTerm(un.get("Y").toString()))));
					}
				}

				toRemove = reasoner.findall("to_remove_state(X,Y,M)");			
				while(toRemove.hasNext()){					
					changed=true;
					Unifier un = toRemove.next();
					if(un.get("X")!=null)
						sToRemove.add("sai__is("+ adaptTerm(un.get("X").toString()) + ","+ adaptTerm(un.get("Y").toString())+","+adaptTerm(un.get("M").toString())  +")");
					else
						sToRemove.add("sai__is(_,"+ adaptTerm(un.get("Y").toString())+","+adaptTerm(un.get("M").toString())  +")");

					String sAssignee;
					if(un.get("X")!=null)
						sAssignee = adaptTerm(un.get("X").toString());
					else
						sAssignee = "_"; 
					StateStatusFunction pStateSf = new StateStatusFunction(new Pred(parseLiteral(adaptTerm(un.get("Y").toString()))));
					

				
					for( ConstitutiveListener l : constitutiveListeners){
						l.removeStateAssignment(sAssignee, pStateSf);						
					}

				}

				/*
				//remove assignments that does not make sense anymore - events
				Iterator<Unifier> toRemoveEvents = reasoner.findall("to_remove_event(X,Y,A)");			
				while(toRemoveEvents.hasNext()){					
					changed=true;
					Unifier un = toRemove.next();
					System.out.s("[EnvironmentalHandler] Unifier events " + un.toString() );
					if(un.get("X")!=null)
						sToRemove.add("sai__is("+ un.get("X").toString() + ","+ un.get("Y").toString()+ ","+ un.get("A").toString()+","+un.get("M")  +")");
					else
						sToRemove.add("sai__is(_,"+ un.get("Y").toString()+ ","+ un.get("A").toString()+","+un.get("M")  +")");

					for( ConstitutiveListener l : constitutiveListeners){
						System.out.println("[EnvironmentalHandler] Vai remover" + un.get("Y").toString());
						l.removeEventAssignment(un.get("X").toString(), new EventStatusFunction(new Pred(parseLiteral(un.get("Y").toString()))),new AgentStatusFunction(createAtom(un.get("A").toString())));
					}
				}*/



				cicle++;				
				for(String s:sToAdd){
					logger.finest("[cycle "+globalCicle+ "] " + cicle + " adding " + s);
					reasoner.assertValue(s);
				}				
				sToAdd.clear();
				for(String s:sToRemove){
					logger.finest("[cycle "+globalCicle+ "] " + cicle + " removing " + s);
					reasoner.retract(s);
				}	
				sToRemove.clear();




			}while(changed==true);

			sToRemove.clear();
			reasoner.retract("sigmaE(X)");
			reasoner.assertValue("sigmaE(true)");



			//NormativeReasoner2Sai.getInstance().updateState();			
			for(INormativeEngine nEngine : normativeEngines){
				nEngine.updateState();
			}

			/*do{
				changed =false;
				//******* Norms ******
				//After updating the constitutive state, updates the normative state

				sToAdd.clear();
				sToRemove.clear();

				Iterator<Unifier> toActivate = reasoner.findall("to_activate(A,D,I,C,O,R)&not(sai__active__norm(A,D,I,C,O,R))");
				while(toActivate.hasNext()){
					changed = true;
					Unifier un = toActivate.next();
					sToAdd.add("sai__active__norm("+un.get("A")+","+
							un.get("D")+","+
							un.get("I")+","+
							un.get("C")+","+
							un.get("O")+","+
							un.get("R")+
							")");

				}

				Iterator<Unifier> toViolate= reasoner.findall("violated(A,D,I,C,O,R)&not(sai__violated__norm(A,D,I,C,O,R))");
				while(toViolate.hasNext()){
					changed = true;
					Unifier un = toViolate.next();
					sToAdd.add("sai__violated__norm("+un.get("A")+","+
							un.get("D")+","+
							un.get("I")+","+
							un.get("C")+","+
							un.get("O")+","+
							un.get("R")+
							")");

				}

				Iterator<Unifier> toRemoveNorm= reasoner.findall("to_remove_norm(A,D,I,C,O,R)");
				while(toRemoveNorm.hasNext()){				
					changed = true;
					Unifier un = toRemoveNorm.next();
					sToRemove.add("sai__active__norm("+un.get("A")+","+
							un.get("D")+","+
							un.get("I")+","+
							un.get("C")+","+
							un.get("O")+","+
							un.get("R")+
							")");
				}


				for(String s:sToAdd){
					logger.finest("[cycle "+globalCicle+ "] " + cicle + " adding " + s);
					reasoner.assertValue(s);
				}
				sToAdd.clear();
				for(String s:sToRemove){
					logger.finest("[cycle "+globalCicle+ "] " + cicle + " removing " + s);
					reasoner.retract(s);
				}

				//cicle++;						
			}while(changed==true);*/
		}//synchronized

	}




}

