package naming;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class NamingService {
    private Map<String, ServiceInfo> services;

    public NamingService() {
        this.services = new HashMap<>();
    }

    public synchronized void registerService(String serviceName, String url, int port) {
        services.put(serviceName, new ServiceInfo(url, port));
    }

    public synchronized ServiceInfo lookupService(String serviceName) {
        return services.get(serviceName);
    }

    public static void main(String[] args) {
        NamingService namingService = new NamingService();
        try (ServerSocket serverSocket = new ServerSocket(8085)) {
            System.out.println("Serviço de Nomes iniciado na porta 8085...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket, namingService)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket, NamingService namingService) {
        // Implemente aqui a lógica para lidar com as solicitações dos clientes
        // por exemplo, registrar ou procurar serviços
    }
}
