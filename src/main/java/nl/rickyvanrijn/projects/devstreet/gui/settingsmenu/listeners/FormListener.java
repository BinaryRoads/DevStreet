package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractSettingsForm;
import nl.rickyvanrijn.projects.devstreet.models.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.utils.NetworkUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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

            if (formButton.getText().toLowerCase().equals("save") || formButton.getText().toLowerCase().equals("create")) {

                boolean validatedForm = abstractSettingsForm.validateForm();
                ServiceCredentialsModel serviceCredentialsModel = abstractSettingsForm.getServiceCredentialsModelFromForm();

                if (validatedForm && serviceCredentialsModel.hasCredentials()) {

                    if (formButton.getText().toLowerCase().equals("save")) {
                        workspace.updateServiceModel(abstractSettingsForm.createModel(serviceCredentialsModel));
                        workspace.draw();
                        abstractSettingsForm.getAbstractSettingsFrame().dispose();
                    }
                    if (formButton.getText().toLowerCase().equals("create")) {
                        workspace.addServiceModel(abstractSettingsForm.createModel(serviceCredentialsModel));
                        workspace.draw();
                        abstractSettingsForm.getAbstractSettingsFrame().dispose();
                    }

                } else {
                    abstractSettingsForm.getAbstractSettingsFrame().dispose();
                }
            }

            if(formButton.getText().toLowerCase().equals("ping server") && abstractSettingsForm.validateForm()){
                if(NetworkUtils.isAlive(abstractSettingsForm.getServiceCredentialsModelFromForm())){
                    formButton.setBackground(Color.GREEN);
                }else{
                    formButton.setBackground(Color.RED);
                }
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
