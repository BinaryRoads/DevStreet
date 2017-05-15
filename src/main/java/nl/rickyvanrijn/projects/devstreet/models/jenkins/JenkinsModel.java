package nl.rickyvanrijn.projects.devstreet.models.jenkins;

import nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins.JenkinsServiceJPanel;
import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import nl.rickyvanrijn.projects.devstreet.gui.forms.AbstractForm;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.service.IService;
import nl.rickyvanrijn.projects.devstreet.service.jenkins.JenkinsService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class JenkinsModel implements IModel {
    private MainGui mainGui;
    private String serviceName;
    private String logoFileName;
    private Point locationWorkspace;

    private ServiceCredentialsModel serviceCredentials;
    private AbstractForm abstractForm;
    private JenkinsServiceJPanel jenkinsServiceJPanel;
    private JenkinsService jenkinsService;

    public JenkinsModel(String serviceName, String logoFileName){
        this.logoFileName = logoFileName;
        this.serviceName = serviceName;
        this.jenkinsServiceJPanel = new JenkinsServiceJPanel(this);
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

    public JenkinsService getService() {
        return jenkinsService;
    }

    public void setService(IService iService) {
        if(serviceCredentials.hasCredentials()) {
            this.jenkinsService = new JenkinsService(serviceCredentials);
        }
    }

    public void setForm(AbstractForm abstractForm){
        this.abstractForm = abstractForm;
    }

    public AbstractForm getForm(){
        return this.abstractForm;
    }

    @Override
    public JPanel getServiceJPanel() {
        return jenkinsServiceJPanel.getServiceComponentPanel();
    }

}
