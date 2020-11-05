import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;

import cartago.AgentId;
import cartago.AgentIdCredential;
import cartago.Artifact;
import cartago.ArtifactAlreadyPresentException;
import cartago.ArtifactId;
import cartago.CartagoContext;
import cartago.CartagoException;
import cartago.CartagoService;
import cartago.CartagoWorkspace;
import cartago.EventRegistry;
import cartago.Op;
import cartago.WorkspaceId;
import cartago.events.ActionSucceededEvent;
import cartago.tools.Clock;
import jaca.CartagoEnvironment;
import sai.bridges.jacamo.RuleEngine;
import sai.main.institution.SaiEngine;

public class RuleEngineTest {

	@Test
	public void test_AddArtifactToIgnore() {
		RuleEngine r = new RuleEngine();
		String artifactName = "myArt";
		assertNull(r.getArtifactsToIgnore().get(artifactName));
		r.addArtifactToIgnore(artifactName);
		assertEquals(r.getArtifactsToIgnore().get(artifactName),artifactName );

	}


	/*
	 * Test the processing of an action of an artifact that should be ignored
	 */
	@Test
	public void test_ProcessActionCompleted_IgnoredArt() {
		CartagoEnvironment env = new CartagoEnvironment();
		String[] params = {};
		env.init(params);  
		try {
			CartagoContext cartagoCtx = CartagoService.startSession(CartagoService.MAIN_WSP_NAME, new AgentIdCredential("JaCaMo_Launcher"));
			CartagoService.createWorkspace("wsp");
			WorkspaceId wid = cartagoCtx.joinWorkspace("wsp", new AgentIdCredential("JaCaMoLauncherAgEnv"));
			ArtifactId aid = cartagoCtx.makeArtifact(wid, "myArt","cartago.tools.Clock"); 
			Op op = new Op("op", new Object[] {});
			ActionSucceededEvent ev = new ActionSucceededEvent(0, 0, op, aid);
			RuleEngine re = new RuleEngine();
			re.addArtifactToIgnore("myArt");
			assertTrue(re.toIgnoreArt(ev));
		} catch (CartagoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
