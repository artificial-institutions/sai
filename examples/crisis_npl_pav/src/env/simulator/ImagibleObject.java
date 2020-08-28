package simulator;

import javax.swing.ImageIcon;

public abstract class ImagibleObject extends TableObject{
	
	public ImagibleObject(String id, ImageIcon icon) {
		this.id = id;
		this.icon = icon;
		this.description = "";
	}

	public ImagibleObject(String id, ImageIcon icon, String description) {
		this.id = id;
		this.icon = icon;
		this.description = description;
	}


}
