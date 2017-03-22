package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JenkinsSettingsMenu {
    private JFrame jenkinsSettingsFrame;

    public JenkinsSettingsMenu(){
        jenkinsSettingsFrame = new JFrame("Jenkins Settings");
        jenkinsSettingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jenkinsSettingsFrame.setResizable(false);
        jenkinsSettingsFrame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                jenkinsSettingsFrame.dispose();
            }
        });
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
                "Jenkins Settings"));
        jenkinsSettingsFrame.add(controls);

    }
}
