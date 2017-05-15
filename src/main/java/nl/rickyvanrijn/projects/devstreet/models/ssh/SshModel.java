package nl.rickyvanrijn.projects.devstreet.models.ssh;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import nl.rickyvanrijn.projects.devstreet.gui.forms.AbstractForm;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.service.IService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class SshModel implements IModel {
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

    @Override
    public void setForm(AbstractForm abstractForm) {

    }

    @Override
    public AbstractForm getForm() {
        return null;
    }

    @Override
    public void setServiceJPanel(JPanel serviceJPanel) {

    }

    @Override
    public JPanel getServiceJPanel() {
        return new JPanel(new GridBagLayout());
    }
}
