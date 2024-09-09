package sai.bridges.jacamo;

import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import cartago.Artifact;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.OpFeedbackParam;
import jason.asSyntax.Literal;
import jason.asSyntax.LiteralImpl;
import jason.asSyntax.Pred;
import jason.asSyntax.Structure;
import jason.asSyntax.parser.ParseException;
import npl.DynamicFactsProvider;
import npl.INorm;
import npl.LiteralFactory;
import npl.NPLInterpreter;
import npl.Norm;
import npl.NormInstance;
import npl.NormativeProgram;
import npl.Scope;
import npl.TimeTerm;
import npl.parser.nplp;
import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import sai.main.lang.parser.sai_constitutiveLexer;
import sai.main.lang.parser.sai_constitutiveListenerImpl;
import sai.main.lang.parser.sai_constitutiveParser;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StatusFunction;
import sai.norms.npl.npl2sai.NormSai;
import sai.norms.npl.npl2sai.Npl2Sai;
import sai.util.SaiHttpServer;

/**
 * This artifact gives access to NPL engine coupled with SAI.
 *  
 * observable properties:
 * 			obligation(A,R,G,D): the agent A is obliged to G due to R until D
 * 			fulfilled          : fulfilled obligation 
 * 			unfulfilled		   : unfulfilled obligation
 * 
 * @author maiquel
 *
 */
public class SaiNplArt extends Artifact implements npl.NormativeListener  {

	private String id;

	private NPLInterpreter nengine = new NPLInterpreter();	
	private NormativeProgram normativeProgram = new NormativeProgram();
	private Scope scope = new Scope(createLiteral("Sai2Npl"), normativeProgram);
	private Npl2Sai npl2sai;
	private InstProgram instProgram = new InstProgram();
	private ArrayList<String> history = new ArrayList<String>();

	ArrayList<Literal> obligationsToShow = new ArrayList<Literal>();
	ArrayList<Literal> fulfillmentsToShow = new ArrayList<Literal>();
	ArrayList<Literal> deactivationsToShow = new ArrayList<Literal>();
	
	private SaiEngine institution;


	
	


