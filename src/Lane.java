import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Lane extends JPanel {
    Dimension laneSize = new Dimension();

    Lane(int x, int y, int tileWidth, int tileHeight) {
        this.setBounds(x, y, tileWidth * 2, tileHeight * 7);
        this.setBackground(Color.BLUE);
    }

    public void update() {}
}
