import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mode1Panel extends JPanel {
    GameContext gameContext;

    int aux = 0;

    Lane lane1;
    Lane lane2;
    Lane lane3;
    Lane lane4;
    JLabel scoreLabel;
    JLabel levelLabel;
    HeartDisplay heartDisplay;

    Mode1Panel(KeyHandler keyH, GameContext gameContext) {
        this.gameContext = gameContext;
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

        int tileWidth = gameContext.tileWidth;
        int tileHeight = gameContext.tileHeight;
        int laneX = tileWidth;
        lane1 = new Lane(laneX, tileHeight, gameContext);
        laneX += tileWidth * 2;
        lane2 = new Lane(laneX, tileHeight, gameContext);
        laneX += tileWidth * 2;
        lane3 = new Lane(laneX, tileHeight, gameContext);
        laneX += tileWidth * 2;
        lane4 = new Lane(laneX, tileHeight, gameContext);

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
        if (aux == 0) {
            lane1.addBlock();
            lane2.addBlock();
            lane3.addBlock();
            lane4.addBlock();
            aux = 1;
        }

        lane1.timeUpdate(timeElapsedMs, gameContext);
        lane2.timeUpdate(timeElapsedMs, gameContext);
        lane3.timeUpdate(timeElapsedMs, gameContext);
        lane4.timeUpdate(timeElapsedMs, gameContext);
    }
}

class HeartDisplay extends JPanel {
    GameContext gameContext;

    int heartWidth;
    int heartHeight;
    int sizeInHearts;
    int numberOfHearts = 0;

    Queue<Heart> hearts;

    HeartDisplay(GameContext gameContext) {
        this.gameContext = gameContext;
        heartWidth = gameContext.tileWidth;
        heartHeight = gameContext.tileHeight;
        this.sizeInHearts = numberOfHearts;

        // TODO(bogdan): Find a nicer way to compute this line
        this.setBounds(15 * gameContext.tileWidth - numberOfHearts * gameContext.tileWidth,
                gameContext.tileHeight, numberOfHearts * gameContext.tileWidth,
                gameContext.tileHeight);
    }
    // TODO(bogdan): Rethink this so it works with the game context, unify in one update call
    public void timeUpdate(int t, GameContext gameContext) {}

    class Heart extends JLabel {
        public void removeHeart() {}
    }
}