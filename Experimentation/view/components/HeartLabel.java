package Experimentation.view.components;

import Experimentation.utils.SwingUtils;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.LengthConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HeartLabel extends JLabel {
    private final ImageIcon heart = 
        SwingUtils.scaleImageToFit(
            new ImageIcon(SwingUtils.getImagePath("heart.png")),
            LengthConstants.HEART_WIDTH.get(),
            LengthConstants.HEART_HEIGHT.get()
        );
    
    /**
     * Set preferred size of heart label and set icon.
     */
    public HeartLabel() {
        Style.HEART_LABEL.accept(this);
        this.setIcon(heart);
    }
}
