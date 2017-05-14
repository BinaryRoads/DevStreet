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
public class SshForm extends AbstractForm {
    private JTextField hostNameTextField, hostPortTextField, sshUsername;
    private JPasswordField sshPassField;
    private JButton createSshProxyObjectButton;

    public SshForm(String logoFileName, Workspace workspace){
        super(logoFileName, workspace);
        setPanelBorderTitle("SSH Settings");

        hostNameTextField = new JTextField(30);
        hostNameTextField.setName("URL*");
        JLabel sshHostName = new JLabel("SSH Address: ");

        hostPortTextField = new JTextField(30);
        hostPortTextField.setName("Port*");
        JLabel sshHostPort = new JLabel("SSH Port: ");

        sshUsername = new JTextField(30);
        sshUsername.setName("Username*");
        JLabel sshUsernameLabel = new JLabel("Username:");

        sshPassField = new JPasswordField(30);
        sshPassField.setName("Password");
        JLabel sshPassLabel = new JLabel("Password:");

        createSshProxyObjectButton = new JButton("Create");
        addJButtonActionListener(createSshProxyObjectButton);

        addComponents(new Component[]{
                sshHostName, hostNameTextField,
                sshHostPort, hostPortTextField,
                sshUsernameLabel, sshUsername,
                sshPassLabel, sshPassField,
                createSshProxyObjectButton
        });
    }

    @Override
    public void loadServiceSpecificComponentPanel() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public ModelInterface createModel(ServiceCredentialsModel serviceCredentialsModel) {
        SshModel sshModel = new SshModel("SSH","ssh.png");
        sshModel.setServiceCredentials(serviceCredentialsModel);
        return sshModel;
    }
}
