import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

public class Mode1Panel extends JPanel {
    Lane lane1;
    Lane lane2;
    Lane lane3;
    Lane lane4;

    Mode1Panel(int tileWidth, int tileHeight) {
        this.setLayout(null);
        this.setBackground(Color.magenta);

        int laneX = tileWidth;
        lane1 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
        laneX += tileWidth * 2;
        lane2 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
        laneX += tileWidth * 2;
        lane3 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
        laneX += tileWidth * 2;
        lane4 = new Lane(laneX, tileHeight, tileWidth, tileHeight);

        this.add(lane1);
        this.add(lane2);
        this.add(lane3);
        this.add(lane4);
    }

    void timeUpdate(int timeElapsedMs) {
        lane1.timeUpdate(timeElapsedMs);
        lane2.timeUpdate(timeElapsedMs);
        lane3.timeUpdate(timeElapsedMs);
        lane4.timeUpdate(timeElapsedMs);
    }
}
