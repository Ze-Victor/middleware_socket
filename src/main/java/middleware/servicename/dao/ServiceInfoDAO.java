package middleware.servicename.dao;

import middleware.servicename.model.ServiceInfo;
import java.util.ArrayList;

/*
 * Classe para armazenar informações do serves e ser acessada pelo Middleware
 */
public class ServiceInfoDAO {
    private ArrayList<ServiceInfo> servers;
    private static ServiceInfoDAO bdServiceInfoDAO;

    public ServiceInfoDAO(){
        servers = new ArrayList<>();
    }

    public static ServiceInfoDAO getIstance(){
        if (bdServiceInfoDAO == null) {
            bdServiceInfoDAO = new ServiceInfoDAO();
        }
        return bdServiceInfoDAO;
    }

    public void addService(ServiceInfo serve){
        servers.add(serve);
    }
    
    public void removeService(ServiceInfo serve){
        servers.remove(serve);
    }

    public String getServiceInfo(String serviceName){
        String output = "";
        for (ServiceInfo serviceInfo : servers) {
            if (serviceInfo.getServiceName().equals(serviceName)) {
                output = serviceInfo.getUrl() +";"+ String.valueOf(serviceInfo.getPort()); 
            }
        } 
        return output;
    }
}
 