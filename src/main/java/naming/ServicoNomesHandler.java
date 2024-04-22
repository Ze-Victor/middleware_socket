package naming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServicoNomesHandler implements Runnable {
    private Socket socket;

    public ServicoNomesHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream saida = new PrintStream(socket.getOutputStream());

            String comando = reader.readLine();
            String[] partes = comando.split(" ");

            if (partes.length < 2) {
                saida.println("Comando inválido");
                socket.close();
                return;
            }

            if (partes[0].equals("REGISTRAR")) {

                String nomeServico = partes[1];

                String url = partes[2];
                int porta = Integer.parseInt(partes[3]);
                ServicoNomes.registrarServico(nomeServico, url, porta);
                saida.println("Serviço registrado com sucesso!");
            } else if (partes[0].equals("OBT") && partes[1].equals("SERVICO")) {

                String nomeServico = partes[2];

                System.out.println();
                ServicoAplicacaoInfo info = ServicoNomes.obterServico(nomeServico);
                if (info != null) {
                    saida.println(info.getUrl() + " " + info.getPorta());
                } else {
                    System.out.println("AQUI1");
                    saida.println("Serviço não encontrado");
                }
            } else {
                saida.println("Comando inválido");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
