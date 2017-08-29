package simulator;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import simulator.TableCell;



public class TableSet{

	private static TableSet instance = null;
	private ArrayList<TangibleTableArt> tables = new ArrayList<TangibleTableArt>();

	private TableSet(){
		System.out.println("Criou!!!");
	}

	public static TableSet getInstance(){
		if(instance==null){
			instance = new TableSet();
		}
		return instance;
	}


	public void registerTable(TangibleTableArt table){
		tables.add(table);
	}

/*
	public void registerPuttedTangible(String table, String tangibleObject, int x, int y, String actor){
		for(TangibleTableArt tb:tables){
			if(tb.getTableId()!=table){
				TableCell cell = tb.getCells()[x][y];
				cell.addObject(tangibleObject+"@"+table);
				//cell.setText(cell.getText()+" " +"\n"+ tangibleObject+"@"+table);
			}
		}		
	}*/

}
