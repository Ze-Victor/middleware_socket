package middleware.servicename;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import middleware.servicename.model.ServiceInfo;
import middleware.servicename.dao.ServiceInfoDAO;

public class NamingService {
	
    public static void main(String[] args) throws IOException {
    	System.out.println("iniciando...");
    	ServerSocket serve = new ServerSocket(8082);
    	System.out.println("Servidor de nomes iniciado!");
    	
    	
    	String x[]; 
    	while(true) {
    		Socket socket = serve.accept();
        	System.out.println("Cliente connectado");
        	ServiceInfoDAO bdservers = ServiceInfoDAO.getIstance();
        	
        	InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        	BufferedReader reader = new BufferedReader(inputStream);
        	
        	PrintStream saida = new PrintStream(socket.getOutputStream());
    		x = reader.readLine().split(";");
    	      switch (x[0]) {
              case "R":
            	  System.out.println("Recuperando Servico: " + x[1]);
            	  
            	  String output = bdservers.getServiceInfo(x[1]);
            	 
            	  saida.println(output);
                  break;
                  
              case "C":
            	  System.out.println("Cadastrando Servico: " + x[1]);
            	  ServiceInfo si = new ServiceInfo(x[1],x[2], Integer.valueOf(x[3]));
            	  bdservers.addService(si);
            	  saida.println("Servico adicionado com sucesso!");
                  break;

              default: 
                  System.out.println("Entrada invalida");
                  saida.println("");
                  break;
    	      }
    	}
    	
    }

    
}

