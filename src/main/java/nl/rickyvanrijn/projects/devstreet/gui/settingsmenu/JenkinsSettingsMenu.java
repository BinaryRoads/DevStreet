package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners.MenuListener;
import nl.rickyvanrijn.projects.devstreet.models.JenkinsModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JenkinsSettingsMenu extends AbstractSettingsMenu{

    public JenkinsSettingsMenu(JenkinsModel jenkinsProxyModel){
        super(jenkinsProxyModel);
        setPanelBorderTitle("Jenkins Settings");

        JTextField jenkinsHostNameField = new JTextField(30);
        jenkinsHostNameField.setName("URL");
        JLabel jenkinsHostName = new JLabel("Jenkins URL: ");

        JTextField jenkinsUsername = new JTextField(30);
        jenkinsUsername.setName("Username");
        JLabel jenkinsUsernameLabel = new JLabel("Username:");

        JPasswordField jenkinsPassField = new JPasswordField(30);
        jenkinsPassField.setName("Password");
        JLabel jenkinsPassLabel = new JLabel("Password:");

        JButton createJenkinsProxyObjectButton = new JButton("Create");
        addJButtonActionListener(createJenkinsProxyObjectButton);

        addComponents(new Component[]{jenkinsHostName,jenkinsHostName, jenkinsHostName, jenkinsHostNameField,
                jenkinsUsernameLabel, jenkinsUsername,
                jenkinsPassLabel, jenkinsPassField, createJenkinsProxyObjectButton});

    }

}
