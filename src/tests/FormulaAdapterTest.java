package tests;

import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;
import static org.junit.Assert.assertTrue;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;

import java.io.IOException;

import sai.main.lang.parser.FormulaAdapter;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.InstProgram_Reasoner;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.util.reasoner.jason.JasonReasoner;

import org.junit.Test;


public class FormulaAdapterTest {

	@Test
	public void testAdaptFormula1() {
		try {
			//LogicalFormula formula = parseFormula("sai__is(a,b,c)&sai__is(x,y,z)");
			LogicalFormula formula = parseFormula("x(a&b)");
			FormulaAdapter f = new FormulaAdapter();			
			System.out.println("!!!! " + FormulaAdapter.adaptFormula1(formula));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test_AdaptaFormula_InstProgram(){
		InstProgram program = new InstProgram_Reasoner(new JasonReasoner());
		try {
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state1"))));
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state2"))));
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state3"))));
			LogicalFormula formula = parseFormula("state1&state2&state3");
			System.out.println(FormulaAdapter.adaptFormula(formula, program));
			assertTrue("State-Status functions in while clause not properly adatped", 
					   FormulaAdapter.adaptFormula(formula, program).equals("(sai__is(_,state1,_)&(sai__is(_,state2,_)&sai__is(_,state3,_)))"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
	@Test
	public void test_AdaptaFormula_InstProgram2(){
		InstProgram program = new InstProgram_Reasoner(new JasonReasoner());
		try {
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("achieved(S,G,A)"))));
			LogicalFormula formula = parseFormula("((achieved(\"bhsch\",plumbing_installed,_)& achieved(\"bhsch\",electrical_system_installed,_874_866)) & sai__is(SaiSF,achieved(\"bhsch\",exterior_painted,_875_864),_876))");
			//System.out.println(formula.toString().replaceAll("((_)(\\d)+(Var)?)+", "Var$1"));
			System.out.println(FormulaAdapter.adaptFormula(formula.toString().replaceAll("((_)+(\\d+)(Var)?)+", "Var$3"), program));
			//System.out.println(FormulaAdapter.adaptFormula(formula.toString().replaceAll("((_)+(\\d)+(Var)?)+", "Var$1").replaceAll("Var_(\\d+)","Var$1"), program));
			//assertTrue("State-Status functions in while clause not properly adatped", 
			//		   FormulaAdapter.adaptFormula(formula, program).equals("(sai__is(_,state1,_)&(sai__is(_,state2,_)&sai__is(_,state3,_)))"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
