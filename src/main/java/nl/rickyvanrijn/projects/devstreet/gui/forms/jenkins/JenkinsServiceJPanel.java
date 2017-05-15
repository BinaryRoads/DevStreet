package nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins;

import nl.rickyvanrijn.projects.devstreet.models.IModel;
import nl.rickyvanrijn.projects.devstreet.models.jenkins.JenkinsModel;
import nl.rickyvanrijn.projects.devstreet.service.jenkins.JenkinsService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 15/05/2017.
 */
public class JenkinsServiceJPanel {
    private JenkinsModel jenkinsModel;
    private JPanel serviceComponentPanel;

    public JenkinsServiceJPanel(JenkinsModel jenkinsModel){
        this.jenkinsModel=jenkinsModel;
        this.serviceComponentPanel = new JPanel(new GridBagLayout());
    }

    public JPanel getServiceComponentPanel(){
        serviceComponentPanel.removeAll();

        JLabel viewLabel = new JLabel("Views:");
        JComboBox viewList = new JComboBox(jenkinsModel.getService().getViews().toArray());

        serviceComponentPanel.add(viewLabel);
        serviceComponentPanel.add(viewList);
        serviceComponentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        serviceComponentPanel.add(viewLabel);
        serviceComponentPanel.add(viewList);

        return serviceComponentPanel;
    }

}
