package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

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
        JLabel jenkinsHostName = new JLabel("Jenkins URL: ");

        JTextField jenkinsUsername = new JTextField(30);
        JLabel jenkinsUsernameLabel = new JLabel("Username:");

        JPasswordField jenkinsPassField = new JPasswordField(30);
        JLabel jenkinsPassLabel = new JLabel("Password:");

        addComponents(new Component[]{jenkinsHostName,jenkinsHostName, jenkinsHostName, jenkinsHostNameField,
                jenkinsUsernameLabel, jenkinsUsername,Box.createRigidArea(new Dimension(20, 10)),
                jenkinsPassLabel, jenkinsPassField});

    }

}
