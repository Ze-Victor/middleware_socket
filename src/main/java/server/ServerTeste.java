package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import middleware.application.Middleware;

public class ServerTeste {
	
	public static void main(String[] args) throws IOException {
		
		Middleware stub = new Middleware();
		stub.adicionarService("Teste", "localhost", 8083);
		
    	System.out.println("iniciando...");
    	ServerSocket serve = new ServerSocket(8083);
    	System.out.println("Servidor Teste iniciado!");
    	
    	
    	String x; 
    	while(true) {
    		Socket socket = serve.accept();
        	System.out.println("Cliente connectado");
        	
        	InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        	BufferedReader reader = new BufferedReader(inputStream);
        	
        	PrintStream saida = new PrintStream(socket.getOutputStream());
    		x = reader.readLine();
    	    
    		saida.println("Servidor Teste funcionado");
    	}
    	
	}
}
