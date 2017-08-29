package sai.norms.sai.normativeReasoner;
import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sai.util.reasoner.jason.VerifiableConsequenceLiteral;


/**
 * Implements the operational semantics of the normative engine
 * 
 * @author maiquel
 *
 */

public class NormativeReasonerHandler {

	private NormativeReasoner reasoner;
	private ArrayList<String> lastAdded = new ArrayList<String>(); 
	private ArrayList<String> lastRemoved  = new ArrayList<String>();
	private ArrayList<String> lastFulfilled  = new ArrayList<String>();
	private ArrayList<String> lastViolated  = new ArrayList<String>();

	public NormativeReasonerHandler(NormativeReasoner reasoner){
		this.reasoner = reasoner;		
	}

	public List<String> getLastAdded(){
		return this.lastAdded;
	}

	public List<String> getLastRemoved(){
		return this.lastRemoved;
	}

	public ArrayList<String> getLastFulfilled() {
		return lastFulfilled;
	}

	public ArrayList<String> getLastViolated() {
		return lastViolated;
	}

	private String adaptTerm(String term){
		return term.replaceAll("((_)(\\d)+(Var)?)+", "Var");
	}

	public void check() throws Exception{
		boolean changed;
		ArrayList<String> sToAdd = new ArrayList<String>();
		ArrayList<String> sToRemove = new ArrayList<String>();

		ArrayList<String> sToRemoveFulfillment = new ArrayList<String>();
		ArrayList<String> sToRemoveViolation = new ArrayList<String>();


		this.lastAdded.clear();		
		this.lastRemoved.clear();
		this.lastFulfilled.clear();
		this.lastViolated.clear();

		synchronized (reasoner) {


			do{			
				sToAdd.clear();
				sToRemove.clear();
				sToRemoveFulfillment.clear();
				sToRemoveViolation.clear();

				changed=false;	
				Iterator<Unifier> it = reasoner.findall("toAddObliged(A,I,Ca,Cd)");
				while(it.hasNext()){
					Unifier un = it.next();
					sToAdd.add("instance("+adaptTerm(un.get("A").toString())+",obliged,"   +adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					this.lastAdded.add("instance("+adaptTerm(un.get("A").toString())+",obliged,"+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
				}

				it = reasoner.findall("toAddProhibited(A,I,Ca,Cd)");
				while(it.hasNext()){
					Unifier un = it.next();
					sToAdd.add("instance("+adaptTerm(un.get("A").toString())+",prohibited,"+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					this.lastAdded.add("instance("+adaptTerm(un.get("A").toString())+",prohibited,"+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
				}

				it = reasoner.findall("fulfilled(A,D,I,Cd)");
				while(it.hasNext()){			
					Unifier un = it.next();
					sToAdd.add("fulfilled_instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					sToRemove.add("instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					lastFulfilled.add("instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString()+","+un.get("Cd").toString())+")");
				}

				it = reasoner.findall("violated(A,D,I,Cd)");
				while(it.hasNext()){				
					Unifier un = it.next();
					sToAdd.add("violated_instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					sToRemove.add("instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+(un.get("Cd").toString())+")");


					

					//check the instance that produced the violation				
					VerifiableConsequenceLiteral violatedInstance = new VerifiableConsequenceLiteral(parseLiteral("instance("+adaptTerm(un.get("A").toString())+","+un.get("D").toString()+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")"));							
					Iterator<Literal> instances = reasoner.getBeliefs();
					while(instances.hasNext()){			
						Literal next = instances.next();							
						next.delSources();																								
						if(next.getFunctor().toString().equals("instance")){
							if(violatedInstance.isLogicalConsequenceOf(next)){
								lastViolated.add(next.toString());
							}														
						}
					}


				}




				/*check the violated instances that does not make sense anymore, i.e. whose deadline is true*/
				it = reasoner.findall("fulfilled_instance(A,D,I,Cd)&Cd");
				while(it.hasNext()){			
					Unifier un = it.next();
					sToRemoveFulfillment.add("fulfilled_instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					//as the deadline is achieved, the instance can be removed
					lastRemoved.add("instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");

				}


				/*check the violated instances that does not make sense anymore, i.e. whose deadline is true*/
				it = reasoner.findall("violated_instance(A,D,I,Cd)&Cd");
				while(it.hasNext()){			
					Unifier un = it.next();
					sToRemoveViolation.add("violated_instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
					//as the deadline is achieved, the instance can be removed
					lastRemoved.add("instance("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("D").toString())+","+adaptTerm(un.get("I").toString())+","+adaptTerm(un.get("Cd").toString())+")");
				}




				for (String s:sToRemoveFulfillment){
					reasoner.retract(s);
				}

				for (String s:sToRemoveViolation){
					reasoner.retract(s);
				}

				//this.lastAdded.clear();
				for (String s:sToAdd){
					reasoner.assertValue(s);
				}

				//this.lastRemoved.clear();
				for (String s:sToRemove){
					reasoner.retract(s);
				}


			}
			while(sToAdd.size()>0|sToRemove.size()>0|sToRemoveFulfillment.size()>0|sToRemoveViolation.size()>0);
		}
	}

}
