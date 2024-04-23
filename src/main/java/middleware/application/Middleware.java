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
	
	/*
	 * Método para recuperar os dados do servidor, recebendo o nome do serviço.
	 * O método inicia uma conversa com o serviço de nomes, passando somente o nome do serviço a procura
	 */
	public String recuperarServerInfo(String nameService) throws UnknownHostException, IOException {
		Socket socket = new Socket(url_serverService,port_serverService);
		
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println("R"+ ";" + nameService);
		
		InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
    	BufferedReader reader = new BufferedReader(inputStream);
    	String output = reader.readLine();
    	
    	//System.out.println("Resposta do servidor de nomes: " + output);
    	
		return output;
	}
	
	/*
	 * Método para adicionar um serviço, recebe o nome, a url e a porta do servidor, se connecta com o serviço de nomes para ele cadastrar.
	 */
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
	
	/*
	 * Método para se connectar com um serviço, recebe o nome e uma mensagem e retorna a resposta do servidor.
	 */
	public String conectar(String nameService, String mensage) throws UnknownHostException, IOException {
		
		String[] serveInfo = recuperarServerInfo(nameService).split(";");
		
		if(serveInfo.length == 1) {
			return "Servico não encontrado";
		}
		
		Socket socket = new Socket(serveInfo[0], Integer.valueOf(serveInfo[1]));
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println(mensage);
		InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
    	BufferedReader reader = new BufferedReader(inputStream);
    	String output = reader.readLine();
    	//System.out.println("Resposta do servidor: " + output);
    	socket.close();
		return output;
	}

	
	
}
