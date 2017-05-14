package nl.rickyvanrijn.projects.devstreet.service;

import javax.swing.*;

/**
 * Created by rri21401 on 10-5-2017.
 */
public interface IService {
    void run();
    boolean isRunnable();
    JPanel getServiceSpecificJPanel();
}
