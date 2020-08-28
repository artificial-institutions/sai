// CArtAgO artifact code for project demoCrisis
/**
 * Simulates a Tangible Table
 */

package simulator;


import jason.runtime.MASConsoleGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import simulator.TableCell;
import cartago.*;

public class TangibleTableArt extends cartago.tools.GUIArtifact {

	private static final ImageIcon iconLaunch = new ImageIcon("src/env/simulator/images/play.png");
	private static final ImageIcon iconWarning = new ImageIcon("src/env/simulator/images/warning.gif");

	private int lines = 0;
	private int cols = 0;
	private String tableId;
	private TableCell cells[][];
	private MyFrame frame;
	private ArrayList<String> users = new ArrayList<String>(); //stores the users that have checked in the table




	public void init(int lines, int cols, String tableId){				
		this.lines = lines;
		this.cols = cols;
		this.tableId = tableId;
		init();	
		defineObsProperty("table", tableId);
	}



	public void setup() {
		this.cells = new TableCell[lines][cols];
		for(int i=0;i<lines;i++){
			for(int j=0;j<cols;j++){
				this.cells[i][j] = createColoredLabel((i+1)+","+(j+1), Color.white);
			}
		}
		frame = new MyFrame(this.cells, this.tableId);		
		linkActionEventToOp(frame.checkInButton, "internalCheckin");
		linkActionEventToOp(frame.to1Button,"launch_button_click");
		linkActionEventToOp(frame.to2Button,"alert_button_click");
		frame.setVisible(true);
	}



	//Create and set up a colored label representing a cell in the table
	private TableCell createColoredLabel(String text, Color color) {
		TableCell label = new TableCell();
		label.setLabel(text);
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setBackground(color);
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setPreferredSize(new Dimension(140, 140));
		return label;
	}

	
	
	@INTERNAL_OPERATION void launch_button_click(ActionEvent ev){
		putTangibleDialog(new LaunchTangibleObject());
	}

	@INTERNAL_OPERATION void alert_button_click(ActionEvent ev){
		putTangibleDialog(new AlertTangibleObject());
	}

	
	@OPERATION void putTangible(TangibleObject tangibleObject, int x, int y, String actor){
		execInternalOp("internal_putTangible", tangibleObject, x-1, y-1, actor);
	}
	
		
	private void putTangibleDialog(TangibleObject tangible){
		JPanel p = new JPanel();
		JPanel labels = new JPanel(new GridLayout(0,1,2,2));
		labels.add(new JLabel("Row:", SwingConstants.RIGHT));
		labels.add(new JLabel("Column:", SwingConstants.RIGHT));
		p.add(labels, BorderLayout.WEST);
		final JPanel controls = new JPanel(new GridLayout(0,1,2,2));
		JTextField txtX = new JTextField(5);
		txtX.requestFocus();
		controls.add(txtX);
		JTextField txtY = new JTextField(5);
		controls.add(txtY);
		p.add(controls, BorderLayout.CENTER);
		int option = JOptionPane.showConfirmDialog(null, p, "Inform the coordinates", JOptionPane.OK_CANCEL_OPTION);
		if(option==JOptionPane.OK_OPTION)
			execInternalOp("internal_putTangible", tangible, Integer.parseInt(txtX.getText())-1, Integer.parseInt(txtY.getText())-1, frame.cbUsers.getSelectedItem().toString());

	}
	
	@INTERNAL_OPERATION void internal_putTangible(TangibleObject tangibleObject, int x, int y, String actor){
		defineObsProperty("tangibleIn", tangibleObject.getId(),x+1,y+1);
		this.cells[x][y].addTangibleObject(tangibleObject);
		//The coordinates "x" and "y" are added in 1 as, to the external world (external to the table applications)
		//the coordinates start in "1" insted of starting in "0" as in the internal representation
		signal("putTangible",this.tableId, tangibleObject.getId(),x+1,y+1,actor);
	}




