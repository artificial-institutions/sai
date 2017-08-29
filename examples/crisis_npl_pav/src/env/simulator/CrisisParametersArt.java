// CArtAgO artifact code for project demoCrisis

/**
 * Parameters for the crisis management, setted as observable properties:
 * security_phase(Zone,Phase): phase of the crisis management in the Zone - e.g. security_phase(downtown,preventive)
 * nbInhabit(Zone,X): the Zone has X inhabitants - e.g. nbInhabit(downtown,500)
 * 
 * 
 */


package simulator;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cartago.*;

public class CrisisParametersArt  extends cartago.tools.GUIArtifact{

	private MyFrame frame;
	
	
   public void setup(){
		defineObsProperty("security_phase", "downtown","preventive");
		defineObsProperty("nbInhabit", "downtown",300);
		frame = new MyFrame();
		linkActionEventToOp(frame.btnUpdateInhabitants, "internal_updateInhabitants");
		linkActionEventToOp(frame.btnUpdatePhase, "internal_updatePhase");
		frame.setVisible(true);
	}
	
   
    @OPERATION void updateInhabitants(String zone, int nb){
		frame.txtInhabitants.setText(zone+";"+nb);
		getObsProperty("nbInhabit").updateValues(zone,nb);
		updateNumberInhabitants(zone, nb);
	}
	
	@INTERNAL_OPERATION void internal_updateInhabitants(ActionEvent ev){
		String zone = frame.txtInhabitants.getText().substring(0, frame.txtInhabitants.getText().indexOf(';'));
		int nb = Integer.parseInt(frame.txtInhabitants.getText().substring(frame.txtInhabitants.getText().indexOf(';')+1));
		//getObsProperty("nbInhabit").updateValues(zone,nb);
		updateNumberInhabitants(zone, nb);
	}
		
	/*
	 * A single method accessed by internal and external operations
	 */
	private void updateNumberInhabitants(String zone, int nb){
		getObsProperty("nbInhabit").updateValues(zone,nb);
	}
	
	
	@OPERATION void updatePhase(String zone, String phase){
		updateCrisisPhase(zone, phase);
	}
	
	
	
	@INTERNAL_OPERATION void internal_updatePhase(ActionEvent ev){
		String zone = frame.txtPhase.getText().substring(0, frame.txtPhase.getText().indexOf(';'));
		String phase = frame.txtPhase.getText().substring(frame.txtPhase.getText().indexOf(';')+1);
		//getObsProperty("security_phase").updateValues(zone,phase);
		updateCrisisPhase(zone, phase);
	}
	
	
	/*
	 * A single method accessed by internal and external operations
	 */
	private void updateCrisisPhase(String zone, String phase){
		getObsProperty("security_phase").updateValues(zone,phase);
	}
	

	class MyFrame extends JFrame {    

		private JButton btnUpdateInhabitants;
		private JButton btnUpdatePhase;
		private JTextField txtInhabitants;
		private JTextField txtPhase;

		public MyFrame(){
			setTitle("Crisis parameters");
			setSize(500,200);
			JPanel panel = new JPanel();
			
			JPanel header1= new JPanel();
			JPanel header2 = new JPanel();

			setContentPane(panel);
			
			btnUpdateInhabitants = new JButton("update");
			btnUpdateInhabitants.setSize(80,50);			
			txtInhabitants = new JTextField(20);
			txtInhabitants.setText(getObsProperty("nbInhabit").stringValue(0)+";"+getObsProperty("nbInhabit").stringValue(1));
			txtInhabitants.setEditable(true);
			header1.add(new JLabel("Number Inhabitants: "));
			header1.add(txtInhabitants);
			header1.add(btnUpdateInhabitants);		
			panel.add(header1);

			
			btnUpdatePhase = new JButton("update");
			btnUpdatePhase.setSize(80,50);			
			txtPhase = new JTextField(20);
			txtPhase.setText(getObsProperty("security_phase").stringValue(0)+";"+getObsProperty("security_phase").stringValue(1));
			txtPhase.setEditable(true);
			header2.add(new JLabel("Security phase: "));
			header2.add(txtPhase);
			header2.add(btnUpdatePhase);		
			panel.add(header2);

		}



	}



}

