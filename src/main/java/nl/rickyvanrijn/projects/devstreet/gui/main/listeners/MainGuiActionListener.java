package nl.rickyvanrijn.projects.devstreet.gui.main.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.JenkinsSettingsMenu;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.SshSettingsMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ricky on 21-3-2017.
 */
public class MainGuiActionListener implements ActionListener {
    private JFrame parentJframe;

    public MainGuiActionListener(JFrame parentJframe){
        this.parentJframe = parentJframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass() == javax.swing.JMenuItem.class){
            switch(e.getActionCommand()){
                case "SSH server": new SshSettingsMenu();
                    break;

                case "Jenkins/Hudson": new JenkinsSettingsMenu();
                    break;

                case "GIT": System.out.println("Git");
                    break;

                case "Sattelite/Spacewalk": System.out.println("Sattelite");
                    break;
            }
        }
    }
}
