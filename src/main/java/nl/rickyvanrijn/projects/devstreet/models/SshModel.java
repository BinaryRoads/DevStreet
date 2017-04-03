package nl.rickyvanrijn.projects.devstreet.models;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractSettingsMenu;
import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.SshSettingsMenu;

import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class SshModel implements ModelInterface {
    private String serviceName;
    private String logoFileName;
    private String sshHostUrl;
    private String sshUsername;
    private String sshPassword;
    private AbstractSettingsMenu sshSettingsMenu;
    private Point locationWorkspace;

    public SshModel(String serviceName, String logoFileName, String sshHostUrl, String sshUsername, String sshPassword, Point locationWorkspace) {
        this.serviceName = serviceName;
        this.logoFileName = logoFileName;
        this.sshHostUrl = sshHostUrl;
        this.sshUsername = sshUsername;
        this.sshPassword = sshPassword;
        this.locationWorkspace = locationWorkspace;

        sshSettingsMenu = new SshSettingsMenu(this);
    }

    public AbstractSettingsMenu getSettingsMenu() {
        return sshSettingsMenu;
    }

    public String getSshHostUrl() {
        return sshHostUrl;
    }

    public void setSshHostUrl(String sshHostUrl) {
        this.sshHostUrl = sshHostUrl;
    }

    public String getSshUsername() {
        return sshUsername;
    }

    public void setSshUsername(String sshUsername) {
        this.sshUsername = sshUsername;
    }

    public String getSshPassword() {
        return sshPassword;
    }

    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String getLogoFileName() {
        return logoFileName;
    }

    @Override
    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    @Override
    public Point getLocationWorkspace() {
        return locationWorkspace;
    }

    @Override
    public void setLocationWorkspace(Point locationWorkspace) {
        this.locationWorkspace = locationWorkspace;
    }
}
