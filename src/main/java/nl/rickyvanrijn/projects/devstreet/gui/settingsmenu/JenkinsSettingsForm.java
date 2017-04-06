package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.models.JenkinsModel;
import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.models.ServiceCredentialsModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JenkinsSettingsForm extends AbstractSettingsForm {

    private JTextField jenkinsHostNameField, jenkinsHostPortField, jenkinsUsername;
    private JPasswordField jenkinsPassField;
    private JButton createJenkinsProxyObjectButton;

    public JenkinsSettingsForm(String logoFileName, Workspace workspace){
        super(logoFileName, workspace);
        setPanelBorderTitle("Jenkins");

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

        addComponents(new Component[]{jenkinsHostName,jenkinsHostName, jenkinsHostName, jenkinsHostNameField,
                jenkinsHostPort,jenkinsHostPortField,
                jenkinsUsernameLabel, jenkinsUsername,
                jenkinsPassLabel, jenkinsPassField, createJenkinsProxyObjectButton});

    }

    @Override
    public ModelInterface createModel(ServiceCredentialsModel serviceCredentialsModel) {
        JenkinsModel jenkinsModel = new JenkinsModel("Jenkins","jenkins.png");
        jenkinsModel.setServiceCredentials(serviceCredentialsModel);
        return jenkinsModel;
    }

    @Override
    public void loadModel(ModelInterface serviceModel) {
        jenkinsHostNameField.setText(serviceModel.getServiceCredentials().getHostname());
        jenkinsUsername.setText(serviceModel.getServiceCredentials().getUsername());
        jenkinsPassField.setText(serviceModel.getServiceCredentials().getPassword());
        jenkinsHostPortField.setText(serviceModel.getServiceCredentials().getPort());
        createJenkinsProxyObjectButton.setText("Save");
    }
}
