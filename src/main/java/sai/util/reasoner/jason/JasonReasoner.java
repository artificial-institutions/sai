package sai.util.reasoner.jason;

import static jason.asSyntax.ASSyntax.createRule;
import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;

import java.util.Iterator;

import sai.util.reasoner.IReasoner;
import sai.util.reasoner.IReasonerGUI;
import jason.RevisionFailedException;
import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Rule;
import jason.asSyntax.parser.ParseException;

public class JasonReasoner implements IReasoner {

	private Agent agent;
	private Agent auxiliar;
	
	
	
	public JasonReasoner(){
		//this(new BasicReasonerHttpGUI(8001));
		agent = new Agent();
		agent.initAg();
		auxiliar = new Agent();
		auxiliar.initAg();
	}
	
	public JasonReasoner(IReasonerGUI gui){
		/*agent = new Agent();
		agent.initAg();
		auxiliar = new Agent();
		auxiliar.initAg();*/
		this();
		gui.addReasoner(this);
	}

	public synchronized void assertValue(String value) throws RevisionFailedException, ParseException  {		
		if(value.indexOf(":-")>-1){ //if the value is a rule
			assertRule(value);
		}else{		
			try {
				agent.addBel(parseLiteral(value));
			} catch (RevisionFailedException | ParseException e) {
				System.err.println("[JasonReasoner] Error asserting " + value);
			}				
		}		
	}
	
	

	private synchronized void assertRule(String value) throws ParseException, RevisionFailedException{
		Literal fHead = parseLiteral(value.substring(0,value.indexOf(":-")));
		LogicalFormula fBody = parseFormula(value.substring(value.indexOf(":-")+2));
		Rule rule = createRule(fHead, fBody);
		agent.addBel(rule);
	}

	

	public boolean check(String formula) throws ParseException {
		return agent.believes(parseFormula(formula), new Unifier());
	}

	public Iterator<Literal> getBeliefs() {
		return  this.agent.getBB().iterator();				 
	}

	public Iterator<Unifier> findall(String formula) throws Exception {
		return parseFormula(formula).logicalConsequence(agent, new Unifier());
	}

	public synchronized void retract(String value) throws Exception {
		Literal bel = parseLiteral(value);		
		agent.abolish(bel, new Unifier());
		assertValue("sigmaE(true)"); //trick to update beliefs of the agents. TODO: fix it 	
	}

	
	
	/**
	 * Returns true when "a" is logical consequence of "b"
	 * @param a
	 * @param b
	 * @return
	 * @throws ParseException
	 */
	/*public boolean isLogicalConsequence(Literal a, Literal b){
		auxiliar.getBB().clear();
		auxiliar.getBB().add(a);
		return b.logicalConsequence(auxiliar, new Unifier()).hasNext();
	}

	
	public boolean isLogicalConsequence(String a, String b) throws ParseException{
		return isLogicalConsequence(parseLiteral(a), parseLiteral(b));
	}
	*/

}


