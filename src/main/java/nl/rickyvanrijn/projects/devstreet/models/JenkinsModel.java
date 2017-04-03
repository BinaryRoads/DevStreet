package nl.rickyvanrijn.projects.devstreet.models;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractSettingsMenu;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.JenkinsSettingsMenu;
import nl.rickyvanrijn.projects.devstreet.service.jenkins.JenkinsService;

import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class JenkinsModel implements ModelInterface {
    private String serviceName;
    private String logoFileName;
    private String jenkinsHostUrl;
    private String jenkinsUsername;
    private String jenkinsPassword;
    private AbstractSettingsMenu jenkinsSettingsMenu;
    private Point locationWorkspace;
    private JenkinsService jenkinsService;

    public JenkinsModel(String serviceName, String logoFileName, String jenkinsHostUrl, String jenkinsUsername, String jenkinsPassword, Point locationWorkspace) {
        this.serviceName = serviceName;
        this.logoFileName = logoFileName;
        this.jenkinsHostUrl = jenkinsHostUrl;
        this.jenkinsUsername = jenkinsUsername;
        this.jenkinsPassword = jenkinsPassword;
        this.jenkinsSettingsMenu = new JenkinsSettingsMenu(this);
        this.locationWorkspace = locationWorkspace;
        this.jenkinsService = new JenkinsService(jenkinsHostUrl, jenkinsUsername, jenkinsPassword);
    }

    public String getServiceName(){
        return serviceName;
    }

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public String getJenkinsHostUrl() {
        return jenkinsHostUrl;
    }

    public void setJenkinsHostUrl(String jenkinsHostUrl) {
        this.jenkinsHostUrl = jenkinsHostUrl;
    }

    public String getJenkinsUsername() {
        return jenkinsUsername;
    }

    public void setJenkinsUsername(String jenkinsUsername) {
        this.jenkinsUsername = jenkinsUsername;
    }

    public String getJenkinsPassword() {
        return jenkinsPassword;
    }

    public void setJenkinsPassword(String jenkinsPassword) {
        this.jenkinsPassword = jenkinsPassword;
    }

    public AbstractSettingsMenu getSettingsMenu() {
        return jenkinsSettingsMenu;
    }

    public Point getLocationWorkspace() {
        return locationWorkspace;
    }

    public void setLocationWorkspace(Point locationWorkspace) {
        this.locationWorkspace = locationWorkspace;
    }

    public JenkinsService getJenkinsService() {
        return jenkinsService;
    }

    public void setJenkinsService(JenkinsService jenkinsService) {
        this.jenkinsService = jenkinsService;
    }
}
