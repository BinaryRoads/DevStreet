package nl.rickyvanrijn.projects.devstreet.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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

    public static ImageIcon getImageIconFromResources(String iconName){
        ImageIcon serviceLogo = null;

        try {
            serviceLogo = new ImageIcon(ImageIO.read(ImageUtils.class.getClassLoader().getResource("icons/" + iconName)));
            double logoRatio = serviceLogo.getIconWidth() / (double) serviceLogo.getIconHeight();
            serviceLogo = ImageUtils.scaleImageIcon(serviceLogo, 50, (int) (50 * (1 + logoRatio)));
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        return serviceLogo;
    }
}
