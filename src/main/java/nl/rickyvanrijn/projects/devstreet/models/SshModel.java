package nl.rickyvanrijn.projects.devstreet.models;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import nl.rickyvanrijn.projects.devstreet.service.IService;

import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class SshModel implements ModelInterface {
    private String serviceName;
    private String logoFileName;

    private ServiceCredentialsModel serviceCredentials;

    private Point locationWorkspace;
    private MainGui mainGui;

    public SshModel(String serviceName, String logoFileName){
        this.serviceName = serviceName;
        this.logoFileName = logoFileName;
    }

    @Override
    public void setParent(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    @Override
    public MainGui getParent() {
        return mainGui;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String getLogoFileName() {
        return logoFileName;
    }

    @Override
    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    @Override
    public Point getLocationWorkspace() {
        return locationWorkspace;
    }

    @Override
    public void setLocationWorkspace(Point locationWorkspace) {
        this.locationWorkspace = locationWorkspace;
    }

    @Override
    public void setServiceCredentials(String hostUrl, String username, String password) {
        serviceCredentials = new ServiceCredentialsModel();
        serviceCredentials.setHostname(hostUrl);
        serviceCredentials.setUsername(username);
        serviceCredentials.setPassword(password);
    }

    @Override
    public void setServiceCredentials(ServiceCredentialsModel serviceCredentials) {
        this.serviceCredentials = serviceCredentials;
    }

    @Override
    public ServiceCredentialsModel getServiceCredentials() {
        return serviceCredentials;
    }

    @Override
    public IService getService() {
        return null;
    }

    @Override
    public void setService(IService iService) {

    }
}
