package nl.rickyvanrijn.projects.devstreet.gui.main.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.JenkinsSettingsForm;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.SshSettingsForm;
import nl.rickyvanrijn.projects.devstreet.service.workspace.WorkspaceService;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by rri21401 on 5-4-2017.
 */
public class WorkspaceMouseListener implements MouseListener {

    private WorkspaceService workspaceService;

    public WorkspaceMouseListener(WorkspaceService workspaceService){
        this.workspaceService = workspaceService;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel labelInitiator = (JLabel) e.getSource();

        if (labelInitiator.getToolTipText().equalsIgnoreCase("jenkins")) {
            JenkinsSettingsForm jenkinsSettingsMenu = new JenkinsSettingsForm("jenkins.png", workspaceService.getWorkspace());
            jenkinsSettingsMenu.loadModel(workspaceService.findServiceModel(labelInitiator.getToolTipText().toLowerCase()));
            jenkinsSettingsMenu.show();
        }
        if (labelInitiator.getToolTipText().equalsIgnoreCase("ssh")) {
            SshSettingsForm sshSettingsForm = new SshSettingsForm("ssh.png", workspaceService.getWorkspace());
            sshSettingsForm.loadModel(workspaceService.findServiceModel(labelInitiator.getToolTipText().toLowerCase()));
            sshSettingsForm.show();
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
