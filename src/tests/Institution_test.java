package tests;

import static org.junit.Assert.*;
import sai.main.institution.Institution;
import jason.RevisionFailedException;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import sai.main.lang.semantics.environment.Agent;
import sai.main.lang.semantics.environment.Event;
import sai.main.exception.SaiException;
import static jason.asSyntax.ASSyntax.parseLiteral;

import org.junit.Test;



public class Institution_test {

	@Test
	public void testAddEnvironmentalEvent() throws ParseException, RevisionFailedException, SaiException {
		Event event = new Event((Pred) parseLiteral("myEvent(p1,p2)"), new Agent("bob"));
		Institution inst = new Institution();
		assertFalse(inst.checkEvent(event));
		inst.addEnvironmentalEvent(event);
		assertTrue(inst.checkEvent(event));
	}
	
	@Test (expected = SaiException.class)
	public void testAddEnvironmentalEvent_eventWithVar() throws ParseException, RevisionFailedException, SaiException {
		Event event = new Event((Pred) parseLiteral("myEvent(p1,P2)"), new Agent("bob"));
		Institution inst = new Institution();
		inst.addEnvironmentalEvent(event);
	}

}
