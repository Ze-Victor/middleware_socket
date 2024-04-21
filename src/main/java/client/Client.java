package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        MiddlewareStub stub = new MiddlewareStub();
        Socket socket = stub.connect("exampleService");
        if (socket != null) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.println("Hello from client");
                String response = in.readLine();
                System.out.println("Server response: " + response);

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Não foi possível conectar ao serviço.");
        }
    }
}
