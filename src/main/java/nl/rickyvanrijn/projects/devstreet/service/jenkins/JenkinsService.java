package nl.rickyvanrijn.projects.devstreet.service.jenkins;

import com.offbytwo.jenkins.JenkinsServer;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by rri21401 on 20-3-2017.
 */
public class JenkinsService {
    JenkinsServer jenkins;
    public JenkinsService(){
        try{
            jenkins = new JenkinsServer(new URI("http://localhost:8080/jenkins"), "admin", "password");
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
