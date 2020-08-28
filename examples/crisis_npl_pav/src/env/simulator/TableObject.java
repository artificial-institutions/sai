package simulator;

import javax.swing.ImageIcon;


/**
 * All kinkds of objects that are putted on the tangible tables (tangibles, imagibles, etc) extend TableObject
 * @author maiquel
 *
 */

public class TableObject {

	protected String id;
	protected ImageIcon icon;
	protected String description;

	public TableObject() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}