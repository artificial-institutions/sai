package sai.bridges.jacamo;

import sai.main.institution.INormativeEngine;
import sai.norms.pav.NormativeReasonerPAV2Sai;
import sai.norms.pav.normativeReasoner.IPAVNormativeListener;
import sai.util.SaiHttpServer;
import jason.RevisionFailedException;
import jason.asSyntax.Pred;
import jason.asSyntax.Term;
import jason.asSyntax.parser.ParseException;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import cartago.Artifact;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.OpFeedbackParam;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SaiPAV4JacamoArt extends Artifact implements /*ConstitutiveListener,*/ IPAVNormativeListener {

	private String id;
	private NormativeReasonerPAV2Sai normativeReasoner;
	private ArrayList<Pred> normsToShow = new ArrayList<Pred>();
	private ArrayList<String> history = new ArrayList<String>();
	private ArrayList<Pred> fulfillmentsToShow = new ArrayList<Pred>(); //a friendly readable list of fulfillments
	private ArrayList<Pred> violationsToShow = new ArrayList<Pred>(); //a friendly readable list of violations
	
	void init(String id) {				
		this.id = id;
		
		
		//setup of the normative engine
		this.normativeReasoner = new NormativeReasonerPAV2Sai();
		this.normativeReasoner.addPAVNormativeReasonerListener(this);
		/*		
		sai.setNormativeEngine(this.normativeReasoner);

		defineObsProperty("obliged", "a","i","cd");
		defineObsProperty("prohibited", "a","i","cd");

		try {
			internalAddConstitutiveProgram(constitutiveProgramPath);
			*/
			internalAddNormativeProgram(); //TODO: parse PAV normative program
		/*

		} catch (IOException e) {

			e.printStackTrace();
		}	


		*/
		// The HTTP server
		SaiHttpServer server = SaiHttpServer.getInstance();
		server.getServer().createContext("/pav/" + this.id,new pavHandler() );		
		//server.getServer().createContext( "/", new MyHandler());
		server.getServer().createContext("/"+this.id+"_obligations_pav", new ObligationsHandler());
		server.getServer().createContext("/"+this.id+"_fulfillments_pav", new FulfillmentsHandler());
		server.getServer().createContext("/"+this.id+"_violations_pav", new ViolationsHandler());
		server.getServer().createContext("/"+this.id+"_assignments_pav", new AssignmentsHandler());
		server.getServer().createContext("/pav/" + this.id+"/history_pav", new HistoryHandler());
		//server.getServer().createContext("/environment_pav", new EnvironmentalStateHandler());
		
		log("To check npl norms, go to http://localhost:" + SaiHttpServer.SAI_HTTP_SERVER_PORT+"/pav/" + this.id);

	}

	@OPERATION
	public void getNormativeEngine(OpFeedbackParam<INormativeEngine> nEngine){
		nEngine.set(this.normativeReasoner);
	}

	/*
	@OPERATION 
	public void getRuleEngine(OpFeedbackParam<RuleEngine> engine){
		engine.set(this.ruleEngine);
	}
	*/

	
	@Override @OPERATION
	public void addNormInstance(Pred instance) {
		execInternalOp("internal_addNormInstance", instance);
	}
	
	
	

	@INTERNAL_OPERATION public void internal_addNormInstance(Pred instance){
		log("going to add instance");
		Term params[] = new Term[instance.getTerms().size()];
		for(int i=0;i<instance.getTerms().size();i++)
		for(Term t:instance.getTerms())
			params[i] = instance.getTerm(i);
		defineObsProperty(instance.getFunctor(), params);
		if(!normsToShow.contains(instance)){			
			normsToShow.add(instance);
		}
		addToHistory("Added norm instance " + instance);
	}

	

	
	@Override @OPERATION
	public void removeNormInstance(Pred instance) {
		if(getObsPropertyByTemplate("fulfilled", instance.getTerms())!=null){
			removeObsPropertyByTemplate("fulfilled", instance.getTerms());
			Pred s = new Pred("fulfilled");
			s.addTerms(instance.getTerms());
			if(fulfillmentsToShow.contains(s))
				fulfillmentsToShow.remove(s);
		}

		if(getObsPropertyByTemplate("violated", instance.getTerms())!=null){
			removeObsPropertyByTemplate("violated", instance.getTerms());
			Pred s = new Pred("violated");
			s.addTerms(instance.getTerms());
			if(violationsToShow.contains(s))
				violationsToShow.remove(s);
		}

		addToHistory("Removed norm instance " + instance.toString());			
	}
	

	
	
	@Override @OPERATION
	public void informFulfilledInstance(Pred instance) {
		defineObsProperty("fulfilled", instance.getTerms());
		Pred s = new Pred("fulfilled");
		s.addTerms(instance.getTerms());
		if(!fulfillmentsToShow.contains(s))
			fulfillmentsToShow.add(s);
		addToHistory("Fulfilled " + instance.toString());

		// remove a fulfilled instance from the list of norm instances 
		Term params[] = new Term[instance.getTerms().size()];
		for(int i=0;i<instance.getTerms().size();i++)
			params[i] = instance.getTerm(i);
		removeObsPropertyByTemplate(instance.getFunctor(), params);		
		if(normsToShow.contains(instance))			
			normsToShow.remove(instance);
	}

	

	
	@Override @OPERATION
	public void informViolatedInstance(Pred instance) {
		defineObsProperty("violated", instance.getTerms());
		Pred s = new Pred("violated");
		s.addTerms(instance.getTerms());
		if(!violationsToShow.contains(s))
			violationsToShow.add(s);
		addToHistory("Violated " + instance.toString());

		// remove a violated instance from the list of norm instances 
		Term params[] = new Term[instance.getTerms().size()];
		for(int i=0;i<instance.getTerms().size();i++)
			params[i] = instance.getTerm(i);
		removeObsPropertyByTemplate("as", params);
		if(normsToShow.contains(instance))			
			normsToShow.remove(instance);
	}
	
	
	
	/*
	@Override
	public void addStateAssignment(String assignee, StateStatusFunction sf) {
		defineObsProperty("sai_is", assignee, sf.getId());
		stateAssignmentsToShow.add(assignee + " is " + sf);

	}

	@Override
	public void addAgentAssignment(String assignee, AgentStatusFunction sf) {
		defineObsProperty("sai_is", assignee, sf.getId());
		agentAssignmentsToShow.add(assignee + " is " + sf);

	}

	@Override
	public void addEventAssignment(String assignee, EventStatusFunction sf,
			AgentStatusFunction agent) {
		defineObsProperty("sai_is", assignee, sf.getId(),agent.toString());
		eventAssignmentsToShow.add(assignee + " is " + sf + " caused by " + agent);
	}

	@Override
	public void removeStateAssignment(String assignee, StateStatusFunction sf) {
		if(stateAssignmentsToShow.contains(assignee + " is " + sf))
			stateAssignmentsToShow.remove(assignee + " is " + sf);
	}

	@Override
	public void removeAgentAssignment(String assignee, AgentStatusFunction sf) {
		if(agentAssignmentsToShow.contains(assignee + " is " + sf))
			agentAssignmentsToShow.remove(assignee + " is " + sf);
	}

	@Override
	public void removeEventAssignment(String assignee, EventStatusFunction sf,
			AgentStatusFunction agent) {
		if(eventAssignmentsToShow.contains(assignee + " is " + sf + " caused by " + agent))
			eventAssignmentsToShow.remove(assignee + " is " + sf + " caused by " + agent);


	}

	*/
	private void addToHistory(String s){
		history.add(new SimpleDateFormat("[yyyy/MM/dd_HH:mm:ss] ").format(Calendar.getInstance().getTime()) + s);
	}


	/*
	private void internalAddConstitutiveProgram(String fileName) throws IOException{
		InputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		sai_constitutiveLexer constLexer = new sai_constitutiveLexer(input);		
		CommonTokenStream tokens = new CommonTokenStream(constLexer);
		sai_constitutiveParser constParser = new sai_constitutiveParser(tokens);
		ParseTree tree = constParser.constitutive_spec();
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		sai_constitutiveListenerImpl constExtractor = new sai_constitutiveListenerImpl(sai.getProgram());
		walker.walk(constExtractor, tree); // initiate walk of tree with listener
		for(ConstitutiveRule c:sai.getProgram().getConstitutiveRules()){
			execInternalOp("addConstitutiveRule", c);
		}
	}
	*/
	
	private void internalAddNormativeProgram(){
		try { 			
			this.normativeReasoner.addNorm("norm(Ag,secure(Zone)&sai__is(Ag,mayor),secure(Zone),sai__event(evacuate(Zone),Ag)|not(sai__is(Ag,mayor)),false,not(secure(Zone)))");
			this.normativeReasoner.addNorm("norm(Ag,secure(Zone)&sai__is(Ag,firefighter),not(sai__event(evacuate(Zone),Ag)),(not(secure(Zone)))|not(sai__is(Ag,firefighter)),false,not(secure(Zone)))");
			
			this.normativeReasoner.addNorm("norm(Ag,insecure(Zone)&sai__is(Ag,firefighter),insecure(Zone),sai__event(evacuate(Zone),Ag)|not(sai__is(Ag,firefighter)),false,not(insecure(Zone)))");
			this.normativeReasoner.addNorm("norm(Ag,insecure(Zone)&sai__is(Ag,mayor),not(sai__event(evacuate(Zone),Ag)),(not(insecure(Zone)))|not(sai__is(Ag,mayor)),false,not(insecure(Zone)))");
			
			this.normativeReasoner.addNorm("norm(Ag,tangibleInteraction(SourceTable,TangibleObject,X,Y,_)&sai__is(Ag,table_mediator),not(tangibleInteraction(OtherTable,OtherObject,OtherX,OtherY,_)&not(OtherTable==SourceTable&OtherObject==TangibleObject&OtherX==X&OtherY==Y)),informTangibleInteraction(SourceTable,TangibleObject,X,Y),false,tangibleInteraction(OtherTable,OtherObject,OtherX,OtherY,_)&not(OtherTable==SourceTable&OtherObject==TangibleObject&OtherX==X&OtherY==Y))");
			
			this.normativeReasoner.addNorm("norm(Ag,secure(Zone)&evacuate(downtown)[sai__agent(TriggerAgent)]&sai__is(TriggerAgent,firefighter)& sai__is(Ag,interaction_inspector), true, inform_invalid_evacuation(Zone, firefighter), false, false)");
			this.normativeReasoner.addNorm("norm(Ag,insecure(Zone)&evacuate(downtown)[sai__agent(TriggerAgent)]& sai__is(TriggerAgent,mayor) & sai__is(Ag,interaction_inspector), true, inform_invalid_evacuation(Zone, mayor), false, false)");
					     		     			
			
		} catch (RevisionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/*
	class MyHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\">SAI Normative State<br></font>";
			response = response + "<iframe src=\""+ "/obligations\" align=top width=\"100%\" height=\"12%\"></iframe>"; 
			//response = response + "<iframe src=\""+ "/prohibitions\"align=top width=\"100%\" height=\"12%\"></iframe>";
			response = response + "<iframe src=\""+ "/fulfillments\"align=top width=\"100%\" height=\"12%\"></iframe>";
			response = response + "<iframe src=\""+ "/violations\"align=top width=\"100%\" height=\"12%\"></iframe>";
			response = response + "<br><br><br><html><font face=\"arial\">SAI Constitutive State <br></font>";
			response = response + "<iframe src=\""+ "/assignments\"align=top width=\"100%\" height=\"46%\"></iframe>";
			response = response + "<br><br><br><html><font face=\"arial\">Environmental State <br></font>";
			response = response + "<iframe src=\""+ "/environment\"align=top width=\"100%\" height=\"12%\"></iframe>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
	*/
	
	class ObligationsHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font size=\"2\" face=\"arial\" color=\"green\">Obligations</font><br><font face=\"arial\">";
			for(Pred s:normsToShow){
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
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">Fulfillments</font><br><font face=\"arial\">";			
			for(Pred s:fulfillmentsToShow){
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
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\" color=\"green\">Violations</font><br><font face=\"arial\">";			
			for(Pred s:violationsToShow){
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


	class AssignmentsHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			String response = "<html>";
			response = response + "<br><font face=\"arial\" color=\"green\">Agent-status function assignments:<br></font><font face=\"arial\">";
			//for(String s:agentAssignmentsToShow){
			//	response = response + s.toString().replaceAll("Var", "_") + "<br>";
			//}
			response = response + "<br><font face=\"arial\" color=\"green\">Event-status function assignments:<br></font><font face=\"arial\">";
			//for(String s:eventAssignmentsToShow){
			//	response = response + s.toString().replaceAll("Var", "_") + "<br>";
			//}
			response = response + "<br><font face=\"arial\" color=\"green\">State-status function assignments:<br></font><font face=\"arial\">";
			//for(String s:stateAssignmentsToShow){
			//	response = response + s.toString().replaceAll("Var", "_") + "<br>";
			//}
			response = response + "</html>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
	
	class pavHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><font face=\"arial\">	Normative State<br></font>";
			response = response + "<iframe src=\""+ "/"+id +"_obligations_pav\" align=top width=\"100%\" height=\"12%\"></iframe>"; 
			response = response + "<iframe src=\""+ "/"+id +"_fulfillments_pav\"align=top width=\"100%\" height=\"12%\"></iframe>";
			response = response + "<iframe src=\""+ "/"+id +"_violations_pav\"align=top width=\"100%\" height=\"12%\"></iframe>";
			//response = response + "<br><br><br><html><font face=\"arial\">SAI Constitutive State <br></font>";
			//response = response + "<iframe src=\""+ "/assignments\"align=top width=\"100%\" height=\"46%\"></iframe>";
			//response = response + "<br><br><br><html><font face=\"arial\">Environmental State <br></font>";
			//response = response + "<iframe src=\""+ "/environment\"align=top width=\"100%\" height=\"12%\"></iframe>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	/*
	class EnvironmentalStateHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			//ArrayList<Literal> envState = ruleEngine.getCurrentEnvironmentalState();
			ArrayList<String> agents = new ArrayList<String>();
			ArrayList<String> events = new ArrayList<String>();
			ArrayList<String> state = new ArrayList<String>();
			for(Literal l : envState){
				//response = response + l.toString()+ "<br>";
				if(l.getFunctor().toString().equals("sigmaA")){
					agents.add(l.getTerm(0).toString());					
				}
				else
					if(l.getFunctor().toString().equals("sigmaE"))
						events.add(l.getTerm(0).toString());
					else
						state.add(l.toString());
			}
			String response = "<html><font face=\"arial\" color=\"green\">Agents</font><br><font face=\"arial\">";
			for(String a:agents)
				response = response + a + "<br>";
			response = response + "<br>";
			response = response + "<html><font face=\"arial\" color=\"green\">Events</font><br><font face=\"arial\">";
			for(String e:events)
			{if(!e.equals("true")) //TODO: fix this awful quickfix!!!
				response = response + e + "<br>";
			}
			response = response + "<br>";
			response = response +"<html><font face=\"arial\" color=\"green\">States</font><br><font face=\"arial\">";
			for(String s:state)
				response = response + s + "<br>";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
*/

}
