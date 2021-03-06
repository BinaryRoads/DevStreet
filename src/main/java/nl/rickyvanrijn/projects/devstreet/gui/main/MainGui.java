package nl.rickyvanrijn.projects.devstreet.gui.main;

import nl.rickyvanrijn.projects.devstreet.gui.main.listeners.MainGuiActionListener;
import nl.rickyvanrijn.projects.devstreet.gui.main.listeners.ControlPanelMouseListener;
import nl.rickyvanrijn.projects.devstreet.models.jenkins.JenkinsModel;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.ssh.SshModel;
import nl.rickyvanrijn.projects.devstreet.utils.ImageUtils;
import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricky on 21-3-2017.
 */
public class MainGui{
    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JMenu settingsMenu;
    private JMenu runMenu;
    private JMenuItem settingsMenuItem;

    private JLayeredPane workspacePane;
    private Workspace workspace;

    private MainGuiActionListener mainGuiActionListener;
    private static Border border = LineBorder.createGrayLineBorder();

    private IModel[] modelList = {};

    private String[] serviceStrings = { "Jenkins/Hudson", "SSH server",
            "GIT",   "Sattelite/Spacewalk" };

    public MainGui(){
        if(mainFrame == null) {
            mainFrame = new JFrame();
        }

        modelList = new IModel[2];
        modelList[0] = new JenkinsModel("Jenkins", "jenkins.png");
        modelList[1] = new SshModel("SSH","ssh.png");

        workspacePane = new JLayeredPane();
        workspacePane.setPreferredSize(new Dimension(300, 310));
        workspacePane.setBorder(BorderFactory.createTitledBorder("DevStreet Workspace"));
        workspace = new Workspace(workspacePane);

        mainGuiActionListener = new MainGuiActionListener(this);

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

        runMenu = new JMenu("Run workspace");
        try {
            ImageIcon runIcon = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("icons/play_icon.png")));
            runMenu.setIcon(ImageUtils.scaleImageIcon(runIcon, 50,50));
            runMenu.setToolTipText("Run workspace");
            runMenu.setText("");
        }catch(IOException imageReadException){
            imageReadException.printStackTrace();
        }

        settingsMenu = new JMenu("Settings");

        try {
            ImageIcon settingsIcon = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("icons/settings_icon.png")));
            settingsMenu.setIcon(ImageUtils.scaleImageIcon(settingsIcon, 50,50));
            settingsMenu.setToolTipText("Settings");
            settingsMenu.setText("");
        }catch(IOException imageReadException){
            imageReadException.printStackTrace();
        }


        settingsMenu.getAccessibleContext().setAccessibleDescription(
                "The settings settingsMenu");

        for(String serviceName : serviceStrings) {
            settingsMenuItem = new JMenuItem(serviceName);
            settingsMenuItem.addActionListener(mainGuiActionListener);
            settingsMenu.add(settingsMenuItem);
        }

        menuBar.add(runMenu);
        menuBar.add(settingsMenu);

        mainFrame.setJMenuBar(menuBar);
    }

    private void addComponents(){
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10)));
        mainFrame.add(createControlPanel());
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10)));
        mainFrame.add(workspacePane);
    }

    private JPanel createControlPanel(){

        ArrayList<JLabel> labels = new ArrayList<JLabel>();

        for(IModel proxy: modelList){
            ImageIcon serviceLogo = ImageUtils.getImageIconFromResources(proxy.getLogoFileName());

            JLabel serviceLabel = new JLabel(serviceLogo);
            serviceLabel.setBorder(border);
            serviceLabel.setToolTipText(proxy.getServiceName());
            serviceLabel.addMouseListener(new ControlPanelMouseListener(workspace));
            labels.add(serviceLabel);
        }
        JPanel controls = new JPanel();

        for(JLabel label: labels){
            controls.add(label);
            controls.add(new JLabel(" "));
        }

        controls.setPreferredSize(new Dimension(300,100));

        controls.setOpaque(true);

        controls.setBorder(BorderFactory.createTitledBorder(
                "Click to add on workspace"));
        return controls;
    }

}
