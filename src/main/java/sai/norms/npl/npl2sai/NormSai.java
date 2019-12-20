package sai.norms.npl.npl2sai;


import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.createVar;
import static jason.asSyntax.ASSyntax.parseFormula;
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
		super(id, adaptHead(head, instProgram), adaptBody(head, body, instProgram));

	}


	private static Literal adaptHead(Literal head, InstProgram instProgram){
		Literal newHead = (Literal) head.clone();
		if(!head.getTerm(0).isVar())
			if(instProgram.getStatusFunctionByName(head.getTerm(0).toString())!=null)
				if(instProgram.getStatusFunctionByName(head.getTerm(0).toString()) instanceof AgentStatusFunction){
					//newHead = createLiteral(head.getFunctor(),createVar("Sai__Agent"),head.getTerm(1),head.getTerm(2),head.getTerm(3));
					newHead.setTerm(0, createVar("Sai__Agent"));
					//return newHead;
				}
		if(instProgram.getStatusFunctionByName(head.getTerm(2).toString())!=null)
			if(instProgram.getStatusFunctionByName(head.getTerm(2).toString()) instanceof EventStatusFunction){
				((Literal)head.getTerm(2)).addAnnot(createLiteral("sai__agent", createVar("Sai__Agent")));
				Literal event = createLiteral("sai__event", (Literal)head.getTerm(2));
				newHead.setTerm(2, event);
			}
		return newHead;
		//return head;
	}


	private static LogicalFormula adaptBody(Literal head, LogicalFormula body, InstProgram instProgram) throws ParseException{
		if(!head.getTerm(0).isVar())
			if(instProgram.getStatusFunctionByName(head.getTerm(0).toString())!=null)
				if(instProgram.getStatusFunctionByName(head.getTerm(0).toString()) instanceof AgentStatusFunction){
					//LogicalFormula newBody = parseFormula(body.toString()+"&(sai__is(Sai__Agent,"+head.getTerm(0).toString()+"))" );
					LogicalFormula newBody = parseFormula("(sai__is(Sai__Agent,"+head.getTerm(0).toString()+"))&" + body.toString() );
					return newBody;
				}
		if(instProgram.getStatusFunctionByName(body.toString()) instanceof EventStatusFunction ) {
			LogicalFormula newBody = parseFormula("sai__event("+body+"[sai__agent(Sai__Agent)])");
			return newBody;
		}
		return body;
	}


}
