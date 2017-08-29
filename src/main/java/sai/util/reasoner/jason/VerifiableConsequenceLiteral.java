package sai.util.reasoner.jason;

import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;

/**
 * Adds the functionality of checking if the Literal is logical consequence of another one.
 * It allows, for example, to verify that "myPred(x)" is logical consequence of myPred(X)
 * @author maiquel
 *
 */

public class VerifiableConsequenceLiteral extends LiteralDecorator {

	
	private Agent ag = null;
	

	public VerifiableConsequenceLiteral(Literal literal){
		this.literal = parseLiteral(literal.toString());
	}


	/**
	 * Returns true when the instance of VerifiableConsequenceLiteral is logical consequence of "l"
	 * @throws ParseException
	 */
	public boolean isLogicalConsequenceOf(Literal l){
		if(ag==null){
			ag = new Agent();
			ag.initAg();
		}
		ag.getBB().clear();
		ag.getBB().add(literal);
		
		
		//TODO: usar a linha desativada (primeira abaixo). Ela foi desativada por causa de um problema  ao verificar a consequencia lógica na linha "if(violatedInstance.isLogicalConsequenceOf(next)){"
		//de NormativeReasonerHandler. O problema só foi resolvido (temporariamente) convertendo todos os literais para string
		
		
		
		
		//return l.logicalConsequence(ag, new Unifier()).hasNext();
		return parseLiteral(l.toString()).logicalConsequence(ag, new Unifier()).hasNext();
	}



}




