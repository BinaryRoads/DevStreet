package nl.rickyvanrijn.projects.devstreet.gui.main.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ricky on 21-3-2017.
 */
public class MainGuiActionListener implements ActionListener {
    private MainGui parentJframe;

    public MainGuiActionListener(MainGui parentJframe){
        this.parentJframe = parentJframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass() == javax.swing.JMenuItem.class){
            switch(e.getActionCommand()){
                case "SSH server": parentJframe.getModelList()[1].getSettingsMenu().show();
                    break;

                case "Jenkins/Hudson": parentJframe.getModelList()[0].getSettingsMenu().show();
                    break;

                case "GIT": System.out.println("Git");
                    break;

                case "Sattelite/Spacewalk": System.out.println("Sattelite");
                    break;
            }
        }
    }
}
