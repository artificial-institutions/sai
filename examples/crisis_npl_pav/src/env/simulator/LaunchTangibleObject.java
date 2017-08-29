package simulator;

import javax.swing.ImageIcon;

public class LaunchTangibleObject extends TangibleObject {	
	public LaunchTangibleObject(){
		super("launch_tangible_object", new ImageIcon(TangibleTableArt.class.getResource("/simulator/images/play.png")));
	}

}
