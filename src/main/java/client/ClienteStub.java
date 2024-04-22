package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteStub {
    private String nomeServico;
    private String enderecoSNOME;
    private int portaSNOME;

    public ClienteStub(String nomeServico, String enderecoSNOME, int portaSNOME) {
        this.nomeServico = nomeServico;
        this.enderecoSNOME = enderecoSNOME;
        this.portaSNOME = portaSNOME;
    }

    public double calcular(double num1, double num2, char operacao) {
        try {
            Socket socketSNOME = new Socket(enderecoSNOME, portaSNOME);
            PrintStream saidaSNOME = new PrintStream(socketSNOME.getOutputStream());
            BufferedReader entradaSNOME = new BufferedReader(new InputStreamReader(socketSNOME.getInputStream()));

            saidaSNOME.println("OBT SERVICO " + nomeServico);
            String respostaSNOME = entradaSNOME.readLine();
            System.out.println("Resposta do SNOME: " + respostaSNOME);
            if (respostaSNOME != null && !respostaSNOME.equals("Serviço não encontrado")) {
                String[] partes = respostaSNOME.split(" ");
                String enderecoServidor = partes[0];
                System.out.println("Partes[1]: " + partes[1]);
                int portaServidor = Integer.parseInt(partes[1]);

                Socket socketServidor = new Socket(enderecoServidor, portaServidor);
                PrintStream saidaServidor = new PrintStream(socketServidor.getOutputStream());
                BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socketServidor.getInputStream()));

                saidaServidor.println(num1 + " " + operacao + " " + num2);
                double resultado = Double.parseDouble(entradaServidor.readLine());

                saidaSNOME.close();
                entradaSNOME.close();
                socketSNOME.close();

                saidaServidor.close();
                entradaServidor.close();
                socketServidor.close();

                return resultado;
            } else {
                System.out.println("Serviço não encontrado");
            }

            socketSNOME.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Double.NaN;
    }
}
