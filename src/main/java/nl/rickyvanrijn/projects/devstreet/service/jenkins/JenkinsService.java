package nl.rickyvanrijn.projects.devstreet.service.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.View;
import nl.rickyvanrijn.projects.devstreet.models.servicecredentials.ServiceCredentialsModel;
import nl.rickyvanrijn.projects.devstreet.service.IService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by rri21401 on 20-3-2017.
 */
public class JenkinsService implements IService{
    private JenkinsServer jenkins;
    private String view;
    private String job;
    private ServiceCredentialsModel serviceCredentials;

    public JenkinsService(ServiceCredentialsModel serviceCredentials){
        this.serviceCredentials = serviceCredentials;

        try{
            jenkins = new JenkinsServer(new URI("http://"+serviceCredentials.getHostname()+":"+ serviceCredentials.getPort()), serviceCredentials.getUsername(), serviceCredentials.getPassword());
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void startJob(Job job){
        Job selectedJob = job;
        if(jenkins != null){
            try {
                if(selectedJob != null) {
                    jenkins.getJob(selectedJob.getName()).build();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Job searchJob(String jobName) {
        Job resultJob = new Job();

        if (jenkins != null) {
            try {
                for (Map.Entry<String, Job> jobEntry : jenkins.getJobs().entrySet()) {
                    if (jobEntry.getKey().equals(jobName)) {
                        resultJob = jobEntry.getValue();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultJob;
    }

    public ArrayList<String> getViews(){
        ArrayList<String> viewNameList = new ArrayList<String>();
        if(jenkins != null){
            try {
                for(Map.Entry<String, View> viewEntry: jenkins.getViews().entrySet()){
                    viewNameList.add(viewEntry.getKey());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return viewNameList;
    }

    public ArrayList<String> getJobs(String viewName){
        ArrayList<String> jobNameList = new ArrayList<String>();
        if(jenkins != null){
            try {
               for(Map.Entry<String, Job> jobEntry : jenkins.getJobs().entrySet()){
                   jobNameList.add(jobEntry.getKey());
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jobNameList;
    }

    public void setView(String view){
        this.view = view;
    }

    public void setJob(String job){
        this.job = job;
    }

    @Override
    public void run() {
        try {

            for (Job job : jenkins.getView(this.view).getJobs()) {
                if(this.job.equals(job.getName())){
                    job.build();
//                    job.details().getLastBuild().details().getEstimatedDuration();
                    System.out.println("Job " + job.getName()+" was built.");
                    System.out.println();
                }

            }

        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    public boolean isRunnable() {
        return jenkins.isRunning();
    }

}
