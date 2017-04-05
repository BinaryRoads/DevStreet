package nl.rickyvanrijn.projects.devstreet.gui.main.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.JenkinsSettingsForm;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.SshSettingsForm;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class ControlPanelMouseListener implements MouseListener {
    private Workspace workspace;

    public ControlPanelMouseListener(Workspace workspace){
        this.workspace = workspace;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel labelInitiator = (JLabel) e.getSource();
        System.out.println(labelInitiator.getToolTipText());

        if(labelInitiator.getToolTipText().equalsIgnoreCase("jenkins")){
            new JenkinsSettingsForm("jenkins.png", workspace).show();

        }
        if(labelInitiator.getToolTipText().equalsIgnoreCase("ssh")){
            new SshSettingsForm("ssh.png", workspace).show();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
