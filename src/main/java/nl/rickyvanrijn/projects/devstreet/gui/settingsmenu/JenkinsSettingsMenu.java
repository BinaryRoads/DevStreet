package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JenkinsSettingsMenu extends AbstractSettingsMenu{

    public JenkinsSettingsMenu(){
        super();
        setLogoFileName("jenkins.png");
        setPanelBorderTitle("Jenkins Settings");

        JTextField textField = new JTextField(30);
        JLabel jenkinsHostName = new JLabel("Jenkins URL: ");

        addComponents(new Component[]{jenkinsHostName,textField, jenkinsHostName, textField});

        show();
    }

}
