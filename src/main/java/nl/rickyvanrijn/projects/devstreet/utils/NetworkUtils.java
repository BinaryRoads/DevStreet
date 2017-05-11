package nl.rickyvanrijn.projects.devstreet.utils;

import nl.rickyvanrijn.projects.devstreet.models.ServiceCredentialsModel;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by rri21401 on 10-5-2017.
 */
public class NetworkUtils {

    public static boolean isAlive(ServiceCredentialsModel serviceCredentialsModel){
        boolean pingAlive = false;

        if(serviceCredentialsModel.hasCredentials()) {
            try {
                Socket s = new Socket(serviceCredentialsModel.getHostname(), Integer.parseInt(serviceCredentialsModel.getPort()));
                s.close();
                pingAlive = true;
            } catch (IOException e1) {
                System.err.println("ERROR: " + e1.getLocalizedMessage());
            }
        }
        return pingAlive;
    }
}
