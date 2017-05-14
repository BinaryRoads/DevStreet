package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners.AbstractFormActionListener;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners.AbstractFormWindowFocusListener;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.utils.JFrameUtils;
import nl.rickyvanrijn.projects.devstreet.utils.NetworkUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by rri21401 on 22-3-2017.
 */
public abstract class AbstractForm {
    private JPanel credentialsFormPanel;
    private JFrame abstractSettingsFrame;
    private String panelBorderTitle = "Settings";
    private AbstractFormActionListener abstractFormActionListener;
    private AbstractFormWindowFocusListener abstractFormWindowFocusListener;
    private GridBagConstraints gridConstraints;

    protected JPanel serviceComponentPanel;
    protected Workspace workspace;
    protected Component nextLine = Box.createRigidArea(new Dimension(0, 10));

    public AbstractForm(String logoSettingsMenu, Workspace workspace) {
        this.workspace = workspace;
        abstractSettingsFrame = new JFrame(panelBorderTitle);
        abstractSettingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        abstractSettingsFrame.setResizable(false);

        abstractFormActionListener = new AbstractFormActionListener(this, workspace);
        abstractFormWindowFocusListener = new AbstractFormWindowFocusListener(this);

        try {
            abstractSettingsFrame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("icons/" + logoSettingsMenu)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        abstractSettingsFrame.addWindowFocusListener(abstractFormWindowFocusListener);

        abstractSettingsFrame.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        abstractSettingsFrame.setPreferredSize(new Dimension(750, 500));
        addJPanel();
        serviceComponentPanel = new JPanel(new GridBagLayout());

        abstractSettingsFrame.pack();

        JFrameUtils.centerAlignJFrame(abstractSettingsFrame);
    }

    public void addJButtonActionListener(JButton button){
        button.addActionListener(abstractFormActionListener);
    }

    public JFrame getAbstractSettingsFrame(){
        return abstractSettingsFrame;
    }

    public boolean validateForm(){
        boolean validatedForm = true;

        for (Component component : credentialsFormPanel.getComponents()) {
            if (component instanceof JTextField) {
                JTextField textComponent = (JTextField) component;
                if (textComponent.getName().contains("*")) {
                    if (textComponent.getText().isEmpty()) {
                        validatedForm = false;
                    }
                }
            }
        }
        return validatedForm;
    }

    public ServiceCredentialsModel getServiceCredentialsModelFromForm(){
        ServiceCredentialsModel serviceCredentialsModel = new ServiceCredentialsModel();

        for (Component component : credentialsFormPanel.getComponents()) {
            if (component instanceof JTextField) {
                JTextField textComponent = (JTextField) component;

                if (textComponent.getName().toLowerCase().contains("url")) {
                    serviceCredentialsModel.setHostname(textComponent.getText().trim());
                }
                if (textComponent.getName().toLowerCase().contains("port")) {
                    serviceCredentialsModel.setPort(textComponent.getText().trim());
                }
                if (textComponent.getName().toLowerCase().contains("username")) {
                    serviceCredentialsModel.setUsername(textComponent.getText().trim());
                }
                if (textComponent.getName().toLowerCase().contains("password")) {
                    serviceCredentialsModel.setPassword(textComponent.getText().trim());
                }
            }
        }

        if(serviceCredentialsModel.hasCredentials() && NetworkUtils.isAlive(serviceCredentialsModel)){
            return serviceCredentialsModel;
        }

        return new ServiceCredentialsModel();
    }

    public void show(){
        loadServiceSpecificComponentPanel();
        refresh();
        abstractSettingsFrame.setVisible(true);
    }

    protected void setPanelBorderTitle(String newPanelBorderTitle){
        panelBorderTitle = newPanelBorderTitle;
        credentialsFormPanel.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        abstractSettingsFrame.setTitle(newPanelBorderTitle);
    }

    protected void addComponents(Component[] componentList){
        int xLoopIndex = 0;
        int yLoopIndex = 0;
        for(Component component: componentList){
            gridConstraints.gridy = yLoopIndex;
            gridConstraints.gridx = xLoopIndex;
            credentialsFormPanel.add(component, gridConstraints);
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
        credentialsFormPanel = new JPanel(new GridBagLayout());
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.setConstraints(credentialsFormPanel, gridConstraints);

        credentialsFormPanel.setBorder(BorderFactory.createTitledBorder(
                panelBorderTitle));
        abstractSettingsFrame.add(credentialsFormPanel, gridConstraints);
    }

    abstract public void loadServiceSpecificComponentPanel();
    abstract public void refresh();

    abstract public IModel createModel(ServiceCredentialsModel serviceCredentialsModel);

}
