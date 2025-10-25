package Experimentation.view.frame;

import Experimentation.view.styles.Style;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Singleton.
 */
public final class MainFrame {
    private static MainFrame INSTANCE;
    private final JFrame frame;

    private MainFrame() {
        frame = new JFrame("Falling maths !");
        Style.MAIN_FRAME.accept(frame);
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