import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.createVar;
import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;
import sai.main.lang.semantics.InstProgram_Reasoner;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.util.reasoner.BasicReasonerHttpGUI;
import sai.util.reasoner.jason.JasonReasoner;

import org.junit.Test;
 
public class InstProgram_ReasonerTest {

	/*
	 * Check if the status functions are properly added
	 */
	@Test
	public void testAddStatusFunction() throws Exception {
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		
		AgentStatusFunction af = new AgentStatusFunction(createAtom("bob"));		
		program.addStatusFunction(af);
		assertTrue(program.CheckBel("sai__af(bob)"));
		assertFalse(program.CheckBel("sai__ef(bob)")); 
		assertFalse(program.CheckBel("sai__sf(bob)"));
		
		EventStatusFunction ef = new EventStatusFunction(new Pred(parseLiteral("to_bid(Value)")));
		program.addStatusFunction(ef);
		assertTrue(program.CheckBel("sai__ef(to_bid(Value))"));
		assertFalse(program.CheckBel("sai__af(to_bid(Value))"));
		assertFalse(program.CheckBel("sai__sf(to_bid(Value))"));
		
		StateStatusFunction sf = new StateStatusFunction(new Pred(parseLiteral("auction_running")));
		program.addStatusFunction(sf);
		assertTrue(program.CheckBel("sai__sf(auction_running)"));
		assertFalse(program.CheckBel("sai__af(auction_running)"));
		assertFalse(program.CheckBel("sai__ef(auction_running)"));
		
	}

	@Test
	public void testAddStateStatusFunctionWithVariable() {
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());

