import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        final int PORT = 8081;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor de teste iniciado na porta " + PORT + "...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message = in.readLine();
            System.out.println("Mensagem recebida: " + message);

            // Simulação de processamento
            Thread.sleep(1000);

            // Enviar resposta
            out.println("Resposta do servidor: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
