package sai.bridges.jacamo;

import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.createAtom;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import sai.main.institution.ConstitutiveListener;
import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import sai.main.lang.parser.sai_constitutiveLexer;
import sai.main.lang.parser.sai_constitutiveListenerImpl;
import sai.main.lang.parser.sai_constitutiveParser;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.util.SaiHttpServer;
import cartago.Artifact;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.OpFeedbackParam;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * properties:
 *   - constitutive_rule(X,Y,T,M)
 *   - agent_sf(F) : F is an agent status function
 *   - event_sf(F) : F is an agent status function
 *   - state_sf(F) : F is an agent status function
 *   - sai__is(X,Y) : X counts as Y (for agent- and state-status functions)
 *   - sai__is(X,E,A) : X counts as the event-status function E due to an action performed by the agent As
 *
 * Operations:
 *   - getRuleEngine(R):
 *   - addNormativeEngine(N): register the normative engine N as a client to be updated when the constitutive state changes
 *   - loadConstitutiveProgram(F): loads the constitutive program written in the file F
 * 
 * @author maiquel
 */

public class ConstitutiveArt extends Artifact implements ConstitutiveListener{

    private RuleEngine ruleEngine;
    private SaiEngine sai;
    private String id = null;//an optional identifier for the institution
    private ArrayList<String> agentAssignmentsToShow = new ArrayList<String>();
    private ArrayList<String> eventAssignmentsToShow = new ArrayList<String>();
    private ArrayList<String> stateAssignmentsToShow = new ArrayList<String>();




