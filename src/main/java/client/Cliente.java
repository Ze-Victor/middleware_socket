package client;

import java.io.IOException;
import java.net.UnknownHostException;

import middleware.application.Middleware;

public class Cliente {
	
    public static void main(String[] args) {
    	Middleware stub = new Middleware();
    	
    	try {
			System.out.println(stub.conectar("Teste", "teste"));
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
