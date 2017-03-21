package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JenkinsSettingsMenu {
    private JFrame jenkinsSettingsFrame;

    public JenkinsSettingsMenu(){
        jenkinsSettingsFrame = new JFrame("Jenkins Settings");
        jenkinsSettingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jenkinsSettingsFrame.setResizable(false);
        jenkinsSettingsFrame.setLayout(new BoxLayout(jenkinsSettingsFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        jenkinsSettingsFrame.setPreferredSize(new Dimension(750,500));
        addComponents();
        jenkinsSettingsFrame.pack();
        jenkinsSettingsFrame.setVisible(true);
        JFrameUtils.centerAlignJFrame(jenkinsSettingsFrame);
    }

    private void addComponents() {
        jenkinsSettingsFrame.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel controls = new JPanel();
//        controls.add(serviceList);
        controls.setBorder(BorderFactory.createTitledBorder(
                "Choose service layer"));
        jenkinsSettingsFrame.add(controls);

    }
}
