package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.models.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.models.SshModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class SshSettingsForm extends AbstractSettingsForm {
    private JTextField hostNameTextField, hostPortTextField;
    private JButton createSshProxyObjectButton;

    public SshSettingsForm(String logoFileName, Workspace workspace){
        super(logoFileName, workspace);
        setPanelBorderTitle("SSH Settings");

        hostNameTextField = new JTextField(30);
        hostNameTextField.setName("URL*");
        JLabel jenkinsHostName = new JLabel("SSH Address: ");

        hostPortTextField = new JTextField(30);
        hostPortTextField.setName("Port*");
        JLabel jenkinsHostPort = new JLabel("SSH Port: ");

        createSshProxyObjectButton = new JButton("Create");
        addJButtonActionListener(createSshProxyObjectButton);

        addComponents(new Component[]{jenkinsHostName, hostNameTextField, jenkinsHostName, hostNameTextField, jenkinsHostPort, hostPortTextField, createSshProxyObjectButton});
    }

    @Override
    public ModelInterface createModel(ServiceCredentialsModel serviceCredentialsModel) {
        SshModel sshModel = new SshModel("SSH","ssh.png");
        sshModel.setServiceCredentials(serviceCredentialsModel);
        return sshModel;
    }

    @Override
    public void loadModel(ModelInterface serviceModel) {
        hostNameTextField.setText(serviceModel.getServiceCredentials().getHostname());
        hostPortTextField.setText(serviceModel.getServiceCredentials().getPort());
        createSshProxyObjectButton.setText("Save");
    }
}