    void init(String id, String constitutiveProgramPath) {
        log("SAI Engine version 0.5-dev-13 " + id);        
        defineObsProperty("institution", createAtom(id));        
        this.ruleEngine = new RuleEngine();
        sai = new SaiEngine();
        this.id = id;
        this.ruleEngine.addInstitution(sai);
        this.sai.addConstitutiveListener(this);
  

        String filename = constitutiveProgramPath.replaceAll("^(file:)(.*)", "$2"); //handle file information started by "file:"

        try {
            loadConstitutiveProgram(filename);           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   


        //The HTTP server
        SaiHttpServer server = SaiHttpServer.getInstance();
        //server.getServer().createContext(getContext()+ "/", new MyHandler());
        server.getServer().createContext(getContext(), new MyHandler());
        server.getServer().createContext(getContext()+"/assignments", new AssignmentsHandler());
        server.getServer().createContext(getContext()+"/environment", new EnvironmentalStateHandler());
        server.getServer().createContext(getContext()+"/constProgram", new ConstitutiveProgramHandler());
        server.getServer().createContext(getContext()+"/ignoredArts", new IgnoredArtifactsHandler());
        
        log("Institution \"" + id + "\" started. Go to http://localhost:" + SaiHttpServer.SAI_HTTP_SERVER_PORT+ getContext() + " to inspect the constitutive state.");

    }

/*
    void init(String normativeProgramPath, String constitutiveProgramPath) {
        this.ruleEngine = new RuleEngine();
        sai = new SaiEngine();
        this.ruleEngine.addInstitution(sai);
        this.sai.addConstitutiveListener(this);
    
        try {
            loadConstitutiveProgram(constitutiveProgramPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
        
        
        //The HTTP server
        SaiHttpServer server = SaiHttpServer.getInstance();
        server.getServer().createContext(getContext()+ "/", new MyHandler());
        server.getServer().createContext(getContext()+"/assignments", new AssignmentsHandler());
        server.getServer().createContext(getContext()+"/environment", new EnvironmentalStateHandler());
        
        }
*/  
    
    /**
     * Returns a reference for the Rule Engine, that is the CArtAgO engine t
     * hat feeds the Constitutive Engine with facts from the environmental facts
     * @param engine
     */
    @OPERATION 
    public void getRuleEngine(OpFeedbackParam<RuleEngine> engine){
        engine.set(this.ruleEngine);
    }
    
    @OPERATION 
    public void getSaiEngine(OpFeedbackParam<SaiEngine> engine){
        engine.set(this.sai);
    }
    
    @OPERATION
    void loadConstitutiveProgram(String fileName) throws IOException{
        this.internalLoadConstitutiveProgram(fileName);
    }



    /**
     * Register the normative engine N as a client to be updated when the constitutive state changes
     * @param normativeEngine
     */
    @OPERATION
    public void addNormativeEngine(INormativeEngine normativeEngine){
        this.sai.addNormativeEngine(normativeEngine);       
    }
    

    // returns the context used in the http gui
    private String getContext(){         
        if(this.id==null)
            return "";
        else
            return "/" + this.id.toLowerCase();
    }



    private void internalLoadConstitutiveProgram(String fileName) throws IOException{
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

    

    @INTERNAL_OPERATION void addConstitutiveRule(ConstitutiveRule c){
        Pred x;
        if(c.getX() != null)
            x = c.getX();
        else
            x = new Pred("freestanding");
        try {
            LogicalFormula t;
            LogicalFormula m;
            if(c.getT() != null)
                t = c.getT();
            else        
                t = parseFormula("true");

            if(c.getM() != null)
                m = c.getM();
            else
                m = parseFormula("true");
            
            //the term Y of the constitutive rule must be casted to LogicalFormula to macth with the aim of the norm 
            defineObsProperty("constitutive_rule", x, parseFormula(c.getY().toString()),t,m);

            
            if(sai.getProgram().getStatusFunctionByName(c.getY().toString()) instanceof AgentStatusFunction){
                defineObsProperty("agent_sf", c.getY().getId());    
            }else
                if(sai.getProgram().getStatusFunctionByName(c.getY().toString()) instanceof EventStatusFunction){
                    defineObsProperty("event_sf", c.getY().getId());    
                }else
                    if(sai.getProgram().getStatusFunctionByName(c.getY().toString()) instanceof StateStatusFunction){
                        defineObsProperty("state_sf", c.getY().getId());    
                    }
                    
    
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }






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
            Atom agent) {
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
    
    /**
     * Add the artifactName to the list of to be ignored artifacts    
     * @param artifactName
     */
    @OPERATION
    public void ignoreArtifact(String artifactName) {
    	this.ruleEngine.addArtifactToIgnore(artifactName);
    }
    
    /**
     * Remove the artifactName from the list of to be ignored artifacts    
     * @param artifactName
     */
    @OPERATION
    public void accountArtifact(String artifactName) {
    	this.ruleEngine.removeArtifactToIgnore(artifactName);
    }

    class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<html><font face=\"arial\"></font>";
            response = response + "<html><font face=\"arial\">SAI Constitutive State <br></font>";
            response = response + "<iframe src=\""+ getContext() + "/assignments\"align=top width=\"100%\" height=\"40%\"></iframe>";
            response = response + "<br><br><br><html><font face=\"arial\">Environmental State <br></font>";
            response = response + "<iframe src=\""+ getContext() + "/environment\"align=top width=\"100%\" height=\"40%\"></iframe>";
            response = response + "<br><br><br><html><font face=\"arial\">Constitutive Program <br></font>";
            response = response + "<iframe src=\""+ getContext() + "/constProgram\"align=top width=\"100%\" height=\"40%\"></iframe>";
            response = response + "<br><br><br><html><font face=\"arial\">Ignored Artifacts <br></font>";
            response = response + "<iframe src=\""+ getContext() + "/ignoredArts\"align=top width=\"100%\" height=\"40%\"></iframe>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    class AssignmentsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<html>";
            response = response + "<br><font face=\"arial\" color=\"green\">Agent-status function assignments:<br></font><font face=\"arial\">";
            for(String s:agentAssignmentsToShow){
                response = response + s.toString().replaceAll("Var", "_") + "<br>";
            }               
            response = response + "<br><font face=\"arial\" color=\"green\">Event-status function assignments:<br></font><font face=\"arial\">";
            for(String s:eventAssignmentsToShow){
                response = response + s.toString().replaceAll("Var", "_") + "<br>";
            }
            response = response + "<br><font face=\"arial\" color=\"green\">State-status function assignments:<br></font><font face=\"arial\">";
            for(String s:stateAssignmentsToShow){
                response = response + s.toString().replaceAll("Var", "_") + "<br>";
            }
            response = response + "</html>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    class EnvironmentalStateHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            ArrayList<Literal> envState = ruleEngine.getCurrentEnvironmentalState();
            ArrayList<String> agents = new ArrayList<String>();
            ArrayList<String> events = new ArrayList<String>();
            ArrayList<String> state = new ArrayList<String>();
            for(Literal l : envState){
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
    
    class ConstitutiveProgramHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<html>";
            response = response + "<br><font face=\"arial\" color=\"green\">Constitutive program:<br></font><font face=\"arial\">";
            for(ConstitutiveRule r: sai.getProgram().getConstitutiveRules()) {
            	response = response + r.toString().replaceAll("Var", "_") + "<br>";
            }            
            response = response + "</html>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    class IgnoredArtifactsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<html>";
            response = response + "<br><font face=\"arial\" color=\"green\">Ignored artifacts<br></font><font face=\"arial\">";
            for(String s: new ArrayList<String>(ruleEngine.getArtifactsToIgnore().values())) {
            	response = response + s + "<br>"; 
            }
            response = response + "</html>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }




}
