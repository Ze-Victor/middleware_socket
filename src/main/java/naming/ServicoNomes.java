package naming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServicoNomes {
    private static final int PORTA_SNOME = 5000;
    private static Map<String, ServicoAplicacaoInfo> servicosRegistrados = new HashMap<>();

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORTA_SNOME);
            System.out.println("Serviço de Nomes iniciado na porta " + PORTA_SNOME);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServicoNomesHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void registrarServico(String nome, String url, int porta) {
        servicosRegistrados.put(nome, new ServicoAplicacaoInfo(url, porta));
        System.out.println("Serviço '" + nome + "' registrado com sucesso!");
    }

    public static synchronized ServicoAplicacaoInfo obterServico(String nome) {
        ServicoAplicacaoInfo res = servicosRegistrados.get(nome);
        System.out.println(res);
        return res;
    }
}
