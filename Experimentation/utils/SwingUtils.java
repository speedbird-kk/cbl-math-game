package Experimentation.utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Utility helper methods for swing.
 */
public final class SwingUtils {
    private static final String IMAGE_PATH = "Experimentation/assets/images/";

    private SwingUtils() {}

    /**
     * Utility method for appending multiple children components to a parent.
     */
    public static void addAll(JComponent parent, JComponent... children) {
        for (JComponent child : children) {
            parent.add(child);
        }
    }

    /**
     * Utility method for scaling an image icon  while keeping aspect ratio.
     */
    public static ImageIcon scaleImageToFit(ImageIcon icon, int maxWidth, int maxHeight) {
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();

        double scale = Math.min(
            (double) maxWidth / originalWidth,
            (double) maxHeight / originalHeight
        );

        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);

        Image scaled = icon.getImage()
            .getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        return new ImageIcon(scaled);
    }

    /**
     * Utility method for getting the path to images in assets folder.
     */
    public static String getImagePath(String image) {
        return IMAGE_PATH + image;
    }
}