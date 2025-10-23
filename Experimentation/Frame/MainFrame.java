package Experimentation.Frame;

import Experimentation.Styles.DimensionConstants;
import javax.swing.JFrame;

/**
 * Singleton.
 */
public final class MainFrame {
    private static final JFrame FRAME = new JFrame("Falling maths !");

    static {
        FRAME.setSize(DimensionConstants.FRAME.get());
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private MainFrame() {
    }

    public static JFrame getFrame() {
        return FRAME;
    }
}