package naming;

import java.util.HashMap;
import java.util.Map;

public class NamingService {
    private Map<String, String> services;

    public NamingService() {
        this.services = new HashMap<>();
    }

    public void registerService(String serviceName, String serviceAddress) {
        services.put(serviceName, serviceAddress);
    }

    public String lookupService(String serviceName) {
        return services.getOrDefault(serviceName, "Serviço não encontrado");
    }
}
