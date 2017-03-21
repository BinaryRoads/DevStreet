package nl.rickyvanrijn.projects.devstreet.loader;

import nl.rickyvanrijn.projects.devstreet.gui.main.MainGui;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;

import javax.swing.*;

/**
 * Created by rri21401 on 20-3-2017.
 */
public class ProjectLoader {
    public static void main(String args[]){
        JFrame.setDefaultLookAndFeelDecorated(true);
        try
        {
            UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        new MainGui();
    }
}
