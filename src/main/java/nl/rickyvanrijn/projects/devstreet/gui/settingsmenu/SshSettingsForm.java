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
    JTextField textField;

    public SshSettingsForm(String logoFileName, Workspace workspace){
        super(logoFileName, workspace);
        setPanelBorderTitle("SSH Settings");

        textField = new JTextField(30);
        JLabel jenkinsHostName = new JLabel("SSH Address: ");

        addComponents(new Component[]{jenkinsHostName,textField, jenkinsHostName, textField});
    }

    @Override
    public ModelInterface createModel(ServiceCredentialsModel serviceCredentialsModel) {
        SshModel sshModel = new SshModel("SSH","ssh.png");
        sshModel.setServiceCredentials(serviceCredentialsModel.getHostname(), serviceCredentialsModel.getUsername(), serviceCredentialsModel.getPassword());
        return sshModel;
    }

    @Override
    public void loadModel(ModelInterface serviceModel) {
        textField.setText(serviceModel.getServiceCredentials().getHostname());
    }
}
