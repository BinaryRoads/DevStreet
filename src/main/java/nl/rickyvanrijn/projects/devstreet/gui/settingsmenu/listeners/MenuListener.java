package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractSettingsMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class MenuListener implements WindowFocusListener, ActionListener {

    private AbstractSettingsMenu abstractSettingsMenu;

    public MenuListener(AbstractSettingsMenu abstractSettingsMenu){
        this.abstractSettingsMenu = abstractSettingsMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().equals(JButton.class)){
            for(Component component : abstractSettingsMenu.getFormPanel().getComponents()){
                if(component instanceof JTextField){
                    JTextField textComponent = (JTextField) component;
                    System.out.println(textComponent.getName()+": "+textComponent.getText());
                }
            }

//            //Paint the service logo on the layered pane canvas.
//            ImageIcon jenkinsLogo = null;
//            try {
//                jenkinsLogo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("icons/" + proxy.getLogoFileName())));
//                double logoRatio = jenkinsLogo.getIconWidth() / (double) jenkinsLogo.getIconHeight();
//                jenkinsLogo = ImageUtils.scaleImageIcon(jenkinsLogo, 50, (int) (50 * (1 + logoRatio)));
//            } catch (IOException e2) {
//                e2.printStackTrace();
//            }
//
//            JLabel jenkinsLabel = new JLabel(jenkinsLogo);
//            JLayeredPane workspace = mainGui.getWorkspace();
//            if (workspace.getComponentCount() > 0) {
//                int x = workspace.getComponentCount() * 10;
//                int y = workspace.getComponentCount() * 20;
//                jenkinsLabel.setBounds(x, y, 50, 86);
//            } else {
//                jenkinsLabel.setBounds(10, 20, 50, 86);
//            }
//
//            workspace.add(jenkinsLabel, new Integer(workspace.getComponentCount()), workspace.getComponentCount());
//            //End painting

        }
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        abstractSettingsMenu.getAbstractSettingsFrame().dispose();
    }
}
