import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.functions.e;

import static jason.asSyntax.ASSyntax.parseLiteral;
import static jason.asSyntax.ASSyntax.parseFormula;
import sai.main.institution.ConstitutiveReasoner;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.InstProgram_Reasoner;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;

public class ConstitutiveReasonerTest {

	/**
	 * Testar: se inclui uma state-sf, incluir na BB do reasoner também um fato relativo somente à SF.
	 * Ex. Se inclui sai__is(fato_x, fatoy(a,b,c),t,m), incluir também fatoy(a,b,c)
	 */

	@Test
	public void test() {
		int MAX_WAIT = 10000;
		System.out.println("-------------------- COMECANDO --------------------");
		ConcurrentLinkedQueue<Literal> environmentQueue = new ConcurrentLinkedQueue<Literal>();
		ConstitutiveReasoner r = new ConstitutiveReasoner(environmentQueue);
		InstProgram_Reasoner program = new InstProgram_Reasoner(r.getReasoner());
		r.start();


		try {

			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("test(x,y)"))));
			program.addConstitutiveRule(new ConstitutiveRule(new Pred(parseLiteral("fact(x,y)")), new StateStatusFunction(new Pred("test(x,y)")), parseFormula("true"), parseFormula("true")));
			
			
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("test2(A,B)"))));
			program.addConstitutiveRule(new ConstitutiveRule(new Pred(parseLiteral("sai__freestandingY")), 
				                                         new StateStatusFunction(new Pred("test2(X,Y)")), 
				                                         parseFormula("myEvent(t1,t2([x(X),Y]))"), 
				                                         parseFormula("true")));
			
		
			

			
			environmentQueue.add(parseLiteral("fact(x,y)"));
			//environmentQueue.add(parseLiteral("myEvent(t1,t2([x(a),b]))[sai__agent(bob)]"));
			
			r.getReasoner().assertValue("sai__freestandingY");



			//synchronized (r.getReasoner()) {
				//Iterator<Unifier> it = r.getReasoner().findall("inGs(X,Y,M)");
				//while(it.hasNext())
				//	System.out.println(".>>>>>>>>>>>>>>>> " + it.next());

				//while(!r.getReasoner().check("sai__is(fact(x,y),test(x,y),fact(x,y))"));
			//}
			//while(true) {
			int i=0;
			//while(!r.getReasoner().check("sai__is(fact(x,y),test(x,y),fact(x,y))")&&i++<=MAX_WAIT) {
			while(!r.getReasoner().check("test(x,y)")&&i++<=MAX_WAIT) {
				//System.out.println(">>>>>>>>>>>. " + r.getReasoner().check("sai__is(fact(x,y),test(x,y),fact(x,y))"));
			}
			
			System.out.println("========================== " + r.getReasoner().check("sai__is(fact(x,y),test(x,y),fact(x,y))"));

			if(i>MAX_WAIT) assertTrue(1==2);
			
			//assertTrue(r.getReasoner().check("test(x,y)"));
			//boolean v = r.getReasoner().check("test(x,y)");
			assertTrue(r.getReasoner().check("test(x,y)"));
			
	
			environmentQueue.add(parseLiteral("sigmaE(myEvent(t1,t2([x(a),b]))[sai__agent(bob)])"));			
			i=0;
			while(!r.getReasoner().check("test2(a,b)")&&i++<=MAX_WAIT) {}	
			if(i>MAX_WAIT) assertTrue(1==2);
			assertTrue(r.getReasoner().check("test2(a,b)"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------- TERMINANDO --------------------");
		

	}

}
