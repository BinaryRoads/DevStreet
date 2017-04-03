package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;

/**
 * Created by rri21401 on 22-3-2017.
 */
public abstract class AbstractSettingsMenu {
    private JPanel controls;
    private JFrame jenkinsSettingsFrame;
    private String panelBorderTitle = "Settings";
    private String logoFileName = "Control_Panel.png";

    protected Component nextLine = Box.createRigidArea(new Dimension(0, 10));

    public AbstractSettingsMenu(){
        jenkinsSettingsFrame = new JFrame("Jenkins Settings");
        jenkinsSettingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jenkinsSettingsFrame.setResizable(false);

        try {
            jenkinsSettingsFrame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("icons/"+logoFileName) ));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        addJPanel();
        jenkinsSettingsFrame.pack();

        JFrameUtils.centerAlignJFrame(jenkinsSettingsFrame);
    }

    protected void setLogoFileName(String logoFileName){
        this.logoFileName = logoFileName;
        try {
            jenkinsSettingsFrame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("icons/"+logoFileName) ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setPanelBorderTitle(String newPanelBorderTitle){
        panelBorderTitle = newPanelBorderTitle;
        controls.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
    }

    protected void show(){ jenkinsSettingsFrame.setVisible(true); }

    private void addJPanel() {
        jenkinsSettingsFrame.add(Box.createRigidArea(new Dimension(0, 10)));

        controls = new JPanel();
//        controls.add(serviceList);
        controls.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        jenkinsSettingsFrame.add(controls);
    }

    protected void addComponents(Component[] componentList){
        for(Component component: componentList){
            controls.add(component);
        }
        jenkinsSettingsFrame.pack();
    }
}
