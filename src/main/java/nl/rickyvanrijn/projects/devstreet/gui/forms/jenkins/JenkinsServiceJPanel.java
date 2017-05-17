package nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins;

import nl.rickyvanrijn.projects.devstreet.gui.forms.jenkins.listeners.JenkinsServicePanelListener;
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

    private JComboBox viewList;
    private JComboBox jobsList;

    private String selectedViewName;
    private String selectedJobName;
    private JenkinsServicePanelListener jenkinsServicePanelListener;
    private GridBagConstraints gridBagConstraints;

    public JenkinsServiceJPanel(JenkinsModel jenkinsModel){
        this.jenkinsModel=jenkinsModel;
        this.serviceComponentPanel = new JPanel(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        jenkinsServicePanelListener = new JenkinsServicePanelListener(this);
    }

    public JPanel getServiceComponentPanel(){
        serviceComponentPanel.removeAll();

        JLabel viewLabel = new JLabel("Views:");
        viewList = new JComboBox();
        viewList.setName("ViewName");
        if(jenkinsModel.getService() != null) {
            viewList = new JComboBox(jenkinsModel.getService().getViews().toArray());
            viewList.addActionListener(jenkinsServicePanelListener);
            if(selectedViewName != null && !selectedViewName.isEmpty()){
                for(int itemIndex = 0; itemIndex < viewList.getItemCount();itemIndex++){
                    if(viewList.getItemAt(itemIndex).toString().equals(selectedViewName)){
                        viewList.setSelectedIndex(itemIndex);
                    }
                }
            }
        }

        JLabel jobsLabel = new JLabel("Jobs:");
        jobsList = new JComboBox();
        jobsList.setName("JobName");
        if(jenkinsModel.getService() != null && viewList.getItemCount() > 0) {
            jobsList = new JComboBox(jenkinsModel.getService().getJobs(viewList.getSelectedItem().toString()).toArray());
            jobsList.addActionListener(jenkinsServicePanelListener);

            if(selectedJobName != null && !selectedJobName.isEmpty()){
                for(int itemIndex = 0; itemIndex < jobsList.getItemCount();itemIndex++){
                    if(jobsList.getItemAt(itemIndex).toString().equals(selectedJobName)){
                        jobsList.setSelectedIndex(itemIndex);
                    }
                }
            }
        }

        JButton runServiceButton = new JButton("Run Service");
        runServiceButton.addActionListener(jenkinsServicePanelListener);

        serviceComponentPanel.add(viewLabel, gridBagConstraints);
        serviceComponentPanel.add(viewList, gridBagConstraints);
        serviceComponentPanel.add(jobsLabel, gridBagConstraints);
        serviceComponentPanel.add(jobsList, gridBagConstraints);
        serviceComponentPanel.add(runServiceButton, gridBagConstraints);

        return serviceComponentPanel;
    }

    public String getSelectedViewName() {
        return selectedViewName;
    }

    public void setSelectedViewName(String selectedViewName) {
        this.selectedViewName = selectedViewName;
    }

    public String getSelectedJobName() {
        return selectedJobName;
    }

    public void setSelectedJobName(String selectedJobName) {
        this.selectedJobName = selectedJobName;
    }

    public JComboBox getViewList() {
        return viewList;
    }

    public void setViewList(JComboBox viewList) {
        this.viewList = viewList;
    }

    public JComboBox getJobsList() {
        return jobsList;
    }

    public void setJobsList(JComboBox jobsList) {
        this.jobsList = jobsList;
    }

    public void runService(){
        jenkinsModel.getService().run();
    }

}
