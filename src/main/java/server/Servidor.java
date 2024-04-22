package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
	/*
    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Servidor iniciado na porta 8000");

            registrarServico("calculadora", "localhost", 8000);

            ServicoAplicacaoInfo res = ServicoNomes.obterServico("calculadora");
            System.out.println(res);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServidorHandler(socket)).start();
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

    private static void registrarServico(String nome, String url, int porta) {
        ServicoNomes.registrarServico(nome, url, porta);
    }

}

class ServidorHandler implements Runnable {
    private Socket socket;

    public ServidorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream saida = new PrintStream(socket.getOutputStream());

            String expressao = entrada.readLine();
            double resultado = calcular(expressao);
            saida.println(resultado);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double calcular(String expressao) {
        String[] partes = expressao.split(" ");
        double num1 = Double.parseDouble(partes[0]);
        char operacao = partes[1].charAt(0);
        double num2 = Double.parseDouble(partes[2]);

        switch (operacao) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN;
                }
            default:
                return Double.NaN;
        }
    }
    */
}