	/**
	 * 
	 * @param id : the institution id
	 * @param constitutiveProgram: path of the file
	 */
	public void init(String id, String constitutiveProgram){
		this.id = id;
		try {			
			internalAddConstitutiveProgram(constitutiveProgram);
			nengine.init();
			npl2sai = new Npl2Sai(nengine);
			nengine.addListener(this);
			setupHttpServer();
			setupNormsToTest();		
			nplp.setLiteralFactory(new LiteralFactory() {			
				public Literal createNPLLiteral(Literal l, DynamicFactsProvider dfp) {
					return new LiteralImpl(l);
				}

			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}						
	}
	
	@OPERATION
    public void setInstitution(SaiEngine institution){
    	this.institution = institution;
    	institution.addNormativeEngine(this.npl2sai);
    }

	//hardcoding norms to test...
	//TODO: create an parser for NPL programs
	private void setupNormsToTest(){							
		Npl2Sai npl2sai = new Npl2Sai(nengine);
		Norm n1, n2, n3, n4, n5;
		//TimeTerm t1 = new TimeTerm(1, "never");
		TimeTerm t1 = new TimeTerm(10, "year");
		

		try {
			instProgram.addStatusFunction(new EventStatusFunction(new Pred(parseLiteral("tangibleInteraction(Table,TangibleObject,X,Y,Actor)"))));
			instProgram.addStatusFunction(new EventStatusFunction(new Pred(parseLiteral("tangibleInteraction(Table,TangibleObject,X,Y,Actor)"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			//n1 = new NormSai("n1", parseLiteral("obligation(mayor,n1,evacuate(Zone),"+t1+")"), parseFormula("secure(Zone)"),this.instProgram);
			n1 = new NormSai("n1", parseLiteral("obligation(mayor,true,evacuate(Zone),"+Long.MAX_VALUE+")"), parseFormula("secure(Zone)"),this.instProgram);
			scope.addNorm(n1);
			n2 = new NormSai("n2", parseLiteral("obligation(firefighter,insecure(Zone),evacuate(Zone),"+"999999999"+")"), parseFormula("insecure(Zone)"),this.instProgram);
			scope.addNorm(n2);
			//n3 = new NormSai("n3", parseLiteral("obligation(interaction_inspector,n3,inform_invalid_evacuation(Zone, firefighter),"+t1+")"), parseFormula("secure(Zone)&sai__event(evacuate(Zone)[sai__agent(TriggerAgent)])&sai__is(TriggerAgent,firefighter)"),this.instProgram);
			n3 = new NormSai("n3", parseLiteral("obligation(interaction_inspector,n3,inform_invalid_evacuation(Zone, firefighter),"+Long.MAX_VALUE+")"), parseFormula("secure(Zone)&sai__event(evacuate(Zone)[sai__agent(TriggerAgent)])&sai__is(TriggerAgent,firefighter)"),this.instProgram);
			scope.addNorm(n3);
			//n4 = new NormSai("n4", parseLiteral("obligation(interaction_inspector,n4,inform_invalid_evacuation(Zone, mayor),"+t1+")"), parseFormula("insecure(Zone)&sai__event(evacuate(zone)[sai__agent(TriggerAgent)])&sai__is(TriggerAgent,mayor)"),this.instProgram);
			n4 = new NormSai("n4", parseLiteral("obligation(interaction_inspector,n4,inform_invalid_evacuation(Zone, mayor),"+Long.MAX_VALUE+")"), parseFormula("insecure(Zone)&sai__event(evacuate(zone)[sai__agent(TriggerAgent)])&sai__is(TriggerAgent,mayor)"),this.instProgram);
			scope.addNorm(n4);
			//n5 = new NormSai("n5", parseLiteral("obligation(table_mediator,n5,informTangibleInteraction(SourceTable,TangibleObject,X,Y),"+t1+")"), parseFormula("sai__event(tangibleInteraction(SourceTable,TangibleObject,X,Y,_)[sai__agent(_)])"),this.instProgram);
			n5 = new NormSai("n5", parseLiteral("obligation(table_mediator,n5,informTangibleInteraction(SourceTable,TangibleObject,X,Y),"+Long.MAX_VALUE+")"), parseFormula("sai__event(tangibleInteraction(SourceTable,TangibleObject,X,Y,_)[sai__agent(_)])"),this.instProgram);
			scope.addNorm(n5);
			
			

			nengine.loadNP(scope);
			
			
			


			//nengine.loadNP(scope);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public NPLInterpreter getNPLInterpreter(){
		return nengine;
	}

	private void setupHttpServer(){
		// The HTTP server
		SaiHttpServer server = SaiHttpServer.getInstance();
		server.getServer().createContext("/npl/" + this.id,new npl2saiHandler() );		
		server.getServer().createContext("/"+this.id+"_obligations_npl", new ObligationsHandler());
		server.getServer().createContext("/"+this.id+"_fulfillments_npl", new FulfillmentsHandler());
		server.getServer().createContext("/"+this.id+"_deactivations_npl", new DeactivationsHandler());
		server.getServer().createContext("/"+this.id+"_program_npl", new NplProgramHandler());
		server.getServer().createContext("/"+this.id+"_facts_npl", new NplFactsHandler());
		server.getServer().createContext("/npl/"+this.id+"/history", new HistoryHandler());

		
		log("To check npl norms, go to http://localhost:" + SaiHttpServer.SAI_HTTP_SERVER_PORT+"/npl/" + this.id);

	}

	private void internalAddConstitutiveProgram(String fileName) throws IOException{
		InputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		sai_constitutiveLexer constLexer = new sai_constitutiveLexer(input);		
		CommonTokenStream tokens = new CommonTokenStream(constLexer);
		sai_constitutiveParser constParser = new sai_constitutiveParser(tokens);
		ParseTree tree = constParser.constitutive_spec();
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		sai_constitutiveListenerImpl constExtractor = new sai_constitutiveListenerImpl(this.instProgram);
		walker.walk(constExtractor, tree); // initiate walk of tree with listener				
	}

	@OPERATION
	public void getNormativeEngine(OpFeedbackParam<INormativeEngine> nEngine){
		nEngine.set(this.npl2sai);
	}


	//@Override
	/*public void processNormativeStateUpdated(List<Literal> activeObligations, List<Literal> fulfilledObligations) {
		obligationsToShow.clear();
		for(Literal l:activeObligations){
			defineObsProperty("obligation", l.getTerms());
			obligationsToShow.add(l);
		}

		fulfillmentsToShow.clear();
		for(Literal l:fulfilledObligations){
			defineObsProperty("fulfilled", l.getTerms());
			fulfillmentsToShow.add(l);
		}
	}*/

	class npl2saiHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\">Normative State<br></font>";
			response = response + "<iframe src=\""+ "/"+id+"_obligations_npl\" align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ "/"+id+"_fulfillments_npl\" align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ "/"+id+"_deactivations_npl\" align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ "/"+id+"_program_npl\" align=top width=\"100%\" height=\"20%\"></iframe>";
			response = response + "<iframe src=\""+ "/"+id+"_facts_npl\" align=top width=\"100%\" height=\"20%\"></iframe>";
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
			for(Literal l : obligationsToShow){
				response = response + l.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	class FulfillmentsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {	
			String response = "<html><font size=\"2\" face=\"arial\" color=\"green\">Fulfillments</font><br><font face=\"arial\">";
			for(Literal l : fulfillmentsToShow){
				response = response + l.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	class DeactivationsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {	
			String response = "<html><font size=\"2\" face=\"arial\" color=\"green\">Deactivations</font><br><font face=\"arial\">";
			for(Literal l : deactivationsToShow){
				response = response + l.toString().replaceAll("Var", "_") + "<br>";
			}
			response = response + "</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	class NplProgramHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {	
			String response = "<html><font size=\"2\" face=\"arial\" color=\"green\">NPL Program</font><br><font size=\"2\" face=\"arial\">";
			for(INorm n:scope.getNorms()){
				response = response + "-- " + n + "<br>";
			}			
			response = response + "<br><br>";
			Iterator<Literal> it = nengine.getFacts().iterator();
			while(it.hasNext()){
				response = response + it.next() + "<br>";
			}
			response = response + "</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	class NplFactsHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {	
			String response = "<html><font size=\"2\" face=\"arial\" color=\"green\">Facts</font><br><font face=\"arial\">";
			Iterator<Literal> it = nengine.getFacts().iterator(); 
			while(it.hasNext()){
				response = response + it.next() + "<br>";
			}			
			response = response + "<br><br>";
			response = response + "</html>";
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




	@Override
	public void created(NormInstance o) {
		o.delAnnot(o.getAnnot("created"));		
		execInternalOp("internal_created", o);
		if(!obligationsToShow.contains(o)){
			obligationsToShow.add(o);
			addToHistory("Added obligation " + o);
		}
	}

	@INTERNAL_OPERATION
	void internal_created(Structure o){
		defineObsProperty(o.getFunctor().toString(), o.getTerm(0), o.getTerm(1), o.getTerm(2), o.getTerm(3));
		//log("defining property " + o.getFunctor().toString() + "(" + o.getTerm(0) + "," + o.getTerm(1) + "," +o.getTerm(2) + "," +o.getTerm(3) + "," +")");
		StatusFunction sf = instProgram.getStatusFunctionByName(o.getTerm(2).toString());
		if(sf!=null){
			if(sf instanceof AgentStatusFunction)
				defineObsProperty("agent_status_function", sf.getId());
			else if(sf instanceof EventStatusFunction)
				defineObsProperty("event_status_function", sf.getId());
			else if(sf instanceof EventStatusFunction)
				defineObsProperty("state_status_function", sf.getId());
		}

	}

	@Override
	public void fulfilled(NormInstance o) {
		o.delAnnot(o.getAnnot("done"));
		o.delAnnot(o.getAnnot("fulfilled"));
		execInternalOp("internal_fulfilled", o);
		Literal toRemove = null;
		for(Literal l:obligationsToShow)
			try {
				if(l.toString().equals(parseLiteral("obligation("+o.getTerm(0)+"," +o.getTerm(1)+"," +o.getTerm(2)+"," +o.getTerm(3)+")").toString())){
					toRemove = l;					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		if(toRemove!=null)
			obligationsToShow.remove(toRemove);		
		fulfillmentsToShow.add(o);	
		addToHistory("Fulfilled obligation " + o);
	}

	@INTERNAL_OPERATION
	void internal_fulfilled(NormInstance o){
		removeObsPropertyByTemplate("obligation", o.getTerm(0), o.getTerm(1), o.getTerm(2), o.getTerm(3));
		defineObsProperty(o.getFunctor(), o.getTerms());		
	}

	@Override
	public void unfulfilled(NormInstance o) {
		execInternalOp("internal_unfulfilled", o);		
	}


	@INTERNAL_OPERATION
	void internal_unfulfilled(NormInstance o){
		removeObsPropertyByTemplate("obligation", o.getTerm(0), o.getTerm(1), o.getTerm(2), o.getTerm(3));
		defineObsProperty(o.getFunctor(), o.getTerms());		
	}

	@Override
	public void inactive(NormInstance o) {
		o.delAnnot(o.getAnnot("inactive"));
		execInternalOp("internal_inactive", o);
		Literal toRemove = null;
		for(Literal l:obligationsToShow)
			try {
				if(l.toString().equals(parseLiteral("obligation("+o.getTerm(0)+"," +o.getTerm(1)+"," +o.getTerm(2)+"," +o.getTerm(3)+")").toString())){
					toRemove = l;					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		if(toRemove!=null)
			obligationsToShow.remove(toRemove);		
		deactivationsToShow.add(o);
		addToHistory("Deactivated obligation " + o);
	}
	
	@INTERNAL_OPERATION
	void internal_inactive(NormInstance o){
		removeObsPropertyByTemplate("obligation", o.getTerm(0), o.getTerm(1), o.getTerm(2), o.getTerm(3));
		defineObsProperty(o.getFunctor(), o.getTerms());		
	}

	@Override
	public void failure(Structure f) {
		try{		
			removeObsPropertyByTemplate("obligation", f.getTerms());
		}catch(Exception e){
			if(!e.getMessage().equals("invalid observable property: obligation"))
				e.printStackTrace();
		}
		defineObsProperty(f.getFunctor(), f.getTerms());
		addToHistory("Failed obligation " + f.getFunctor() + "  " + f.getTerms());
	}

	//just to test..
	/*
	private String getProgram(String fileName){
		InputStream is;
		try {
			is = new FileInputStream(fileName);
			return is.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";		
	}
	 */
	public String getFileContent( String fileName ) throws IOException {
		/*StringBuilder sb = new StringBuilder();	  
	    Reader r = new InputStreamReader(new FileInputStream(fileName));  //or whatever encoding	    
	    int ch = r.read();
	    while(ch >= 0) {
	        sb.append(ch);
	        ch = r.read();
	    }
	    return sb.toString();*/
		/*String result = "";
		try {
			String str;
			BufferedReader in = new BufferedReader(new FileReader(fileName));			
			while((str = in.readLine()) != null){
				result = result.concat(str);		    
			}
			in.close();			
		} 
		catch (IOException e){    
		}*/
		String result = "";
		try {
			String str;		
			BufferedReader in = new BufferedReader(new FileReader(fileName));			
			while((str = in.readLine()) != null){
				result = result.concat(str);		    
			}
			in.close();			
		} 
		catch (IOException e){    
		}

		return result;
	}


	@OPERATION
	public void loadNplProgram(String fileName){
		try {
			NormativeProgram p = new NormativeProgram();
			//new nplp(new StringReader(getFileContent(fileName))).program(p, null);
			nplp parser = new nplp(new FileInputStream(fileName));
			parser.program(p, null);


			scope = p.getRoot();
			nengine.loadNP(scope);
			
			
			
		} catch (IOException | npl.parser.ParseException  e) {
			// TODO Auto-generated catch blocke
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addToHistory(String s){
		history.add(new SimpleDateFormat("[yyyy/MM/dd_HH:mm:ss] ").format(Calendar.getInstance().getTime()) + s);
	}
}
