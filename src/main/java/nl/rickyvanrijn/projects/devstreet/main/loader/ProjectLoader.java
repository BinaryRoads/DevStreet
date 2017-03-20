package nl.rickyvanrijn.projects.devstreet.main.loader;

import nl.rickyvanrijn.projects.devstreet.service.jenkins.JenkinsService;

/**
 * Created by rri21401 on 20-3-2017.
 */
public class ProjectLoader {
    public static void main(String args[]){
        new JenkinsService("http://jenkins-build-server.rad.lan:8080", "username", "password");
    }
}
