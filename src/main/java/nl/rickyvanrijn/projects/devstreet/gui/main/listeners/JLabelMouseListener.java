package nl.rickyvanrijn.projects.devstreet.gui.main.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.utils.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class JLabelMouseListener implements MouseListener {

    private MainGui mainGui;

    public JLabelMouseListener(MainGui mainGui){
        this.mainGui = mainGui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel labelInitiator = (JLabel) e.getSource();

        for(ModelInterface proxy: mainGui.getModelList()){
            if(labelInitiator.getToolTipText().equalsIgnoreCase(proxy.getServiceName())){
                proxy.getSettingsMenu().show();

                //Paint the service logo on the layered pane canvas.
                ImageIcon jenkinsLogo = null;
                try {
                    jenkinsLogo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("icons/" + proxy.getLogoFileName())));
                    double logoRatio = jenkinsLogo.getIconWidth() / (double) jenkinsLogo.getIconHeight();
                    jenkinsLogo = ImageUtils.scaleImageIcon(jenkinsLogo, 50, (int) (50 * (1 + logoRatio)));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

                JLabel jenkinsLabel = new JLabel(jenkinsLogo);
                JLayeredPane workspace = mainGui.getWorkspace();
                if (workspace.getComponentCount() > 0) {
                    int x = workspace.getComponentCount() * 10;
                    int y = workspace.getComponentCount() * 20;
                    jenkinsLabel.setBounds(x, y, 50, 86);
                } else {
                    jenkinsLabel.setBounds(10, 20, 50, 86);
                }

                workspace.add(jenkinsLabel, new Integer(workspace.getComponentCount()), workspace.getComponentCount());
                //End painting

            }
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
