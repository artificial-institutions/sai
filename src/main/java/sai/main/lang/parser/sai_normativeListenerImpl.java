package sai.main.lang.parser;


import static jason.asSyntax.ASSyntax.parseFormula;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Atom;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.parser.ParseException;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.IAchievableStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.norms.sai.NormativeReasoner2Sai;
import sai.norms.sai.semantics.Deontic;
import sai.norms.sai.semantics.Norm;
import sai.norms.sai.semantics.Obligation;
import sai.norms.sai.semantics.Permission;
import sai.norms.sai.semantics.Prohibition;

import org.antlr.v4.runtime.misc.NotNull;

public class sai_normativeListenerImpl extends sai_normativeBaseListener {

	//private InstProgram instProgram;
	private NormativeReasoner2Sai normativeReasoner;

	/*public sai_normativeListenerImpl(InstProgram instProgram) {
		super();
		this.instProgram = instProgram;
	}*/

	public sai_normativeListenerImpl(NormativeReasoner2Sai normativeReasoner) {
		super();
		this.normativeReasoner = normativeReasoner;
	}







	/*
	@Override public void enterAgent_sf_decl(@NotNull sai_normativeParser.Agent_sf_declContext ctx) { 
		currentState = "agent_sf";
	}

	@Override public void exitAgent_sf_decl(@NotNull sai_normativeParser.Agent_sf_declContext ctx) { 
		currentState = "";
	}


	@Override public void exitAgent_sf(@NotNull sai_normativeParser.Agent_sfContext ctx) { 
		if(currentState=="agent_sf"){
			try {
				instProgram.addStatusFunction(new AgentStatusFunction(createAtom(ctx.getText().toString())));
			} catch (RevisionFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override public void enterEvent_sf_decl(@NotNull sai_normativeParser.Event_sf_declContext ctx) { 
		currentState = "event_sf";
	}

	@Override public void exitEvent_sf_decl(@NotNull sai_normativeParser.Event_sf_declContext ctx) { 
		currentState = "";
	}

	@Override public void exitEvent_sf(@NotNull sai_normativeParser.Event_sfContext ctx) { 
		if(currentState=="event_sf")
			try {
				instProgram.addStatusFunction(new EventStatusFunction(new Pred(parseLiteral(ctx.getText().toString()))));
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (RevisionFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override public void enterState_sf_decl(@NotNull sai_normativeParser.State_sf_declContext ctx) { 
		currentState = "state_sf";
	}

	@Override public void exitState_sf_decl(@NotNull sai_normativeParser.State_sf_declContext ctx) { 
		currentState = "";
	}

	@Override public void exitState_sf(@NotNull sai_normativeParser.State_sfContext ctx) { 
		if(currentState=="state_sf")
			try {
				instProgram.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral(ctx.getText().toString()))));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RevisionFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 */
	@Override public void exitNorm(@NotNull sai_normativeParser.NormContext ctx) {
		LogicalFormula condition = null;
		Atom attribute = null;
		//LogicalFormula aim = null;
		IAchievableStatusFunction aim;
		LogicalFormula orElse = null;
		LogicalFormula deadline = null;
		Deontic deontic = null;
		try {
			if(ctx.condition() == null){


				condition = parseFormula("true");



			}else{
				//condition = parseFormula(ctx.condition().getText());

				//the visitor check formulas and tranform "is" expressions in predicates.
				//for example, "bob is house_owner" becomes is(bob,house_owner,_); 
				NormativeFormulaVisitor visitor = new NormativeFormulaVisitor();				
				//visitor.visit(ctx.condition());
				visitor.visitSf_formula(ctx.condition().sf_formula());
				condition = parseFormula(visitor.getFormula());


			}

			attribute = ASSyntax.createAtom(ctx.attribute().getText());
			/*if(instProgram.getStatusFunctionByName(ctx.aim().getText()) instanceof EventStatusFunction |
			   instProgram.getStatusFunctionByName(ctx.aim().getText()) instanceof StateStatusFunction ){
				aim = (IAchievableStatusFunction) instProgram.getStatusFunctionByName(ctx.aim().getText()); 
			}else{
				aim = null;				
			}*/
			
			if(normativeReasoner.getInstitutionalProgram().getStatusFunctionByName(ctx.aim().getText()) instanceof EventStatusFunction |
					normativeReasoner.getInstitutionalProgram().getStatusFunctionByName(ctx.aim().getText()) instanceof StateStatusFunction ){
				aim = (IAchievableStatusFunction) normativeReasoner.getInstitutionalProgram().getStatusFunctionByName(ctx.aim().getText()); 
			}else{
				aim = null;				
			}

			

			//aim = parseFormula(ctx.aim().getText());
			if(ctx.or_else()!=null){			
				orElse = parseFormula(ctx.or_else().getText());
			}
			if(ctx.deadline()!=null){
				deadline = parseFormula(ctx.deadline().getText());
			}
			deontic = null;
			if(ctx.deontic().getText().equals("obliged")){
				deontic = new Obligation();
			}else{
				if(ctx.deontic().getText().equals("permitted")){
					deontic = new Permission();
				}
				else{
					if(ctx.deontic().getText().equals("prohibited")){
						deontic = new Prohibition();
					}
				}



				//program.addNorm(new Norm(condition, attribute, deontic, aim, orElse));


			}

			this.normativeReasoner.addNorm(new Norm(condition, attribute, deontic, aim, orElse,deadline));
		} catch (ParseException e) {
			// TODO Auto-generated catch blockt
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
