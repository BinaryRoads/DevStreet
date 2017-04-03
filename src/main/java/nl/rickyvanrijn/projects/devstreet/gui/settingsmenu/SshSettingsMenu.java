package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.models.SshModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class SshSettingsMenu extends AbstractSettingsMenu {
    public SshSettingsMenu(SshModel sshProxyModel){
        super(sshProxyModel);
        setPanelBorderTitle("SSH Settings");

        JTextField textField = new JTextField(30);
        JLabel jenkinsHostName = new JLabel("SSH Address: ");

        addComponents(new Component[]{jenkinsHostName,textField, jenkinsHostName, textField});
    }
}
