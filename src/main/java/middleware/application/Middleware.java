package middleware.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Middleware {
	
	private String url_serverService = "localhost";
	private int port_serverService = 8082;
	
	public String recuperarServerInfo(String nameService) throws UnknownHostException, IOException {
		Socket socket = new Socket(url_serverService,port_serverService);
		
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println("R"+ ";" + nameService);
		
		InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
    	BufferedReader reader = new BufferedReader(inputStream);
    	String output = reader.readLine();
    	
    	System.out.println("Resposta do servidor de nomes: " + output);
    	
		return output;
	}
	
	public String adicionarService(String nameService, String url, int port) throws UnknownHostException, IOException {
		
		Socket socket = new Socket(url_serverService,port_serverService);
		
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println("C"+ ";" + nameService+ ";" + url + ";" + String.valueOf(port));
		
		

    	InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
    	BufferedReader reader = new BufferedReader(inputStream);
    	String output = reader.readLine();
    	
    	System.out.println("Resposta do servidor de nomes: " + output);
    	socket.close();
		return output;
	}
	
	public String conectar(String nameService, String mensage) throws UnknownHostException, IOException {
		
		String[] serveInfo = recuperarServerInfo(nameService).split(";");
		
		if(serveInfo.length == 1) {
			return "Servico não encontrado";
		}
		
		System.out.println("1");
		Socket socket = new Socket(serveInfo[0], Integer.valueOf(serveInfo[1]));
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println(mensage);
		InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
    	BufferedReader reader = new BufferedReader(inputStream);
    	String output = reader.readLine();
    	System.out.println("Resposta do servidor: " + output);
    	socket.close();
		return output;
	}

	
	
}
