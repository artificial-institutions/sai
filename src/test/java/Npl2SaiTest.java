

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import jason.asSemantics.Unifier;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;

import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;
import static jason.asSyntax.ASSyntax.createAtom;

import npl.NPLInterpreter;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.norms.npl.npl2sai.Npl2Sai;

public class Npl2SaiTest {

	@Test
	public void testNpl2Sai() {		
		NPLInterpreter nplInt = new NPLInterpreter();
		nplInt.init();				
		try {
			Npl2Sai npl = new Npl2Sai(nplInt);
			nplInt.addFact(parseLiteral("teste(x)"));
			System.out.println(nplInt.holds(parseFormula("teste(x)")));
			assertTrue(nplInt.holds(parseFormula("teste(x)")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	@Test
	public void testAddAndRemoveAgentAssignment() {
		NPLInterpreter nplInt = new NPLInterpreter();
		nplInt.init();				
		Npl2Sai npl = new Npl2Sai(nplInt);
		AgentStatusFunction sf = new AgentStatusFunction(createAtom("owner"));
		npl.addAgentAssignment("bob", sf);
		try {
			assertTrue(nplInt.holds(parseFormula("sai__is(bob,owner)")));
			npl.removeAgentAssignment("bob", sf);
			assertTrue(nplInt.holds(parseFormula("not(sai__is(bob,owner))")));
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Test
	public void testAddAndRemoveEventAssignment() {
		NPLInterpreter nplInt = new NPLInterpreter();
		nplInt.init();				
		Npl2Sai npl = new Npl2Sai(nplInt);
		try {
			EventStatusFunction ef = new EventStatusFunction(new Pred(parseLiteral("test(event)")));
			npl.addEventAssignment("my_event", ef, createAtom("bob"));
			assertTrue(nplInt.holds(parseFormula("sai__event(test(event)[sai__agent(bob)])")));
			npl.removeEventAssignment("my_event", ef, new AgentStatusFunction(createAtom("bob")));
			assertTrue(nplInt.holds(parseFormula("not(sai__event(test(event)[sai__agent(bob)]))")));
		
		} catch (ParseException | TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testAddAndRemoveStateAssignment() {
		NPLInterpreter nplInt = new NPLInterpreter();
		nplInt.init();				
		Npl2Sai npl = new Npl2Sai(nplInt);
		try {
			StateStatusFunction sf = new StateStatusFunction(new Pred(parseLiteral("test(state)")));
			npl.addStateAssignment("my_state", sf);
			assertTrue(nplInt.holds(parseFormula("test(state)")));
			npl.removeStateAssignment("", sf);
			assertTrue(nplInt.holds(parseFormula("not(test(state))")));
		
		} catch (ParseException | TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*@Test
	public void testRemoveAgentAssignment() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEventAssignment() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveStateAssignment() {
		fail("Not yet implemented");
	}
*/
}
