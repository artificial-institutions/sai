package sai.main.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaiLogger {

	private Logger logger = Logger.getLogger("saiLogger");
	private static SaiLogger instance;
	
	
	private SaiLogger(){
		logger.setLevel(Level.FINEST);
		try {
			logger.setUseParentHandlers(false);
			FileHandler handler = new FileHandler("sai.log");
			//SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(new SaiFormatter()); //Set log to plain text. Default (by Java) is xml
			logger.addHandler(handler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SaiLogger getInstance(){
		if(instance==null){
			instance = new SaiLogger();		
		}
		return instance;
	}

	public void finest(String msg){
		logger.finest(msg);
	}
	
}
