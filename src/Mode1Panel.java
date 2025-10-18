import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mode1Panel extends JPanel {
    Lane lane1;
    Lane lane2;
    Lane lane3;
    Lane lane4;
    JLabel scoreLabel;
    JLabel levelLabel;
    HeartDisplay heartDisplay;

    Mode1Panel(KeyHandler keyH, int tileWidth, int tileHeight) {
        this.setLayout(null);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setBackground(Color.magenta);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Mode1Panel.this.requestFocusInWindow();
            }
        });

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

        scoreLabel = new JLabel();
        scoreLabel.setBounds(
                12 * tileWidth, 2 * tileHeight, 3 * tileWidth, (int) (0.75 * tileHeight));
        scoreLabel.setBackground(Color.RED);
        scoreLabel.setOpaque(true);
        this.add(scoreLabel);

        levelLabel = new JLabel();
        levelLabel.setBounds(
                12 * tileWidth, 3 * tileHeight, 3 * tileWidth, (int) (0.75 * tileHeight));
        levelLabel.setBackground(Color.RED);
        levelLabel.setOpaque(true);
        this.add(levelLabel);
    }

    void timeUpdate(int timeElapsedMs) {
        lane1.timeUpdate(timeElapsedMs);
        lane2.timeUpdate(timeElapsedMs);
        lane3.timeUpdate(timeElapsedMs);
        lane4.timeUpdate(timeElapsedMs);
    }
}

class HeartDisplay extends JPanel {
    int heartWidth;
    int heartHeight;
    int sizeInHearts;
    int numberOfHearts = 0;

    Queue<Heart> hearts;

    HeartDisplay(int tileWidth, int tileHeight, int numberOfHearts) {
        heartWidth = tileWidth;
        heartHeight = tileHeight;
        this.sizeInHearts = numberOfHearts;

        this.setBounds(15 * tileWidth - numberOfHearts * tileWidth, tileHeight,
                numberOfHearts * tileWidth, tileHeight);
    }
    public void addHeart() {
        Heart heart = new Heart();
        heart.setBounds(heartWidth * sizeInHearts - heartWidth * numberOfHearts, 0, heartWidth,
                heartHeight);
        hearts.add(heart);
        this.add(heart);

        numberOfHearts++;
    }
    public void removeHeart() {
        Heart heart = hearts.poll();
        this.remove(heart);
    }

    class Heart extends JLabel {
        public void removeHeart() {}
    }
}