	@INTERNAL_OPERATION void internalCheckin(ActionEvent ev){
		String user = JOptionPane.showInputDialog(null, "Username:", "", JOptionPane.PLAIN_MESSAGE).toLowerCase();
		//this.users.add(user);
		this.users.add(user);
		frame.setCbUserItems();		
		this.frame.to1Button.setEnabled(true);
		this.frame.to2Button.setEnabled(true);
		this.frame.to1Button.setVisible(true);
		this.frame.to2Button.setVisible(true);		
		this.frame.header2.setVisible(true);
		signal("checkin",this.tableId, user);
	}



	

	

	@OPERATION void putImagible(String imagibleObject, int x, int y, String actor){
		ImagibleObject imagible =  ImagibleObjectFactory.getInstance().getImagibleObject(imagibleObject);		
		if(imagible!=null)
		   execInternalOp("internal_putImagible", imagible, x-1, y-1, actor);		

	}

	@INTERNAL_OPERATION void internal_putImagible(ImagibleObject imagibleObject, int x, int y, String actor){
		defineObsProperty("imagibleIn", imagibleObject.getId(),x+1,y+1);
		this.cells[x][y].addImagibleObject(imagibleObject);
		//The coordinates "x" and "y" are added in 1 as, to the external world (external to the table applications)
		//the coordinates start in "1" insted of starting in "0" as in the internal representation
		signal("putImagible",this.tableId, imagibleObject.getId(),x+1,y+1,actor);
	}

	/*************************************************/

	class MyFrame extends JFrame {    

    	private JButton checkInButton;
		private JTextField text;
		private JComboBox cbUsers; 
		private JLabel[][] cells;
		private JButton to1Button;
		private JButton to2Button;
		JPanel header2 = new JPanel();
		

		public MyFrame(JLabel[][] cells, String tableId){
			setTitle(tableId);
			setSize(400,500);
			JPanel panel = new JPanel();

			JPanel header1= new JPanel();


			setContentPane(panel);


			text = new JTextField(10);
			text.setText("0");
			text.setEditable(true);


			checkInButton = new JButton("checkin");
			checkInButton.setSize(80,50);
			JLabel lblUser = new JLabel("User: ");

			cbUsers= new JComboBox();
			cbUsers.setPrototypeDisplayValue("XXXXXXXXXXXXXXX");
			setCbUserItems();



			to1Button = getButton("Launch", iconLaunch);
			to2Button = getButton("Alert", iconWarning);

			to1Button.setEnabled(false);
			to2Button.setEnabled(false);
			to1Button.setVisible(false);
			to2Button.setVisible(false);


			header2.setVisible(false);
			header2.add(new JLabel("Available tangible objects:"));
			header2.add(to1Button);
			header2.add(to2Button);


			header1.add(lblUser);
			header1.add(cbUsers);
			header1.add(checkInButton);			
			panel.add(header1);
			panel.add(header2);

			JLayeredPane panelGrid = new JLayeredPane();
			panelGrid.setPreferredSize(new Dimension(300, 310));
			panelGrid.setBorder(BorderFactory.createTitledBorder(
					"---"));

			panelGrid.setLayout(new GridLayout(lines,cols));
			panel.add(panelGrid);


			for(int i=0;i<cells.length;i++){
				for(int j=0;j<cells[i].length;j++){
					panelGrid.add(cells[i][j]);
				}					
			}

		}


		private JButton getButton(String text, ImageIcon icon){
			Image img = icon.getImage(); 
			Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newimg);
			JButton button = new JButton(text, newIcon);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			return button;
		}

		public String getText(){
			return text.getText();
		}

		public void setText(String s){
			text.setText(s);
		}

		public void setCbUserItems(){
			cbUsers.removeAllItems();
			if(users.size()==0)
				cbUsers.addItem("Click to checkin>>>");
			else
				for(String user:users){
					cbUsers.addItem(user);
				}
		}



	}


}

