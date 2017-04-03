package nl.rickyvanrijn.projects.devstreet.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 3-4-2017.
 */
public class ImageUtils {
    public static ImageIcon scaleImageIcon(ImageIcon imageIcon, int width, int height){
        ImageIcon bufferImageIcon = imageIcon; // load the image to a imageIcon
        Image image = bufferImageIcon.getImage(); // transform it
        Image newImage = image.getScaledInstance(width, height,  Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newImage);
    }
}
