package sai.util;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class SaiHttpServer{ 

    public static int SAI_HTTP_SERVER_PORT = 3275; 
    
    private static SaiHttpServer instance = null;
    private HttpServer server;
    
    
    private SaiHttpServer(){
        startServer();
    }
    
    private void startServer() {
        try{
            server = HttpServer.create(new InetSocketAddress(SAI_HTTP_SERVER_PORT), 0);
            server.setExecutor(null); // creates a default executor
            server.start();
        }       
        catch (BindException e) {
            SAI_HTTP_SERVER_PORT++;
            startServer();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static SaiHttpServer getInstance(){
        if(instance==null){
            instance = new SaiHttpServer();
        }
        return instance;
    }

    public HttpServer getServer() {
        return server;
    }

}