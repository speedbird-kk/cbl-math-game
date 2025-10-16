import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Lane extends JPanel {
    int tileWidth;
    int tileHeight;
    Dimension laneSize = new Dimension();

    Lane(int x, int y, int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.setBounds(x, y, tileWidth * 2, tileHeight * 7);
        this.setBackground(Color.BLUE);
    }

    public void timeUpdate(int timeElapsedMs) {}
}
