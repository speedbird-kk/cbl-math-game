import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TitleScreenPanel extends JPanel {
    int tileWidth = 0;
    int tileHeight = 0;

    TitleButton titleButton;

    TitleScreenPanel(int tileWidth, int tileHeight) {
        this.setBackground(Color.CYAN);
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.setLayout(null);
        titleButton = new TitleButton(tileWidth, tileHeight);
        this.add(titleButton);
    }
    public void update(int t) {
        titleButton.update(t);
    }
}
class TitleButton extends JButton {
    long animationTime = 0;
    int tileWidth = 0;
    int tileHeight = 0;

    TitleButton(int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.setBounds(tileWidth * 6, tileHeight * 4, tileWidth * 4, tileHeight);
        this.setFocusable(false);
    }
    public void update(int t) {
        animationTime += t;
        double angle = (animationTime % 2000) / 2000.0 * 2 * Math.PI;
        double sinT = Math.sin(angle);
        int newWidth = tileWidth * 4 + (int) (tileWidth / 2 * sinT);
        int newHeight = tileHeight + (int) (tileHeight / 4 * sinT);
        int newX = 16 * tileWidth / 2 - newWidth / 2;
        int newY = 9 * tileHeight / 2 - newHeight / 2;

        this.setBounds(newX, newY, newWidth, newHeight);
    }
}