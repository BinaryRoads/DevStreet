package nl.rickyvanrijn.projects.devstreet.gui.main;

import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.service.workspace.WorkspaceService;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class Workspace {
    private WorkspaceService workspaceService = new WorkspaceService(this);
    private JLayeredPane layeredPane;

    public Workspace(JLayeredPane layeredPane){
        this.layeredPane = layeredPane;
        workspaceService.attachTo(layeredPane);
    }

    public void addServiceModel(IModel serviceModel){
        workspaceService.addServiceModel(serviceModel);
    }

    public void updateServiceModel(IModel serviceModel){
        workspaceService.updateServiceModel(serviceModel);
    }

    public ArrayList<IModel> getModels(){
        return workspaceService.getModels();
    }

    public IModel findModel(String serviceName){
        return workspaceService.findServiceModel(serviceName);
    }

    public boolean isServiceModelOnline(String serviceName){
        workspaceService.findServiceModel(serviceName).getService().isRunnable();

        return true;
    }

    public void draw(){
        workspaceService.buildWorkspace();
    }
}
