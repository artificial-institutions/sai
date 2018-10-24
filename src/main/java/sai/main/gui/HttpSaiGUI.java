package sai.main.gui;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import sai.util.reasoner.BasicReasonerHttpGUI;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HttpSaiGUI extends BasicReasonerHttpGUI /*implements SaiGUI, Observer*/{

    protected HttpSaiGUI(int port) {
        super(port);
    
    }

    private static BasicReasonerHttpGUI gui = null;
    private List<String> beliefs = new ArrayList<String>();
    
    public static HttpSaiGUI getInstance(){
        gui = get(8003);
        return (HttpSaiGUI) gui;
    }


    class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {                      
            String requestMethod = exchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {
                Headers responseHeaders = exchange.getResponseHeaders();
                responseHeaders.set("Content-Type", "text/plain");
                exchange.sendResponseHeaders(200, 0);

                String s = "";
                OutputStream responseBody = exchange.getResponseBody();
                Headers requestHeaders = exchange.getRequestHeaders();
                ArrayList<String> crules = new ArrayList<String>();
                
                ArrayList<String> sfs = new ArrayList<String>();
                ArrayList<String> environment = new ArrayList<String>();
                ArrayList<String> assignments = new ArrayList<String>();
                ArrayList<String> rules = new ArrayList<String>();
                ArrayList<String> norms = new ArrayList<String>();
                ArrayList<String> others = new ArrayList<String>();
                ArrayList<String> normInstances = new ArrayList<String>();
                ArrayList<String> normViolated = new ArrayList<String>();
                for(String bel:beliefs){
                    if(bel.substring(0, 5).equals("sigma"))
                        environment.add(bel);
                    else
                        if(bel.substring(0, 8).equals("sai__is("))
                            assignments.add(bel);
                        else
                            if(bel.substring(0, 11).equals("sai__crule("))
                                crules.add(bel);
                            
                                    else    
                                        if(bel.substring(0,8).equals("sai__af(")|bel.substring(0, 8).equals("sai__ef(")|bel.substring(0,8).equals("sai__sf("))
                                            sfs.add(bel);
                                        else
                                            if(bel.substring(0,10).equals("sai__norm("))
                                                norms.add(bel);
                                            else
                                                if(bel.substring(0, 18).equals("sai__active__norm("))
                                                    normInstances.add(bel);
                                                else
                                                    if(bel.substring(0, 20).equals("sai__violated__norm("))
                                                        normViolated.add(bel);
                                                    else
                                                        if(bel.indexOf(":-")>-1)
                                                            rules.add(bel);
                                                        else
                                                            others.add(bel);

                    //s = bel + "\n";
                    //responseBody.write(s.getBytes()); 
                }


                s = s + "Status Functions\n";
                s = s + "================\n\n";
        
                for(String st:sfs){
                    s = s + st+ "\n";
                }
                s = s + "\nNorms\n";
                s = s +   "=====\n\n";
                for(String st:norms){
                    s = s + st+ "\n";
                }
                s = s + "\nConstitutive Rules\n";
                s = s + "=======\n\n";
                for(String st:crules){
                    s = s + " - " + st+ "\n";
                }
                s = s + "\nRules\n";
                s = s +   "=====\n\n";
                for(String st:rules){
                    s = s + st+ "\n";
                }
                s = s + "\nEnvironmental state\n";
                s = s +   "===================\n\n";
                for(String st:environment){
                    s = s + st+ "\n";
                }
                s = s + "\nConstitutive state\n";
                s = s +   "==================\n\n";
                for(String st:assignments){
                    s = s + " - " + st+ "\n";
                }
                s = s + "\nNormative state\n";
                s = s +   "==================\n\n";
                s = s + "\n     Norm instances\n";
                s = s +   "     ==============\n\n";
                for(String st:normInstances){
                    s = s + "   - " + st+ "\n";
                }
                s = s + "\n     Norm violations\n";
                s = s +   "     ===============\n\n";
                for(String st:normViolated){
                    s = s + "   - " + st+ "\n";
                }
                s = s + "\nOther\n";
                s = s +   "=====\n\n";
                for(String st:others){
                    s = s + st+ "\n";
                }

                responseBody.write(s.getBytes());
                responseBody.close();

            }
        }
    }


/*
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Reasoner){
            Iterator it = ((Reasoner) o).getBeliefs();
            beliefs.clear();
            while(it.hasNext()){
                beliefs.add(it.next().toString());
            }

        }

    }
*/  
/*
    @Override
    public void updateReasonerBeliefs(List<String> beliefs) {
        // TODO Auto-generated method stub

    }


*/
    /*
    @Override
    public void updateReasonerBeliefs(List<String> beliefs) {
        this.beliefs = beliefs;

    }
     */

}