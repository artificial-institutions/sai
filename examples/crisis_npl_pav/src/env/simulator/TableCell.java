package simulator;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ora4mas.nopl.simulator.SimulatorGUI;

/**
 * A cell in a Tangible Table
 * 
 * For simplicity, there is not a class to represent the tangible objects. They are just represented by an ID 
 * stored in the array "objects".  
 * 
 * @author maiquel
 *
 */


public class TableCell extends JLabel {
	
	private String label; //a label to be displayed by the cell (idenfifying, for instance, its coordinates)	
	private ArrayList<TableObject> objects = new ArrayList<TableObject>(); //the objects placed in the Cells	
	
	
	
	public TableCell(){
		super();
		this.setFont(new Font("Helvetica", Font.PLAIN, 10));
	}
	
	
	/*public void addObject(String objectId){
		if(objects.indexOf(objectId)<0)
		   objects.add(objectId);
		arrangeText();
	}
	*/
	
	public void addTangibleObject(TangibleObject object){
			if(objects.indexOf(object)<0)
			   objects.add(object);
			arrangeText();
	}
	
	public void addImagibleObject(ImagibleObject object){
		if(objects.indexOf(object)<0)
		   objects.add(object);
		arrangeText();
}
	
	public void removeTangibleObject(String objectId){
		objects.remove(objectId);
		arrangeText();
	}
	
	
	
	private void arrangeText(){
		String s = "<html><body>" + getLabel()+"<br>";		
		for(TableObject st:objects){
			//s = s.concat(st.getId()).concat("<br>");	
			//System.out.println("[TableCell] icon description " + st.getIcon().getDescription());
			if(st.getIcon()==null)
				s = s.concat(st.getId()).concat("<br>");
			else {
			   s = s.concat(st.getDescription()+"<br>");
			   
			   /* The line below has been disabled due a knwon bug in Java 13:https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8230235 */
			   //s = s.concat("<img  height='15' width='15' src='"+st.getIcon().getDescription()+"' />");
			   
			}
		}
		s = s.concat("</body></html>");		
		this.setText(s);		
		
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
		arrangeText();
	}
	

}
