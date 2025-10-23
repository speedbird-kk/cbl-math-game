package Experimentation.Frame;

import Experimentation.Styles.DimensionConstants;
import javax.swing.JFrame;

/**
 * Singleton.
 */
public final class MainFrame {
    private static MainFrame INSTANCE;
    private final JFrame frame;

    private MainFrame() {
        frame = new JFrame("Falling maths !");
        frame.setSize(DimensionConstants.FRAME.get());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static synchronized MainFrame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainFrame();
        }

        return INSTANCE;
    }

    public JFrame getFrame() {
        return frame;
    }
}