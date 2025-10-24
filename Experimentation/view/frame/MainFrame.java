package Experimentation.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Experimentation.view.styles.DimensionConstants;

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
        frame.setVisible(true);
    }

    public static synchronized MainFrame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainFrame();
        }

        return INSTANCE;
    }

    public void setContent(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}