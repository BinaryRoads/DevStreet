package nl.rickyvanrijn.projects.devstreet.models;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import nl.rickyvanrijn.projects.devstreet.gui.forms.AbstractForm;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.service.IService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public interface IModel {
    public String getServiceName();
    public void setServiceName(String serviceName);
    public String getLogoFileName();
    public void setLogoFileName(String logoFileName);
    public Point getLocationWorkspace();
    public void setLocationWorkspace(Point locationWorkspace);
    public void setServiceCredentials(String hostUrl, String username, String password);
    public void setServiceCredentials(ServiceCredentialsModel serviceCredentials);
    public ServiceCredentialsModel getServiceCredentials();
    public IService getService();
    public void setService(IService iService);
    public void setForm(AbstractForm abstractForm);
    public AbstractForm getForm();
    public JPanel getServiceJPanel();
}
