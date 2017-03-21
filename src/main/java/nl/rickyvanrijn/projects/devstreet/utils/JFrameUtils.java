package nl.rickyvanrijn.projects.devstreet.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ricky on 21-3-2017.
 */
public class JFrameUtils {
    public static void centerAlignJFrame(JFrame uncenteredJFrame){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        uncenteredJFrame.setLocation(dim.width/2-uncenteredJFrame.getSize().width/2, dim.height/2-uncenteredJFrame.getSize().height/2);
    }
}
