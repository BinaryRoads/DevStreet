package nl.rickyvanrijn.projects.devstreet.gui.forms.ssh;

import nl.rickyvanrijn.projects.devstreet.gui.forms.AbstractForm;
import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.models.ssh.SshModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class SshForm extends AbstractForm {

    private ArrayList<Component> componentList;
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

        componentList.add(sshHostName);
        componentList.add(hostNameTextField);
        componentList.add(sshHostPort);
        componentList.add(hostPortTextField);
        componentList.add(sshUsernameLabel);
        componentList.add(sshUsername);
        componentList.add(sshPassLabel);
        componentList.add(sshPassField);
        componentList.add(createSshProxyObjectButton);

        addComponents(componentList.toArray(new Component[]{}));
    }

    @Override
    public void loadServiceSpecificComponentPanel() {
        IModel sshModel = workspace.findModel("ssh");
        if(sshModel != null) {
            serviceComponentPanel = sshModel.getServiceJPanel();

            if(componentList.contains(serviceComponentPanel)){
                componentList.remove(serviceComponentPanel);
            }

            componentList.add(serviceComponentPanel);
        }
    }

    @Override
    public void refresh() {
        addComponents(componentList.toArray(new Component[]{}));
    }

    @Override
    public IModel createModel(ServiceCredentialsModel serviceCredentialsModel) {
        SshModel sshModel = new SshModel("SSH","ssh.png");
        sshModel.setServiceCredentials(serviceCredentialsModel);
        sshModel.setService(null);
        return sshModel;
    }
}
