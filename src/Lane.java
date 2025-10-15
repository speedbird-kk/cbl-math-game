import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Lane extends JPanel {
    Dimension laneSize = new Dimension();

    Lane(int tileWidth, int tileHeight, int x, int y) {
        this.setBounds(x, y, tileWidth * 2, tileHeight * 7);
        this.setOpaque(false);
        this.setPreferredSize(laneSize);
    }
}
