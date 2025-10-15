import java.awt.Color;

import javax.swing.JPanel;

public class TitleScreenPanel extends JPanel {
    long animationTime = 0;

    TitleScreenPanel() {
        this.setBounds(0, 0, 100, 100);
        this.setBackground(Color.CYAN);
    }
    public void update(long t) {
        animationTime += t;
        double angle = (animationTime % 2000) / 2000.0 * 2 * Math.PI;
        double sinT = Math.sin(angle);

        this.setBounds(0, 0, (int) (100 + 30 * sinT), (int) (100 + 30 * sinT));
        // this.setBounds(
        //         0, 0, (int) (100 + animationTime / 1000), (int) (100 + animationTime / 1000));
    }
}
