package sai.main.lang.parser;

import jason.RevisionFailedException;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import static jason.asSyntax.ASSyntax.parseLiteral;
import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.createVar;
import static jason.asSyntax.ASSyntax.createAtom;

import org.antlr.v4.runtime.misc.NotNull;

import sai.main.exception.SaiException;
import sai.main.exception.StatusFunctionNotFoundException;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.main.lang.semantics.statusFunction.StatusFunction;

public class sai_constitutiveListenerImpl extends sai_constitutiveBaseListener{

	private String currentState = "";
	private InstProgram instProgram;


	public sai_constitutiveListenerImpl(InstProgram instProgram) {
		super();
		this.instProgram = instProgram;
	}

	
	@Override public void enterAgent_sf_decl(@NotNull sai_constitutiveParser.Agent_sf_declContext ctx) { 
		currentState = "agent_sf";
	}

	@Override public void exitAgent_sf_decl(@NotNull sai_constitutiveParser.Agent_sf_declContext ctx) { 
		currentState = "";
	}


	@Override public void exitAgent_sf(@NotNull sai_constitutiveParser.Agent_sfContext ctx) { 
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


	@Override public void enterEvent_sf_decl(@NotNull sai_constitutiveParser.Event_sf_declContext ctx) { 
		currentState = "event_sf";
	}

	@Override public void exitEvent_sf_decl(@NotNull sai_constitutiveParser.Event_sf_declContext ctx) { 
		currentState = "";
	}

	@Override public void exitEvent_sf(@NotNull sai_constitutiveParser.Event_sfContext ctx) { 
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

	@Override public void enterState_sf_decl(@NotNull sai_constitutiveParser.State_sf_declContext ctx) { 
		currentState = "state_sf";
	}

	@Override public void exitState_sf_decl(@NotNull sai_constitutiveParser.State_sf_declContext ctx) { 
		currentState = "";
	}

	@Override public void exitState_sf(@NotNull sai_constitutiveParser.State_sfContext ctx) { 
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

	

	@Override public void exitConst_rule(@NotNull sai_constitutiveParser.Const_ruleContext ctx)  {
		StatusFunction y = null;
   	    try {
			y = instProgram.getStatusFunctionByName(ctx.count_as_stat().y().getText().toString());
			Pred x = null;
			LogicalFormula t = null;
			LogicalFormula m = null;




			if(ctx.count_as_stat().x()!=null){				
				x = (Pred) parseLiteral(ctx.count_as_stat().x().getText());
			}
			else
				x = createVar("_");
			if(ctx.t()!=null)
				t = parseFormula(ctx.t().event_sf().getText());
			if(ctx.m()!=null){						
				
				//the visitor check formulas and tranform "is" expressions in predicates.
				//for example, "bob is house_owner" becomes is(bob,house_owner,_); 
				FormulaVisitor visitor = new FormulaVisitor();
				visitor.visitSf_formula(ctx.m().sf_formula());
				//visitor.visit(ctx.m());				
				m = parseFormula(visitor.getFormula());	
			}			
			 
			instProgram.addConstitutiveRule(new ConstitutiveRule(x,y,t,m));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (StatusFunctionNotFoundException e) {
			System.err.println("Failed to add constitutive rule. The status function " + ctx.count_as_stat().y().getText().toString() + " in term Y does not belong to the institution" );				
			e.printStackTrace();	
		} catch (SaiException e) {
			// TODO Auto-generated catch block				
			e.printStackTrace();				
		} catch (RevisionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*Pred y = null; 
		if(ctx.count_as_stat().y()!=null){
			try {
				y = (Pred) parseLiteral(ctx.count_as_stat().y().getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Pred x = null;
			if(ctx.count_as_stat().x()!=null)
				try {
					x = (Pred) parseLiteral(ctx.count_as_stat().x().getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			LogicalFormula t = null;
			if(ctx.t()!=null)
				try {
					t = parseFormula(ctx.t().getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			LogicalFormula m = null;
			if(ctx.m()!=null)
				try {
					m = parseFormula(ctx.m().getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			//instProgram.addConstitutiveRule(new ConstitutiveRule(x,y,t,m));
		}
		else{

		}
		 */
	}
}
