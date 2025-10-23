import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Experimentation.Styles.DimensionConstants;
import Experimentation.Styles.DistanceConstants;

public class Lane extends JPanel {
    GameContext gameContext;
    int tileWidth;
    int tileHeight;

    JLabel label;
    JTextField textField;

    ArrayDeque<Block> blocks = new ArrayDeque<Block>();
    ArrayDeque<Integer> submissions = new ArrayDeque<Integer>();

    Lane(int x, int y, GameContext gameContext) {
        this.gameContext = gameContext;
        int tileWidth = DimensionConstants.GRID.get().width;
        int tileHeight = DimensionConstants.GRID.get().height;
        this.setBounds(
                x, y, DimensionConstants.LANE.get().width, DimensionConstants.LANE.get().height);
        this.setBackground(Color.BLUE);
        this.setLayout(null);

        this.label = new JLabel("Hi");
        label.setBounds(0, (int) (5.5 * tileHeight), DimensionConstants.OP_LABEL.get().width,
                DimensionConstants.OP_LABEL.get().height);
        label.setOpaque(true);
        label.setBackground(gameContext.laneLabelColor);
        this.add(label);

        textField = new JTextField("hell0");
        textField.setFocusTraversalKeysEnabled(false);
        textField.setBounds(
                0, (int) (6.25 * tileHeight), this.getWidth(), (int) (0.75 * tileHeight));
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int textFieldNumber = Integer.parseInt(textField.getText().trim());
                    submissions.add(textFieldNumber);
                    textField.setText("");
                    System.out.println("Number set to: " + textFieldNumber);
                } catch (NumberFormatException ex) {
                    System.out.println("Not a valid number!");
                }
            }
        });
        // Makes it so that when you focus the text field it highlights the text inside
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Schedule on the event queue so it happens *after* focus is officially set
                SwingUtilities.invokeLater(() -> textField.selectAll());
            }
        });
        this.add(textField);
    }
    public void addBlock(int number) {
        Block block = new Block(number, gameContext);
        blocks.add(block);
        this.add(block);
    }
    public void removeBlock(Block block) {
        blocks.remove(block);
        this.remove(block);
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
    int number;
    JLabel label;

    Block(int number, GameContext GC) {
        this.number = number;
        label = new JLabel("" + number);
        this.add(label, BorderLayout.CENTER);

        x = (DimensionConstants.LANE.get().width - DimensionConstants.BLOCK.get().width) / 2;
        y = 0;
        this.setBounds(x, (int) y, DimensionConstants.BLOCK.get().width,DimensionConstants.BLOCK.get().height);
        this.setBackground(GC.squareColor);
    }
    public void timeUpdate(int t, GameContext GC) {
        double blockSpeed = (double) DistanceConstants.BLOCK_TRAVEL_DISTANCE.get() / (double) GC.blockTravelTimeS;
        y += blockSpeed * t / 1000.0;

        this.setLocation(this.x, (int) y);
    }
}