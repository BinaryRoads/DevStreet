package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners.FormListener;
import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.models.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by rri21401 on 22-3-2017.
 */
public abstract class AbstractSettingsForm {
    private JPanel formPanel;
    private JFrame abstractSettingsFrame;
    private String panelBorderTitle = "Settings";
    private FormListener formListener;
    private GridBagConstraints gridConstraints;

    protected ModelInterface modelInterface;

    protected Component nextLine = Box.createRigidArea(new Dimension(0, 10));

    public AbstractSettingsForm(String logoSettingsMenu, Workspace workspace) {
        abstractSettingsFrame = new JFrame(panelBorderTitle);
        abstractSettingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        abstractSettingsFrame.setResizable(false);

        formListener = new FormListener(this, workspace);
        try {
            abstractSettingsFrame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("icons/" + logoSettingsMenu)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        abstractSettingsFrame.addWindowFocusListener(formListener);

        abstractSettingsFrame.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        abstractSettingsFrame.setPreferredSize(new Dimension(750, 500));
        addJPanel();
        abstractSettingsFrame.pack();

        JFrameUtils.centerAlignJFrame(abstractSettingsFrame);
    }

    public void addJButtonActionListener(JButton button){
        button.addActionListener(formListener);
    }

    public JFrame getAbstractSettingsFrame(){
        return abstractSettingsFrame;
    }

    public JPanel getFormPanel(){
        return formPanel;
    }

    public void show(){ abstractSettingsFrame.setVisible(true); }

    protected void setPanelBorderTitle(String newPanelBorderTitle){
        panelBorderTitle = newPanelBorderTitle;
        formPanel.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        abstractSettingsFrame.setTitle(newPanelBorderTitle);
    }

    protected void addComponents(Component[] componentList){
        int xLoopIndex = 0;
        int yLoopIndex = 0;
        for(Component component: componentList){
            gridConstraints.gridy = yLoopIndex;
            gridConstraints.gridx = xLoopIndex;
            formPanel.add(component, gridConstraints);
            if(gridConstraints.gridx%2 ==1){
                yLoopIndex++;
            }
            if(gridConstraints.gridx%2 ==0){
                xLoopIndex++;
            }else{
                xLoopIndex =0;
            }
        }
        abstractSettingsFrame.pack();
    }

    private void addJPanel() {
        abstractSettingsFrame.add(Box.createRigidArea(new Dimension(0, 10)));

        GridBagLayout gridBagLayout = new GridBagLayout();
        formPanel = new JPanel(new GridBagLayout());
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.setConstraints(formPanel, gridConstraints);

        formPanel.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        abstractSettingsFrame.add(formPanel, gridConstraints);
    }

    abstract public ModelInterface createModel(ServiceCredentialsModel serviceCredentialsModel);
    abstract public void loadModel(ModelInterface serviceModel);

}
