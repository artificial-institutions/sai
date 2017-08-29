package sai.bridges.jacamo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import sai.main.institution.INormativeEngine;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.StatusFunction;
import sai.main.lang.parser.sai_constitutiveLexer;
import sai.main.lang.parser.sai_constitutiveListenerImpl;
import sai.main.lang.parser.sai_constitutiveParser;
import sai.main.lang.parser.sai_normativeLexer;
import sai.main.lang.parser.sai_normativeListenerImpl;
import sai.main.lang.parser.sai_normativeParser;
import sai.norms.sai.NormativeReasoner2Sai;
import sai.norms.sai.semantics.ISAINormativeListener;
import sai.norms.sai.semantics.NormInstance;
import sai.norms.sai.semantics.Obligation;
import sai.norms.sai.semantics.Prohibition;
import sai.util.SaiHttpServer;
import cartago.Artifact;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.OpFeedbackParam;

/**
 *  An artifact to give access to the SAI native normative engine.
 * 
 *  It can be used without coupling with the SAI constitutive state by using the methods operations 
 * addNormInstance, removeNormInstance, informFulfilledInstance, informViolatedInstance
 * 
 * (Still tighly coupled with SAI. ToDo: create a generic version and a SAI version (using const.state, status functions, etc))   
 * 
 * 
 * Operations:
 * 			- addNormativeProgram(fileName): loads normative program written in filename
 *          - addNormInstance(instance): adds a new norm instance
 * 
 * @author maiquel
 *
 **/
 
public class SaiNormArt extends Artifact implements ISAINormativeListener{
	private String id;
	private InstProgram constProgram;
	private NormativeReasoner2Sai nEngine = new NormativeReasoner2Sai();
	private ArrayList<NormInstance> normsToShow = new ArrayList<NormInstance>(); //a list of norms to be shown by the GUI representing the normative state
	private ArrayList<String> obligationsToShow = new ArrayList<String>(); //a friendly readable list of obligations   
	private ArrayList<String> prohibitionsToShow = new ArrayList<String>(); //a friendly readable list of prohibitions
	private ArrayList<String> fulfillmentsToShow = new ArrayList<String>(); //a friendly readable list of fulfillments
	private ArrayList<String> violationsToShow = new ArrayList<String>(); //a friendly readable list of violations
	private ArrayList<String> history = new ArrayList<String>();

	
	void init(String id){		
		this.id = id;
		this.nEngine.addSaiNormativeReasonerListener(this); //become a listener to be aware about the current normative state
	
		
		
		SaiHttpServer server = SaiHttpServer.getInstance();
		server.getServer().createContext(getContext()+ "/norms/", new MyHandler());
		server.getServer().createContext(getContext()+"/norms/obligations/", new ObligationsHandler());
		server.getServer().createContext(getContext()+"/norms/prohibitions/", new ProhibitionsHandler());
		server.getServer().createContext(getContext()+"/norms/fulfillments/", new FulfillmentsHandler());
		server.getServer().createContext(getContext()+"/norms/violations/", new ViolationsHandler());
		server.getServer().createContext(getContext()+"/norms/history/", new HistoryHandler());
		server.getServer().createContext(getContext()+"/norms/program/", new NormativeProgramHandler());
		
		log("SAI normative engine started. Go to http://localhost:" + SaiHttpServer.SAI_HTTP_SERVER_PORT+getContext() + "/norms to inspect the normative state");

	}
	
