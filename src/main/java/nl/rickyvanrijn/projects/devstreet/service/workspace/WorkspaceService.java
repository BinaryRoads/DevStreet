package nl.rickyvanrijn.projects.devstreet.service.workspace;
import nl.rickyvanrijn.projects.devstreet.gui.main.Workspace;
import nl.rickyvanrijn.projects.devstreet.gui.main.listeners.WorkspaceMouseListener;
import nl.rickyvanrijn.projects.devstreet.models.ModelInterface;
import nl.rickyvanrijn.projects.devstreet.utils.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class WorkspaceService {
    private ArrayList<ModelInterface> serviceList;
    private Workspace workspace;
    private JLayeredPane layeredPane;

    public WorkspaceService(Workspace workspace){
        this.workspace = workspace;
        serviceList = new ArrayList<ModelInterface>();
    }

    public void attachTo(JLayeredPane layeredPane){
        this.layeredPane = layeredPane;
    }

    public void addServiceModel(ModelInterface serviceModel){
        serviceList.add(serviceModel);
    }

    public Workspace getWorkspace(){
        return workspace;
    }

    public ModelInterface findServiceModel(String serviceName){
        ModelInterface returnableModelInterface = null;
        for(ModelInterface model: serviceList){
            if(model.getServiceName().equalsIgnoreCase(serviceName)){
                returnableModelInterface = model;
            }
        }
        return returnableModelInterface;
    }

    public ArrayList<ModelInterface> getModels(){
        if(this.serviceList != null){
            return this.serviceList;
        }else{
            return new ArrayList<ModelInterface>();
        }

    }

    public boolean updateServiceModel(ModelInterface updatedServiceModel){
        boolean isUpdated = false;

        for(ModelInterface model: serviceList){
            if(model.getServiceName().equalsIgnoreCase(updatedServiceModel.getServiceName())){
                serviceList.set(serviceList.indexOf(model),updatedServiceModel);
                isUpdated = true;
            }
        }
        return isUpdated;
    }

    public void buildWorkspace() {
        layeredPane.removeAll();
        for (ModelInterface model : serviceList) {
            ImageIcon serviceLogo = ImageUtils.getImageIconFromResources(model.getLogoFileName());

            JLabel serviceLabel = new JLabel(serviceLogo);

            if (layeredPane.getComponentCount() > 0) {
                int x = (int)layeredPane.getComponent(layeredPane.getComponentCount()-1).getBounds().getWidth() + 25;
                int y = 20;
                serviceLabel.setBounds(x, y, 50, 86);
            } else {
                serviceLabel.setBounds(10, 20, 50, 86);
            }
            serviceLabel.setToolTipText(model.getServiceName());
            serviceLabel.addMouseListener(new WorkspaceMouseListener(this));
            layeredPane.add(serviceLabel, new Integer(layeredPane.getComponentCount()), layeredPane.getComponentCount());
        }
    }

}
