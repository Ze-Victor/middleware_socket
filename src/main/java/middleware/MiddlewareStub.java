package middleware;

import communication.Communication;

public class MiddlewareStub {
    private Communication communication;

    public MiddlewareStub(Communication communication) {
        this.communication = communication;
    }

    public String invoke(String serviceName, String message) {
        // Antes de enviar a mensagem, obtenha o endereço do serviço do servidor de nomes
        String serviceAddress = lookupService(serviceName);
        
        // Envie a mensagem para o serviço
        return communication.send(serviceAddress + ":" + message);
    }

    private String lookupService(String serviceName) {
        // Lógica para consultar o servidor de nomes
        // Por simplicidade, retornaremos um endereço fixo
        return "localhost:8081";
    }
}