	void init(String id, String constitutiveProgram, String normativeProgramPath){
		this.init(id);
		this.constProgram = new InstProgram();
		try {
			internalAddConstitutiveProgram(constitutiveProgram);
			//Bad coupling below. TODO: instead of reading the program file, get as parameter an instance of InstProgram
			this.nEngine.setInstitutionalProgram(constProgram);
			internalAddNormativeProgram(normativeProgramPath);						 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	


	}
	
	
	@OPERATION
	void addNormativeProgram(String fileName) throws IOException{		
		this.internalAddNormativeProgram(fileName);
	}
	
	private void internalAddNormativeProgram(String fileName) throws IOException{
		InputStream is = new FileInputStream(fileName);			
		ANTLRInputStream input = new ANTLRInputStream(is);			
		sai_normativeLexer lexer = new sai_normativeLexer(input);		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		sai_normativeParser parser = new sai_normativeParser(tokens);
		ParseTree tree = parser.sai();
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker		
		sai_normativeListenerImpl extractor = new sai_normativeListenerImpl(this.nEngine); //links the nEngine to the parser
		walker.walk(extractor, tree); // initiate walk of tree with listener
	}
	
	
	
	private void internalAddConstitutiveProgram(String fileName) throws IOException{
		InputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		sai_constitutiveLexer constLexer = new sai_constitutiveLexer(input);		
		CommonTokenStream tokens = new CommonTokenStream(constLexer);
		sai_constitutiveParser constParser = new sai_constitutiveParser(tokens);
		ParseTree tree = constParser.constitutive_spec();
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		sai_constitutiveListenerImpl constExtractor = new sai_constitutiveListenerImpl(constProgram);
		walker.walk(constExtractor, tree); // initiate walk of tree with listener	
	}
	
	@OPERATION
	public void getNormativeEngine(OpFeedbackParam<INormativeEngine> nEngine){
		nEngine.set(this.nEngine);
	}


	@Override @OPERATION
	public void addNormInstance(NormInstance instance) {
		execInternalOp("internal_addNormInstance", instance);
	}
	
	@INTERNAL_OPERATION public void internal_addNormInstance(NormInstance instance){
		defineObsProperty(instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
		if(!normsToShow.contains(instance)){			
			normsToShow.add(instance);
		}
		addToHistory("Added norm instance " + instance);
	}

	
	@Override @OPERATION
	public void removeNormInstance(NormInstance instance) {

		if(getObsPropertyByTemplate("fulfilled", instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline())!=null){
			removeObsPropertyByTemplate("fulfilled", instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
			String s = "fulfilled(" + instance.getDeontic().toString() + "," + instance.getAttribute() + "," + ((StatusFunction)instance.getAim()).getId()+ "," + instance.getDeadline() + ")";
			if(fulfillmentsToShow.contains(s))
				fulfillmentsToShow.remove(s);
		}

		if(getObsPropertyByTemplate("violated", instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline())!=null){
			removeObsPropertyByTemplate("violated", instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
			String s = "violated(" + instance.getDeontic().toString() + "," + instance.getAttribute() + "," + ((StatusFunction)instance.getAim()).getId()+ "," + instance.getDeadline() + ")";
			if(violationsToShow.contains(s))
				violationsToShow.remove(s);
		}

		addToHistory("Removed norm instance " + instance);			
	}



	@Override @OPERATION
	public void informFulfilledInstance(NormInstance instance) {
		defineObsProperty("fulfilled", instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
		String s = "fulfilled(" + instance.getDeontic().toString() + "," + instance.getAttribute() + "," + ((StatusFunction)instance.getAim()).getId()+ "," + instance.getDeadline() + ")";
		if(!fulfillmentsToShow.contains(s))
			fulfillmentsToShow.add(s);
		addToHistory("Fulfilled " + instance);

		/* remove a fulfilled instance from the list of norm instances */
		removeObsPropertyByTemplate(instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
		if(normsToShow.contains(instance))			
			normsToShow.remove(instance);
	}


	@Override @OPERATION
	public void informViolatedInstance(NormInstance instance) {
		defineObsProperty("violated", instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
		String s = "violated(" + instance.getDeontic().toString() + "," + instance.getAttribute() + "," + ((StatusFunction)instance.getAim()).getId()+ "," + instance.getDeadline() + ")";
		if(!violationsToShow.contains(s))
			violationsToShow.add(s);
		addToHistory("Violated " + instance);

		/* remove a violated instance from the list of norm instances */
		removeObsPropertyByTemplate(instance.getDeontic().toString(), instance.getAttribute(), ((StatusFunction)instance.getAim()).getId(), instance.getDeadline());
		if(normsToShow.contains(instance))			
			normsToShow.remove(instance);
	}

	
	private void addToHistory(String s){
		history.add(new SimpleDateFormat("[yyyy/MM/dd_HH:mm:ss] ").format(Calendar.getInstance().getTime()) + s);
	}
	
	
	/*
	 * returns the context used in the http gui
	 */
	private String getContext(){		 
		if(this.id==null)
			return "";
		else
			return "/" + this.id.toLowerCase();
	}
	
	class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\"></font>";
			response = response + "<html><font face=\"arial\">Nonstitutive State <br></font>";
			response = response + "<iframe src=\""+ getContext() + "/norms/obligations/\"align=top width=\"100%\" height=\"20%\"></iframe>";
			//response = response + "<br><br><br><html><font face=\"arial\">Environmental State <br></font>";
			response = response + "<iframe src=\""+ getContext() + "/norms/prohibitions/\"align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ getContext() + "/norms/fulfillments/\"align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ getContext() + "/norms/violations/\"align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ getContext() + "/norms/program/\"align=top width=\"100%\" height=\"20%\"></iframe>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}


	class ObligationsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font size=\"2\" face=\"arial\" color=\"green\">Obligations</font><br><font face=\"arial\">";
			response = response + "----- <br>";
			for(NormInstance s:normsToShow){
				if(s.getDeontic() instanceof Obligation)
					response = response + s.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			//String response = "<html>teste</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	class ProhibitionsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">Prohibitions</font><br><font face=\"arial\">";			
			for(NormInstance s:normsToShow){
				if(s.getDeontic() instanceof Prohibition)
					response = response + s.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			//String response = "<html>teste</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	class FulfillmentsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">Fulfillments</font><br><font face=\"arial\">";			
			for(String s:fulfillmentsToShow){
				response = response + s.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			//String response = "<html>teste</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}


	class ViolationsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">Violations</font><br><font face=\"arial\">";			
			for(String s:violationsToShow){
				response = response + s.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			//String response = "<html>teste</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}	

	
	class NormativeProgramHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">Normative Program</font><br><font face=\"arial\">";
			for(String s:nEngine.getNormativeProgram()){
				response = response + s.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			//String response = "<html>teste</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}	


	
	class HistoryHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">NormativeHistory</font><br><font face=\"arial\">";
			String last = "";			
			String color = "blue";
			for(String s:history){
				if(!last.equals(s.substring(0, 21))){
					response = "<font face=\"arial\" color=\""+color+"\">" + response + "</font><br>";
					if(color.equals("blue"))
						color = "red";
					else
						color = "blue";
					last=s.substring(0, 21);
				}
				response = response + s.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}



}
