package nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins.JenkinsServiceJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rri21401 on 15/05/2017.
 */
public class JenkinsServicePanelListener implements ActionListener {

    JenkinsServiceJPanel jenkinsServiceJPanel;

    public JenkinsServicePanelListener(JenkinsServiceJPanel jenkinsServiceJPanel){
        this.jenkinsServiceJPanel = jenkinsServiceJPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().equals(JComboBox.class)){
            JComboBox comboBox = (JComboBox) e.getSource();

            if(comboBox == jenkinsServiceJPanel.getViewList()){
                jenkinsServiceJPanel.setSelectedViewName(comboBox.getSelectedItem().toString());
            }
            if(comboBox == jenkinsServiceJPanel.getJobsList()){
                jenkinsServiceJPanel.setSelectedJobName(comboBox.getSelectedItem().toString());
            }
        }

        if(e.getSource().getClass().equals(JButton.class)){
            JButton button = (JButton) e.getSource();
            jenkinsServiceJPanel.runService();
        }
    }
}
