package nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins;

import nl.rickyvanrijn.projects.devstreet.gui.forms.AbstractForm;
import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.models.jenkins.JenkinsModel;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.service.jenkins.JenkinsService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JenkinsForm extends AbstractForm {

    private ArrayList<Component> componentList;
    private JTextField jenkinsHostNameField, jenkinsHostPortField, jenkinsUsername;
    private JPasswordField jenkinsPassField;
    private JButton createJenkinsProxyObjectButton, testJenkinsServiceButton;

    public JenkinsForm(String logoFileName, Workspace workspace){
        super(logoFileName, workspace);
        setPanelBorderTitle("Jenkins");

        componentList = new ArrayList<>();

        jenkinsHostNameField = new JTextField(30);
        jenkinsHostNameField.setName("URL*");
        JLabel jenkinsHostName = new JLabel("Jenkins URL: ");

        jenkinsHostPortField = new JTextField(30);
        jenkinsHostPortField.setName("Port*");
        JLabel jenkinsHostPort = new JLabel("Jenkins port: ");

        jenkinsUsername = new JTextField(30);
        jenkinsUsername.setName("Username*");
        JLabel jenkinsUsernameLabel = new JLabel("Username:");

        jenkinsPassField = new JPasswordField(30);
        jenkinsPassField.setName("Password");
        JLabel jenkinsPassLabel = new JLabel("Password:");

        createJenkinsProxyObjectButton = new JButton("Create");
        addJButtonActionListener(createJenkinsProxyObjectButton);

        testJenkinsServiceButton = new JButton("Ping Server");
        addJButtonActionListener(testJenkinsServiceButton);

        componentList.add(jenkinsHostName);
        componentList.add(jenkinsHostNameField);
        componentList.add(jenkinsHostPort);
        componentList.add(jenkinsHostPortField);
        componentList.add(jenkinsUsernameLabel);
        componentList.add(jenkinsUsername);
        componentList.add(jenkinsPassLabel);
        componentList.add(jenkinsPassField);
        componentList.add(createJenkinsProxyObjectButton);
        componentList.add(testJenkinsServiceButton);

        addComponents(componentList.toArray(new Component[]{}));
    }

    public void loadServiceSpecificComponentPanel()
    {
        IModel jenkinsModel = workspace.findModel("jenkins");
        if(jenkinsModel != null) {
            serviceComponentPanel = jenkinsModel.getServiceJPanel();

            if(componentList.contains(serviceComponentPanel)){
                componentList.remove(serviceComponentPanel);
            }

            componentList.add(serviceComponentPanel);
        }
    }

    public void refresh(){
        addComponents(componentList.toArray(new Component[]{}));
    }

    @Override
    public IModel createModel(ServiceCredentialsModel serviceCredentialsModel) {
        JenkinsModel jenkinsModel = new JenkinsModel("Jenkins","jenkins.png");
        jenkinsModel.setServiceCredentials(serviceCredentialsModel);
        jenkinsModel.setService(new JenkinsService(serviceCredentialsModel));
        return jenkinsModel;
    }

}
