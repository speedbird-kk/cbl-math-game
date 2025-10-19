import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mode1Panel extends JPanel {
    GameContext gameContext;
    KeyHandler keyH;

    int aux = 0;
    int aux2 = 0;
    int timePassed = 0;
    int sign = 1;

    ArrayList<Lane> lanes = new ArrayList<Lane>();

    JLabel scoreLabel;
    JLabel levelLabel;
    HeartDisplay heartDisplay;

    Mode1Panel(KeyHandler keyH, GameContext gameContext) {
        this.gameContext = gameContext;
        this.keyH = keyH;
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
        for (int i = 0; i < 4; i++) {
            Lane lane = new Lane(laneX, tileHeight, gameContext);
            lanes.add(lane);
            this.add(lane);
            laneX += tileWidth * 2;
        }

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

        heartDisplay = new HeartDisplay(gameContext);
        this.add(heartDisplay);
    }

    void timeUpdate(int timeElapsedMs) {
        timePassed += timeElapsedMs;
        if (aux == 0) {
            for (Lane lane : lanes) {
                lane.addBlock();
            }
            // lanes.get(0).addBlock();
            aux = 1;
        }

        for (Lane lane : lanes) {
            for (Block block : lane.blocks) {
                block.timeUpdate(timeElapsedMs, gameContext);

                if ((int) block.y > gameContext.blockTravelDistance) {
                    System.out.println(block.y);
                    lane.removeBlock(block);
                    if (heartDisplay.numberOfHearts > 0) {
                        heartDisplay.numberOfHearts--;
                    }
                }
            }
            lane.timeUpdate(timeElapsedMs, gameContext);
        }

        heartDisplay.timeUpdate(timeElapsedMs);
    }
}

class HeartDisplay extends JPanel {
    GameContext gameContext;

    int panelWidth;
    int panelHeight;
    int heartWidth;
    int heartHeight;
    int numberOfHearts = 0;

    ArrayDeque<Heart> hearts = new ArrayDeque<HeartDisplay.Heart>();

    HeartDisplay(GameContext gameContext) {
        this.gameContext = gameContext;
        numberOfHearts = gameContext.InitialNumberOfHearts;
        heartWidth = gameContext.tileWidth;
        heartHeight = gameContext.tileHeight;
        panelWidth = 5 * heartWidth;
        panelHeight = heartHeight;

        // TODO(bogdan): Find a nicer way to compute this line
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(15 * gameContext.tileWidth - panelWidth, gameContext.tileHeight, panelWidth,
                panelHeight);
    }
    // TODO(bogdan): Rethink this so it works with the game context, unify in one update call
    public void timeUpdate(int t) {
        while (numberOfHearts > hearts.size()) {
            int x = panelWidth - (1 + hearts.size()) * heartWidth;
            Heart heart = new Heart(x, 0, heartWidth, heartHeight);
            hearts.addFirst(heart);
            this.add(heart);
        }
        while (numberOfHearts < hearts.size()) {
            Heart heart = hearts.poll();
            this.remove(heart);
        }
    }

    class Heart extends JLabel {
        Heart(int x, int y, int heartWidth, int heartHeight) {
            this.setBounds(x, y, heartWidth, heartHeight);
            this.setBackground(Color.GREEN);
            this.setOpaque(true);
        }
    }
}