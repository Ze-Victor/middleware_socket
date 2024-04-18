package naming;

public class ServiceInfo {
    private String url;
    private int port;

    public ServiceInfo(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }
}