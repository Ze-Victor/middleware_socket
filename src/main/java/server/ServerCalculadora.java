package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import middleware.application.Middleware;


public class ServerCalculadora {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Middleware stub = new Middleware();
		stub.adicionarService("calculadora", "localhost", 8084);
		
		Calculadora cal = new Calculadora();
		
    	System.out.println("iniciando...");
    	ServerSocket serve = new ServerSocket(8084);
    	System.out.println("Servidor calculadora iniciado!");
    	
    	
    	String x[]; 
    	while(true) {
    		Socket socket = serve.accept();
        	System.out.println("Cliente connectado");
        	
        	InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        	BufferedReader reader = new BufferedReader(inputStream);
        	
        	PrintStream saida = new PrintStream(socket.getOutputStream());
    		x = reader.readLine().split(";");
    		String result;
    		switch (x[0]){
    			case "soma":
    				result = cal.soma(Integer.valueOf(x[1]) , Integer.valueOf(x[2]));
    				System.out.println("Soma: " + x[1] + " + " + x[2] + " resultado: " + result);
    				saida.println(result);
    				break;
    			case "sub":
    				result = cal.sub(Integer.valueOf(x[1]) , Integer.valueOf(x[2]));
    				System.out.println("Subtracao: " + x[1] + " - " + x[2] + " resultado: " + result);
    				saida.println(result);
    				break;
    			default:
    				System.out.println("Clente fez uma Operação invalida");
    				saida.println("Operação invalida");
    				break;
    				
    		}
    		
    		//saida.println("finalizando servidor");
    	}
	}

}
