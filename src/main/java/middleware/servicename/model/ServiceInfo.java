package middleware.servicename.model;

public class ServiceInfo {
    private String serviceName;
    private String url;
    private int port;

    public ServiceInfo(String serviceName,String url, int port) {
        this.serviceName = serviceName;
        this.url = url;
        this.port = port;
    }

    public String getServiceName(){
        return serviceName;
    }

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port){
        this.port = port;
    }

}