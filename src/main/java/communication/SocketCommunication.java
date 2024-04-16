package communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCommunication implements Communication {
    private String host;
    private int port;

    public SocketCommunication(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public String send(String message) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(message);
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