		try {
			StateStatusFunction sf = new StateStatusFunction(new Pred(parseLiteral("vl(V1,v,V2)")));
			program.addStatusFunction(sf);
			ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("s(V1,V2)")),
					new StateStatusFunction(new Pred(parseLiteral("vl(5000,v,6000)"))),
					parseFormula("true"),
					parseFormula("V1>=5000&V2>=6000")
					//parseFormula("true")
					);
			program.addConstitutiveRule(crule);
			program.getReasoner().assertValue("s(7000,8000)");
			program.getReasoner().assertValue("sigmaE(true)");	

			assertTrue(program.CheckBel("sai__crule(St,Sf,T,M)&T&sai__sf(Sf)&M&St&not(sai__is(St,Sf,M))"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testAddStateStatusFunctionWithoutVariable() {
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());

		try {
			StateStatusFunction sf = new StateStatusFunction(new Pred(parseLiteral("vl(a,b,c)")));
			program.addStatusFunction(sf);
			ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("s(V1,V2)")),
					new StateStatusFunction(new Pred(parseLiteral("vl(a,b,c)"))),
					parseFormula("true"),
					parseFormula("V1>=5000&V2>=6000")
					//parseFormula("true")
					);
			program.addConstitutiveRule(crule);
			program.getReasoner().assertValue("s(7000,8000)");
			program.getReasoner().assertValue("sigmaE(true)");	

			assertTrue(program.CheckBel("sai__crule(St,Sf,T,M)&T&sai__sf(Sf)&M&St&not(sai__is(St,Sf,M))"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddEventStatusFunctionWithVariable() {
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		try {
			EventStatusFunction sf = new EventStatusFunction(new Pred(parseLiteral("vl(V1,v,V2)")));
			program.addStatusFunction(sf);
			ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("s(V1,V2)")),
					new EventStatusFunction(new Pred(parseLiteral("vl(5000,v,6000)"))),
					parseFormula("true"),
					parseFormula("V1>=5000&V2>=6000")
					);
			program.addConstitutiveRule(crule);
			program.getReasoner().assertValue("sigmaE(s(7000,8000)[sai__agent(bob)])");
			program.getReasoner().assertValue("sigmaE(true)");			
			assertTrue(program.CheckBel("sai__crule(event(Ev),Ef,T,M)&sai__ef(Ef)&(sigmaE(Ev[sai__agent(TriggerAgent)]))&not(Ev==true)&T&M&not(sai__is(event(Ev),Ef,TriggerAgent,_))"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testAddEventStatusFunctionWithoutVariable() {
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		try {
			EventStatusFunction sf = new EventStatusFunction(new Pred(parseLiteral("vl(a,b,c)")));
			program.addStatusFunction(sf);
			ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("s(V1,V2)")),
					new EventStatusFunction(new Pred(parseLiteral("vl(a,b,c)"))),
					parseFormula("true"),
					parseFormula("V1>=5000&V2>=6000")
					);
			program.addConstitutiveRule(crule);
			program.getReasoner().assertValue("sigmaE(s(7000,8000)[sai__agent(bob)])");
			program.getReasoner().assertValue("sigmaE(true)");			
			assertTrue(program.CheckBel("sai__crule(event(Ev),Ef,T,M)&sai__ef(Ef)&(sigmaE(Ev[sai__agent(TriggerAgent)]))&not(Ev==true)&T&M&not(sai__is(event(Ev),Ef,TriggerAgent,_))"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


	@Test
	public void testAddConstitutiveRule() throws Exception{
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner(new BasicReasonerHttpGUI(8001)));
		program.addStatusFunction(new AgentStatusFunction(createAtom("auctioneer")));
		ConstitutiveRule crule = new ConstitutiveRule(createVar("Agent"), 
				                                      new AgentStatusFunction(createAtom("auctioneer")),
				                                      parseFormula("propose(auction)[agent(Agent)]"),
				                                      parseFormula("not auction_finished"));
		program.addConstitutiveRule(crule);
		assertTrue(program.CheckBel("sai__crule(Agent,auctioneer,sigmaE(propose(auction)[agent(Agent)]),not (auction_finished))"));
	}

	
	@Test
	public void testAddConstitutiveRule_AssignmentToSF() throws Exception{
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		program.addStatusFunction(new AgentStatusFunction(createAtom("bidder")));
		program.addStatusFunction(new AgentStatusFunction(createAtom("participant")));
		ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("bidder")), new AgentStatusFunction(createAtom("participant")), parseFormula("true"), parseFormula("true"));
		program.addConstitutiveRule(crule);
		assertTrue(program.CheckBel("sai__crule(SaiSF,participant,sigmaE(true),(true & sai__is(SaiSF,bidder,_1)))"));
	}
	
	
	/**/
	@Test
	public void testAddConstitutiveRule_AssignmentToStateSF() throws Exception{
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state1"))));
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state2"))));
		ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("state1")), new StateStatusFunction(new Pred(parseLiteral("state2"))), parseFormula("true"), parseFormula("true"));
		program.addConstitutiveRule(crule);
		assertTrue(program.CheckBel("sai__crule(SaiSF,state2,sigmaE(true),(true & sai__is(_,state1,_1)))"));
	}
	
	/*all the status functions in the while clause must be adapted to sai__is(_,sf,_)*/
	@Test
	public void testAddConstitutiveRule_SfInWhile() throws Exception{
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state1"))));
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state2"))));
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state3"))));
		ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("teste")), new StateStatusFunction(new Pred(parseLiteral("state1"))), parseFormula("true"), parseFormula("state2&state3"));
		program.addConstitutiveRule(crule);
		assertTrue(program.CheckBel("sai__crule(teste,state1,sigmaE(true),teste&sai__is(_,state2,_)&sai__is(_,state3,_))"));
	}
	
	
	/* check whether an exception is raised when a constitutive rule with invalid SF in term Y	 is to be added */
	@Test
	public void testAddConstitutiveRule_InvalidSF() throws ParseException, TokenMgrError, Exception{
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state1"))));				
		ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("teste")), new StateStatusFunction(new Pred(parseLiteral("state_n"))), parseFormula("true"), parseFormula("state2&state3"));
		try {
		   program.addConstitutiveRule(crule);
		}catch (Exception e) {			
			assertEquals("Exception different from expected","StatusFunctionNotFoundException", e.getClass().getSimpleName());
		}				
	}
	

	/* check whether an exception is raised when a constitutive rule with invalid SF in term Y	 is to be added */
	@Test
	public void testAddConstitutiveRule_NullF() throws ParseException, TokenMgrError, Exception{
		InstProgram_Reasoner program = new InstProgram_Reasoner(new JasonReasoner());
		program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("state1"))));				
		ConstitutiveRule crule = new ConstitutiveRule(new Pred(parseLiteral("teste")), null, parseFormula("true"), parseFormula("state2&state3"));
		try {
		   program.addConstitutiveRule(crule);
		}catch (Exception e) {			
			assertEquals("Exception different from expected","StatusFunctionNotFoundException", e.getClass().getSimpleName());
		}				
	}
}
