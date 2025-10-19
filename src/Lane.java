import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lane extends JPanel {
    GameContext gameContext;
    int tileWidth;
    int tileHeight;

    JLabel label;
    JTextField textField;

    ArrayDeque<Block> blocks = new ArrayDeque<Block>();

    Lane(int x, int y, GameContext gameContext) {
        this.gameContext = gameContext;
        int tileWidth = gameContext.tileWidth;
        int tileHeight = gameContext.tileHeight;
        this.setBounds(x, y, tileWidth * 2, tileHeight * 7);
        this.setBackground(Color.BLUE);
        this.setLayout(null);

        this.label = new JLabel("Hi");
        label.setBounds(0, (int) (5.5 * tileHeight), this.getWidth(), (int) (0.75 * tileHeight));
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        this.add(label);

        this.textField = new JTextField("hell0");
        textField.setBounds(
                0, (int) (6.25 * tileHeight), this.getWidth(), (int) (0.75 * tileHeight));
        this.add(textField);
    }
    public void addBlock() {
        Block block = new Block(gameContext);
        blocks.add(block);
        this.add(block);
    }

    public void timeUpdate(int timeElapsedMs, GameContext GC) {
        for (Block block : blocks) {
            block.timeUpdate(timeElapsedMs, GC);
        }
    }
}

class Block extends JPanel {
    double y;
    int x;

    Block(GameContext GC) {
        x = (GC.laneWidth - GC.blockWidth) / 2;
        y = 0;
        this.setBounds(x, (int) y, GC.blockWidth, GC.blockHeight);
        this.setBackground(Color.RED);
    }
    public void timeUpdate(int t, GameContext GC) {
        double blockSpeed = (double) GC.blockTravelDistance / GC.blockTravelTimeS;
        y += (double) blockSpeed * t / 1000;
        System.out.println(y);

        this.setLocation(this.x, (int) y);
    }
}