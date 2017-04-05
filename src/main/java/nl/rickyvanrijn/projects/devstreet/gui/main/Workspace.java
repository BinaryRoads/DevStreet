package nl.rickyvanrijn.projects.devstreet.gui.main;

import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.service.workspace.WorkspaceService;

import javax.swing.*;
import java.awt.*;

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

    public void addServiceModel(ModelInterface serviceModel){
        workspaceService.addServiceModel(serviceModel);
    }

    public void updateServiceModel(ModelInterface serviceModel){
        workspaceService.updateServiceModel(serviceModel);
    }

    public void draw(){
        workspaceService.buildWorkspace();
    }
}
