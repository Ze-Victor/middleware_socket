package client;

public class Cliente {
    public static void main(String[] args) {
        ClienteStub stub = new ClienteStub("calculadora", "localhost", 5000);
        double resultado = stub.calcular(10, 5, '+');
        System.out.println("Resultado: " + resultado);
    }
}
