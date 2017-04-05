package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractSettingsForm;
import nl.rickyvanrijn.projects.devstreet.models.ServiceCredentialsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class FormListener implements WindowFocusListener, ActionListener {

    private AbstractSettingsForm abstractSettingsForm;
    private Workspace workspace;

    public FormListener(AbstractSettingsForm abstractSettingsForm, Workspace workspace){
        this.abstractSettingsForm = abstractSettingsForm;
        this.workspace = workspace;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().equals(JButton.class)) {
            JButton formButton = (JButton) e.getSource();

            ServiceCredentialsModel serviceCredentialsModel = new ServiceCredentialsModel();
            boolean validatedForm = true;

            for (Component component : abstractSettingsForm.getFormPanel().getComponents()) {
                if (component instanceof JTextField) {
                    JTextField textComponent = (JTextField) component;
                    if (textComponent.getName().contains("*")) {
                        if (textComponent.getText().isEmpty()) {
                            validatedForm = false;
                        }
                    }
                    if (textComponent.getName().toLowerCase().contains("url")) {
                        serviceCredentialsModel.setHostname(textComponent.getText().trim());
                    }
                    if (textComponent.getName().toLowerCase().contains("username")) {
                        serviceCredentialsModel.setUsername(textComponent.getText().trim());
                    }
                    if (textComponent.getName().toLowerCase().contains("password")) {
                        serviceCredentialsModel.setPassword(textComponent.getText().trim());
                    }
                    System.out.println(textComponent.getName() + ": " + textComponent.getText());
                }
            }
            System.out.println("Form validated: " + validatedForm);
            if (validatedForm) {

                if(formButton.getText().toLowerCase().equals("save")){
                    workspace.updateServiceModel(abstractSettingsForm.createModel(serviceCredentialsModel));
                    workspace.draw();
                    abstractSettingsForm.getAbstractSettingsFrame().dispose();
                }
                if(formButton.getText().toLowerCase().equals("create")){
                    System.out.println(abstractSettingsForm.getAbstractSettingsFrame().getTitle());
                    workspace.addServiceModel(abstractSettingsForm.createModel(serviceCredentialsModel));
                    workspace.draw();
                    abstractSettingsForm.getAbstractSettingsFrame().dispose();
                }

            } else {
                abstractSettingsForm.getAbstractSettingsFrame().dispose();
            }
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        abstractSettingsForm.getAbstractSettingsFrame().dispose();
    }
}
