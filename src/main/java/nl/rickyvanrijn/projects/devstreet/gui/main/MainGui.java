package nl.rickyvanrijn.projects.devstreet.gui.main;

import nl.rickyvanrijn.projects.devstreet.gui.main.listeners.MainGuiActionListener;
import nl.rickyvanrijn.projects.devstreet.gui.main.listeners.JLabelMouseListener;
import nl.rickyvanrijn.projects.devstreet.models.JenkinsModel;
import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.models.SshModel;
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
    private JMenuItem settingsMenuItem;

    private JLayeredPane workspace;

    private MainGuiActionListener mainGuiActionListener;
    private static Border border = LineBorder.createGrayLineBorder();

    private ModelInterface[] modelList = {};

    private String[] serviceStrings = { "Jenkins/Hudson", "SSH server",
            "GIT",   "Sattelite/Spacewalk" };

    public MainGui(){
        if(mainFrame == null) {
            mainFrame = new JFrame();
        }

        modelList = new ModelInterface[2];
        modelList[0] = new JenkinsModel("Jenkins", "jenkins.png");
        modelList[1] = new SshModel("SSH", "ssh.png");

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

    public ModelInterface[] getModelList(){
        return modelList;
    }

    public JLayeredPane getWorkspace(){
        return workspace;
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
        workspace = createWorkSpace();
        mainFrame.add(workspace);
    }

    private JPanel createControlPanel(){

        ArrayList<JLabel> labels = new ArrayList<JLabel>();

        for(ModelInterface proxy: modelList){
            ImageIcon jenkinsLogo = null;
            try {
                jenkinsLogo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("icons/"+proxy.getLogoFileName())));
                double logoRatio = jenkinsLogo.getIconWidth()/(double)jenkinsLogo.getIconHeight();
                jenkinsLogo = ImageUtils.scaleImageIcon(jenkinsLogo, 50,(int)(50*(1+logoRatio)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            JLabel jenkinsLabel = new JLabel(jenkinsLogo);
            jenkinsLabel.setBorder(border);
            jenkinsLabel.setToolTipText(proxy.getServiceName());
            jenkinsLabel.addMouseListener(new JLabelMouseListener(this));
            labels.add(jenkinsLabel);
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

    private JLayeredPane createWorkSpace(){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 310));
        layeredPane.setBorder(BorderFactory.createTitledBorder("DevStreet Workspace"));
        return layeredPane;
    }

}
