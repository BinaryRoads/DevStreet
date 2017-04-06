package nl.rickyvanrijn.projects.devstreet.models;

/**
 * Created by rri21401 on 4-4-2017.
 */
public class ServiceCredentialsModel {
    private String username;
    private String password;
    private String hostname;
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public boolean hasCredentials(){
        return (this.hostname != null && this.password != null && this.hostname != null);
    }
}
