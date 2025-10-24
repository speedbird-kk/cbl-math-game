import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import Experimentation.Styles.ApplyStyles;
import Experimentation.Styles.DimensionConstants;
import Experimentation.Styles.DistanceConstants;

public class Mode1Panel extends JPanel {
    GameContext gameContext;
    KeyHandler keyH;

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
        this.setBackground(gameContext.mode1BackgroundColor);
        this.setFocusTraversalKeysEnabled(false);

        // Get the InputMap that applies when a child has focus
        InputMap inputMap = this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getActionMap();

        // TAB Functionality!!!
        inputMap.put(KeyStroke.getKeyStroke("TAB"), "customTab");
        actionMap.put("customTab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField foundField = null;
                int minDistance = 99999;
                System.out.println("Tab pressed anywhere inside the panel!");

                for (Lane lane : lanes) {
                    for (Block block : lane.blocks) {
                        int distanceLeft = DistanceConstants.BLOCK_TRAVEL_DISTANCE.get()
                                - ((int) block.y + DimensionConstants.BLOCK.get().height);
                        if (distanceLeft < minDistance) {
                            foundField = lane.inputField;
                            minDistance = distanceLeft;
                        }
                    }
                }
                if (foundField != null) {
                    foundField.requestFocusInWindow();
                }
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Mode1Panel.this.requestFocusInWindow();
            }
        });

        int tileWidth = DimensionConstants.GRID.get().width;
        int tileHeight = DimensionConstants.GRID.get().height;

        {
            int laneX = tileWidth;
            Lane lane = new AdditionLane(laneX, tileHeight, 10, gameContext);
            lanes.add(lane);
            this.add(lane);
            laneX += tileWidth * 2;
            lane = new SubtractionLane(laneX, tileHeight, 10, gameContext);
            lanes.add(lane);
            this.add(lane);
            laneX += tileWidth * 2;
            lane = new MultiplicationLane(laneX, tileHeight, 10, gameContext);
            lanes.add(lane);
            this.add(lane);
            laneX += tileWidth * 2;
            lane = new DivisionLane(laneX, tileHeight, 10, gameContext);
            lanes.add(lane);
            this.add(lane);
            laneX += tileWidth * 2;
        }

        scoreLabel = new JLabel();
        scoreLabel.setBounds(12 * tileWidth, 2 * tileHeight,
                DimensionConstants.SCORE_LABEL.get().width,
                DimensionConstants.SCORE_LABEL.get().height);
        ApplyStyles.SCORE_LABEL_STYLE.on(scoreLabel);
        this.add(scoreLabel);

        levelLabel = new JLabel();
        ApplyStyles.LEVEL_LABEL_STYLE.on(levelLabel);
        levelLabel.setBounds(12 * tileWidth, 3 * tileHeight,
                DimensionConstants.LEVEL_LABEL.get().width,
                DimensionConstants.LEVEL_LABEL.get().height);
        this.add(levelLabel);

        heartDisplay = new HeartDisplay(gameContext);
        this.add(heartDisplay);
    }

    Random random = new Random();
    int aux = 0;
    int aux2 = 0;
    int timePassedMs = 0;
    int levelTimePassedMs = 0;
    int sign = 1;
    int level = 0;
    ArrayDeque<Integer> numbersLeft = new ArrayDeque<Integer>();

    void timeUpdate(int timeElapsedMs) {
        timePassedMs += timeElapsedMs;
        levelTimePassedMs += timeElapsedMs;

        if (numbersLeft.isEmpty()) {
            level++;
            levelTimePassedMs = 0;
            aux = 0;
            gameContext.blockTravelTimeS -= 5;
            levelLabel.setText("Level: " + level);
            for (int i = 0; i < 5 * level; i++) {
                numbersLeft.add(random.nextInt(5 * level));
            }
        }

        if (levelTimePassedMs > aux * 5000) {
            Lane lane = lanes.get(random.nextInt(4));
            lane.addBlock(numbersLeft.poll());

            aux++;
        }

        for (Lane lane : lanes) {
            while (!lane.submissions.isEmpty()) {
                int submission = lane.submissions.poll();
                Block firstBlock = lane.blocks.peek();
                if (firstBlock != null) {
                    if (submission == firstBlock.number) {
                        lane.removeBlock(firstBlock);
                    }
                }
            }
            // System.out.println(enteredNumber);
            for (Block block : lane.blocks) {
                block.timeUpdate(timeElapsedMs, gameContext);

                if ((int) block.y > DistanceConstants.BLOCK_TRAVEL_DISTANCE.get()) {
                    lane.removeBlock(block);
                    if (heartDisplay.getNumberOfHearts() > 0) {
                        heartDisplay.removeHeart();
                    }
                }
            }
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
        heartWidth = DimensionConstants.GRID.get().width;
        heartHeight = DimensionConstants.GRID.get().height;
        panelWidth = 5 * heartWidth;
        panelHeight = heartHeight;

        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(15 * DimensionConstants.GRID.get().width - panelWidth,
                DimensionConstants.GRID.get().height, panelWidth, panelHeight);
    }

    public void addHeart() {
        numberOfHearts++;
        if (numberOfHearts > panelWidth / heartWidth) {
            System.out.println("Heart overflow!");
        }
    }
    public void removeHeart() {
        if (numberOfHearts > 0) {
            numberOfHearts--;
        } else {
            System.out.println("Removed heart when hearts are 0!");
        }
    }
    public int getNumberOfHearts() {
        return numberOfHearts;
    }

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