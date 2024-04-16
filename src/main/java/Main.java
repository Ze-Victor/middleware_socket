import communication.Communication;
import communication.SocketCommunication;
import middleware.MiddlewareStub;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância do stub do middleware
        Communication communication = new SocketCommunication("localhost", 8081);
        MiddlewareStub stub = new MiddlewareStub(communication);

        // Chamando o serviço por meio do stub
        String response = stub.invoke("exampleService", "Mensagem para o serviço");
        System.out.println("Resposta do serviço: " + response);
    }
}
