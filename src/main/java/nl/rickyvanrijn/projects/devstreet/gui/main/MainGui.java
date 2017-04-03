package nl.rickyvanrijn.projects.devstreet.gui.main;

import nl.rickyvanrijn.projects.devstreet.gui.main.listeners.MainGuiActionListener;
import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ricky on 21-3-2017.
 */
public class MainGui {
    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JMenu settingsMenu;
    private JMenuItem settingsMenuItem;

    private MainGuiActionListener mainGuiActionListener;

    private String[] serviceStrings = { "Jenkins/Hudson", "SSH server",
            "GIT",   "Sattelite/Spacewalk" };

    public MainGui(){
        if(mainFrame == null) {
            mainFrame = new JFrame();
        }

        mainGuiActionListener = new MainGuiActionListener(mainFrame);

        mainFrame.setTitle("DevStreet Mobster");
        mainFrame.setPreferredSize(new Dimension(800,600));
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        addMenu();
        addComponents();
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        try {
            mainFrame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("icons/Control_Panel.png") ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrameUtils.centerAlignJFrame(mainFrame);
    }

    private void addMenu(){
        menuBar = new JMenuBar();
        settingsMenu = new JMenu("Settings");

        settingsMenu.getAccessibleContext().setAccessibleDescription(
                "The settings settingsMenu");

        for(String serviceName : serviceStrings) {
            settingsMenuItem = new JMenuItem(serviceName);
            settingsMenuItem.addActionListener(mainGuiActionListener);
            settingsMenu.add(settingsMenuItem);
        }


        menuBar.add(settingsMenu);

        mainFrame.setJMenuBar(menuBar);
    }

    private void addComponents(){
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10)));
        mainFrame.add(createControlPanel());
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10)));
        mainFrame.add(createWorkSpace());
    }

    private JPanel createControlPanel(){
        JComboBox serviceList = new JComboBox(serviceStrings);
        serviceList.setSelectedIndex(0);
        serviceList.addActionListener(mainGuiActionListener);

        JPanel controls = new JPanel();
        controls.add(serviceList);
        controls.setBorder(BorderFactory.createTitledBorder(
                "Choose service layer"));
        return controls;
    }

    private JLayeredPane createWorkSpace(){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 310));
        layeredPane.setBorder(BorderFactory.createTitledBorder("DevStreet Workspace"));
        return layeredPane;
    }
}
