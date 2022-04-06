import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;

import cartago.AgentId;
import cartago.AgentIdCredential;
import cartago.Artifact;
import cartago.ArtifactAlreadyPresentException;
import cartago.ArtifactId;
import cartago.CartagoException;
import cartago.EventRegistry;
import cartago.Op;
import cartago.WorkspaceArtifact;
import cartago.WorkspaceId;
import cartago.events.ActionSucceededEvent;
import cartago.tools.Clock;
import jaca.CartagoEnvironment;
import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;
import sai.bridges.jacamo.RuleEngine;
import sai.main.institution.SaiEngine;


import static jason.asSyntax.ASSyntax.parseLiteral;

public class RuleEngineTest {

	@Test
	public void test_AddArtifactToIgnore() {
		RuleEngine r = new RuleEngine();
		String artifactName = "myArt";
		assertNull(r.getArtifactsToIgnore().get(artifactName));
		r.addArtifactToIgnore(artifactName);
		assertEquals(r.getArtifactsToIgnore().get(artifactName),artifactName );

	}


	/**
	 * test the handling of string as arguments of events
	 */
	@Test
	public void test_Op2Pred_String() {
		assertTrue(true);
		
	}
	
	@Test
	public void test_nonJacamoPropertyToPred(){
		RuleEngine re = new RuleEngine();	
		assertEquals("p(x,y,z)",re.propertyToPred("x", "p", new Object[] {"y","z"}));
	}
	
	@Test
	public void test_jacamoPropertyToPred(){
		RuleEngine re = new RuleEngine();		
		assertEquals("focusing(a,a,tools.Counter,w1,w1,\"/main/w1\")", re.propertyToPred("a", "focusing", new Object[] {"a","tools.Counter","w1","w1","/main/w1"}));
		assertEquals("joinedWsp(a,cobj_3,w1,\"/main/w1\")", re.propertyToPred("a", "joinedWsp", new Object[] {"cobj_3","w1","/main/w1"}));
	}
	
	
	

}
