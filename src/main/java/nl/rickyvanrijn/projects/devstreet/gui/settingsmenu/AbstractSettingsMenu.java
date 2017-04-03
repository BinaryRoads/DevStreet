package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
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
    private JFrame abstractSettingsFrame;
    private String panelBorderTitle = "Settings";

    private ModelInterface modelInterface;

    protected Component nextLine = Box.createRigidArea(new Dimension(0, 10));

    public AbstractSettingsMenu(ModelInterface modelInterface) {
        this.modelInterface = modelInterface;
        abstractSettingsFrame = new JFrame(panelBorderTitle);
        abstractSettingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        abstractSettingsFrame.setResizable(false);

        try {
            abstractSettingsFrame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("icons/" + modelInterface.getLogoFileName())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        abstractSettingsFrame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                abstractSettingsFrame.dispose();
            }
        });
        abstractSettingsFrame.setLayout(new BoxLayout(abstractSettingsFrame.getContentPane(), BoxLayout.Y_AXIS));
        abstractSettingsFrame.setPreferredSize(new Dimension(750, 500));
        addJPanel();
        abstractSettingsFrame.pack();

        JFrameUtils.centerAlignJFrame(abstractSettingsFrame);
    }

    protected void setPanelBorderTitle(String newPanelBorderTitle){
        panelBorderTitle = newPanelBorderTitle;
        controls.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        abstractSettingsFrame.setTitle(newPanelBorderTitle);
    }

    public void show(){ abstractSettingsFrame.setVisible(true); }

    private void addJPanel() {
        abstractSettingsFrame.add(Box.createRigidArea(new Dimension(0, 10)));

        controls = new JPanel();
        controls.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        abstractSettingsFrame.add(controls);
    }

    protected void addComponents(Component[] componentList){
        for(Component component: componentList){
            controls.add(component);
        }
        abstractSettingsFrame.pack();
    }
}
