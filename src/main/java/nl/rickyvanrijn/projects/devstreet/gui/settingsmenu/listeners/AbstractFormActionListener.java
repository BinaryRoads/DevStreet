package nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractForm;
import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.utils.NetworkUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class AbstractFormActionListener implements ActionListener {

    private AbstractForm abstractForm;
    private Workspace workspace;

    public AbstractFormActionListener(AbstractForm abstractForm, Workspace workspace){
        this.abstractForm = abstractForm;
        this.workspace = workspace;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().equals(JButton.class)) {
            JButton formButton = (JButton) e.getSource();

            boolean validatedForm = abstractForm.validateForm();
            ServiceCredentialsModel serviceCredentialsModel = abstractForm.getServiceCredentialsModelFromForm();

            if (validatedForm && serviceCredentialsModel.hasCredentials()) {

                if (formButton.getText().toLowerCase().equals("save")) {
                    workspace.updateServiceModel(abstractForm.createModel(serviceCredentialsModel));
                    workspace.draw();
                    abstractForm.getAbstractSettingsFrame().dispose();
                }
                if (formButton.getText().toLowerCase().equals("create")) {
                    IModel newModel = abstractForm.createModel(serviceCredentialsModel);
                    newModel.setForm(abstractForm);
                    workspace.addServiceModel(newModel);
                    workspace.draw();
                    abstractForm.getAbstractSettingsFrame().dispose();
                }

            } else {
                abstractForm.getAbstractSettingsFrame().dispose();
            }

            if(formButton.getText().toLowerCase().equals("ping server") && validatedForm){
                if(NetworkUtils.isAlive(abstractForm.getServiceCredentialsModelFromForm())){
                    formButton.setBackground(Color.GREEN);
                }else{
                    formButton.setBackground(Color.RED);
                }
            }
        }
    }

}
