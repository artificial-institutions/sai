// CArtAgO artifact code for project events

package tools;

import cartago.*;

public class Counter extends Artifact {
	void init(int initialValue) {
		defineObsProperty("count", initialValue);                
                defineObsProperty("prop2",0);
	}

	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}


	@OPERATION
        void op1(){
                defineObsProperty("prop1");
		log("doing op1");
	}

        @OPERATION
        void op2(int x){
		log("doing op2");
                ObsProperty prop = getObsProperty("prop2");
		prop.updateValue(x);   
	}
}

