package sai.norms.npl.npl2sai;


import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.createVar;
import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.parser.ParseException;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import npl.Norm;

public class NormSai extends Norm {

	//TODO: hide constructor in the superclass??
	public NormSai(String id, Literal head, LogicalFormula body, InstProgram instProgram) throws ParseException {						
		super(id, adaptHead(head, body, instProgram), adaptBody(head, body, instProgram));
		
		

	}


	private static Literal adaptHead(Literal head, LogicalFormula body, InstProgram instProgram){
		Literal newHead = (Literal) head.clone();
		if(!head.getTerm(0).isVar())
			if(instProgram.getStatusFunctionByName(head.getTerm(0).toString())!=null)
				if(instProgram.getStatusFunctionByName(head.getTerm(0).toString()) instanceof AgentStatusFunction){
					//newHead = createLiteral(head.getFunctor(),createVar("Sai__Agent"),head.getTerm(1),head.getTerm(2),head.getTerm(3));
					newHead.setTerm(0, createVar("Sai__Agent"));
					//return newHead;
				}
		if(instProgram.getStatusFunctionByName(head.getTerm(2).toString())!=null)
			if(instProgram.getStatusFunctionByName(head.getTerm(2).toString()) instanceof EventStatusFunction){ //if the goal is an event-status function assigment (e,a)				
				((Literal)head.getTerm(2)).addAnnot(createLiteral("sai__agent", createVar("Sai__Agent"))); //the element "a" is the agent in charge to fulfill the norm
				Literal event = createLiteral("sai__event", (Literal)head.getTerm(2));
				newHead.setTerm(2, event);
			}
		//if the activation condition is an event, then the maintenance condition is set to true to permanently hold
		if(instProgram.getStatusFunctionByName(body.toString()) instanceof EventStatusFunction ) {
			newHead.setTerm(1, createLiteral("true"));
		}
		
		return newHead;
	}

	
	private static LogicalFormula adaptBody(Literal head, LogicalFormula body, InstProgram instProgram) throws ParseException{
		LogicalFormula newBody = body; 
		if(instProgram.getStatusFunctionByName(body.toString()) instanceof EventStatusFunction ) {
			System.out.println("[NormSai] adaptBody " + body + " is event");
			newBody = parseFormula("sai__event("+newBody+"[sai__agent(Sai__Agent)])");										
		}		
		if(!head.getTerm(0).isVar())
			if(instProgram.getStatusFunctionByName(head.getTerm(0).toString())!=null)
				if(instProgram.getStatusFunctionByName(head.getTerm(0).toString()) instanceof AgentStatusFunction){
					newBody = parseFormula("(sai__is(Sai__Agent,"+head.getTerm(0).toString()+"))&" + newBody.toString() );
				}				
		return newBody;
	}

	/*private static LogicalFormula adaptBody(Literal head, LogicalFormula body, InstProgram instProgram) throws ParseException{
		System.out.println("[NormSai] adaptBody 1" + body);
		if(!head.getTerm(0).isVar())
			if(instProgram.getStatusFunctionByName(head.getTerm(0).toString())!=null)
				if(instProgram.getStatusFunctionByName(head.getTerm(0).toString()) instanceof AgentStatusFunction){
					//LogicalFormula newBody = parseFormula(body.toString()+"&(sai__is(Sai__Agent,"+head.getTerm(0).toString()+"))" );
					LogicalFormula newBody = parseFormula("(sai__is(Sai__Agent,"+head.getTerm(0).toString()+"))&" + body.toString() );
					return newBody;
				}
		System.out.println("[NormSai] adaptBody 2" + body);
		if(instProgram.getStatusFunctionByName(body.toString()) instanceof EventStatusFunction ) {
			System.out.println("[NormSai] adaptBody " + body + " is event");
			LogicalFormula newBody = parseFormula("sai__event("+body+"[sai__agent(Sai__Agent)])");									
			return newBody;			
		}
		return body;
	}*/


}
