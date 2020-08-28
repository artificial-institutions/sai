package simulator;

import javax.swing.ImageIcon;

/**
 * Simulates a tangible object to be putted on tangible tables
 * @author maiquel
 *
 */

public abstract class TangibleObject extends TableObject {
	
	public TangibleObject(String id, ImageIcon icon) {
		this.id = id;
		this.icon = icon;
		this.description = "";
	}
	
	public TangibleObject(String id, ImageIcon icon, String description) {
		this.id = id;
		this.icon = icon;
		this.description = description;
	}
	
	
	
	

}
