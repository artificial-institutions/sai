package sai.util.reasoner;

import java.io.IOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * A basic http GUI
 * @author maiquel
 *
 */

public class BasicReasonerHttpGUI implements IReasonerHttpGUI{

    static BasicReasonerHttpGUI singleton = null;
    private List<IReasoner> reasoners = new ArrayList<IReasoner>();
    protected List<String> beliefs = new ArrayList<String>();
    private int port = 0;


    protected BasicReasonerHttpGUI(int port) {
        super();
        startServer(port);        
    }

    private void startServer(int port) {
        try {
            InetSocketAddress addr = new InetSocketAddress(port);           
            HttpServer server;
            server = HttpServer.create(addr, 0);
            server.createContext("/", new MyHandler());
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            this.port = port;
            System.out.println("Reasoner running at port " + this.port);
        } 
        catch (BindException e) {
            port++;
            startServer(port);
        }   
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized static BasicReasonerHttpGUI get(int port) {
        if(singleton==null) {
            singleton = new BasicReasonerHttpGUI(port);
        }
        return singleton;
    }



    public void addReasoner(IReasoner reasoner){
        reasoners.add(reasoner);
    }





    class MyHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {                      
            String requestMethod = exchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {
                Headers responseHeaders = exchange.getResponseHeaders();
                responseHeaders.set("Content-Type", "text/plain");
                exchange.sendResponseHeaders(200, 0);
                OutputStream responseBody = exchange.getResponseBody();
                responseBody.write(handleFacts().getBytes());
                responseBody.close();

            }
        }
    }



    public int getPort() {
        return this.port;
    }

    public String handleFacts() {
        String s = "";
        ArrayList<String> others = new ArrayList<String>();

        beliefs.clear();
        for(IReasoner r:reasoners){
            Iterator<?> it = r.getBeliefs();
            while(it.hasNext()){
                beliefs.add(it.next().toString());
            }
        }

        Collections.sort(beliefs.subList(1, beliefs.size()));


        for(String bel:beliefs){
            others.add(bel);


        }


        for(String st:others){
            s = s + st+ "\n";
        }


        return s;
    }






}