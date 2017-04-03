package nl.rickyvanrijn.projects.devstreet.models;

import nl.rickyvanrijn.projects.devstreet.gui.settingsmenu.AbstractSettingsMenu;

import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public interface ModelInterface {
    public String getServiceName();
    public void setServiceName(String serviceName);
    public String getLogoFileName();
    public void setLogoFileName(String logoFileName);
    public Point getLocationWorkspace();
    public void setLocationWorkspace(Point locationWorkspace);
    public AbstractSettingsMenu getSettingsMenu();
}
