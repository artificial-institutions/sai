package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import jason.RevisionFailedException;
import jason.asSemantics.Unifier;
import jason.asSyntax.parser.ParseException;

import org.junit.Test;

import sai.util.reasoner.jason.JasonReasoner;




public class JasonReasonerTest {

	@Test
	public void testAssertValue() throws RevisionFailedException, ParseException {
		JasonReasoner reasoner = new JasonReasoner();
		reasoner.assertValue("myBel(bel)");
		assertTrue(reasoner.check("myBel(bel)"));
		assertTrue(reasoner.check("myBel(X)"));
		assertFalse(reasoner.check("myBelx(bel)"));
	}
	
	@Test
	public void testFindall() throws Exception{
		JasonReasoner reasoner = new JasonReasoner();
		reasoner.assertValue("test(a,b)");
		reasoner.assertValue("test(a,c)");
		Iterator<Unifier> un = reasoner.findall("test(X,Y)");
		Unifier u1 = un.next();
		Unifier u2 = un.next();
		assertTrue(u1.get("X").toString().equals("a"));
		assertTrue(u2.get("X").toString().equals("a"));
		assertTrue((u1.get("Y").toString().equals("b"))|(u1.get("Y").toString().equals("c")));
		assertTrue((u2.get("Y").toString().equals("b"))|(u2.get("Y").toString().equals("c")));
	}

	@Test
	public void retractTest() throws Exception{
		JasonReasoner reasoner = new JasonReasoner();
		reasoner.assertValue("test(a,b)");
		reasoner.assertValue("test(a,c)");
		assertTrue(reasoner.check("test(a,b)"));
		assertTrue(reasoner.check("test(a,c)"));
		reasoner.retract("test(a,b)");
		assertFalse(reasoner.check("test(a,b)"));
		assertTrue(reasoner.check("test(a,c)"));
	}
	
	@Test
	public void retractTest_withVars() throws Exception{
		JasonReasoner reasoner = new JasonReasoner();
		reasoner.assertValue("test(a,_)");
		assertTrue(reasoner.check("test(a,_)"));
		reasoner.retract("test(a,_)");
		assertFalse(reasoner.check("test(a,_)"));
	}
	
	@Test
	public void retractTest_byFunctor() throws Exception{
		JasonReasoner reasoner = new JasonReasoner();
		reasoner.assertValue("test(a)");
		reasoner.assertValue("test(b)");
		assertTrue(reasoner.check("test(a)"));
		assertTrue(reasoner.check("test(b)"));
		reasoner.retract("test(_)");
		assertFalse(reasoner.check("test(a)"));
		assertFalse(reasoner.check("test(b)"));
	}
	
}

