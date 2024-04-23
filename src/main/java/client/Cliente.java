package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import middleware.application.Middleware;

public class Cliente {
	/*
	 * Cliente so inicia o a Classe Middleware e usar o método conectar com dois parametros, o nome do servidor e a mensagem, tudo String
	 */
    public static void main(String[] args) throws UnknownHostException, IOException {
    	Middleware stub = new Middleware();
    	
    	Scanner sc  = new Scanner(System.in);
    	boolean entrada = true;
    	while(entrada) {
    		System.out.print("Digite o servico e sua mensagem: ");
    		String[] input = sc.nextLine().split(" "); 
    		String servicename = input[0];
    		if(servicename.equals("fim")) {
    			entrada = false;
    		} else {
    			int cont = 2;
        		String mensage = input[1];
        		while(cont < input.length) {
        			mensage += ";" + input[cont];
        			cont++;
        		}
        		System.out.println("Resposta: " + stub.conectar(servicename, mensage));
    		}
    	}
    	System.out.println("Cliente finalizado");
    }
}
