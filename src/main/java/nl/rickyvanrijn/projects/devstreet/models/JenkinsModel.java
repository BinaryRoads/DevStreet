package nl.rickyvanrijn.projects.devstreet.models;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import nl.rickyvanrijn.projects.devstreet.service.jenkins.JenkinsService;

import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class JenkinsModel implements ModelInterface {
    private MainGui mainGui;
    private String serviceName;
    private String logoFileName;

    private ServiceCredentialsModel serviceCredentials;

    private Point locationWorkspace;
    private JenkinsService jenkinsService;

    public JenkinsModel(String serviceName, String logoFileName){
        this.logoFileName = logoFileName;
        this.serviceName = serviceName;
    }

    @Override
    public void setServiceCredentials(String hostUrl, String username, String password){
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
    public void setParent(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    @Override
    public MainGui getParent() {
        return mainGui;
    }

    public String getServiceName(){
        return serviceName;
    }

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public Point getLocationWorkspace() {
        return locationWorkspace;
    }

    public void setLocationWorkspace(Point locationWorkspace) {
        this.locationWorkspace = locationWorkspace;
    }

    public JenkinsService getJenkinsService() {
        return jenkinsService;
    }

    public void setJenkinsService(JenkinsService jenkinsService) {
        if(serviceCredentials.hasCredentials()) {
            this.jenkinsService = new JenkinsService(serviceCredentials);
        }
    }

}
