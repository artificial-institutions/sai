// CArtAgO artifact code for project speech_acts_sai

import cartago.*;

public class WarningArtifact extends Artifact {
	void init() {
		defineObsProperty("raining", false);
	}

	@OPERATION
	void rainWarning() {		
		ObsProperty prop = getObsProperty("raining");
		prop.updateValue(true);
        }

	@OPERATION
	void undoRainWarning() {		
		ObsProperty prop = getObsProperty("raining");
		prop.updateValue(false);		
	}
}

 
