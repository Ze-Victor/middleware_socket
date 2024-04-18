package client;

import java.net.Socket;

import naming.*;

public class MiddlewareStub {
    private NamingService namingService;

    public MiddlewareStub() {
        this.namingService = new NamingService();
    }

    public Socket connect(String serviceName) {
        ServiceInfo serviceInfo = namingService.lookupService(serviceName);
        if (serviceInfo != null) {
            try {
                return new Socket(serviceInfo.getUrl(), serviceInfo.getPort());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
