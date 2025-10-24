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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Experimentation.Styles.ApplyStyles;
import Experimentation.Styles.DimensionConstants;
import Experimentation.Styles.DistanceConstants;

public class Lane extends JPanel {
    GameContext gameContext;
    int tileWidth;
    int tileHeight;
    int amount;

    JLabel operand;
    JTextField inputField;

    ArrayDeque<Block> blocks = new ArrayDeque<Block>();
    ArrayDeque<Integer> submissions = new ArrayDeque<Integer>();

    Lane(int x, int y,int amount, GameContext gameContext) {
        this.gameContext = gameContext;
        int tileWidth = DimensionConstants.GRID.get().width;
        int tileHeight = DimensionConstants.GRID.get().height;
        this.setBounds(
                x, y, DimensionConstants.LANE.get().width, DimensionConstants.LANE.get().height);

        ApplyStyles.LANE_STYLE.on(this);

        this.setLayout(null);

        this.operand = new JLabel();
        operand.setBounds(0, (int) (5.5 * tileHeight), DimensionConstants.OP_LABEL.get().width,
                DimensionConstants.OP_LABEL.get().height);

        // center horizontally
        operand.setHorizontalAlignment(SwingConstants.CENTER);
        // center vertically
        operand.setVerticalAlignment(SwingConstants.CENTER);

        ApplyStyles.OPERAND_STYLE.on(operand);
        setOpAmount(amount);
        this.add(operand);

        inputField = new JTextField("hell0");
        inputField.setFocusTraversalKeysEnabled(false);
        inputField.setBounds(
                0, (int) (6.25 * tileHeight), this.getWidth(), (int) (0.75 * tileHeight));
        
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int textFieldNumber = Integer.parseInt(inputField.getText().trim());
                    addSolution(textFieldNumber);
                    inputField.setText("");
                    System.out.println("Number set to: " + textFieldNumber);
                } catch (NumberFormatException ex) {
                    System.out.println("Not a valid number!");
                }
            }
        });
        // Makes it so that when you focus the text field it highlights the text inside
        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Schedule on the event queue so it happens *after* focus is officially set
                SwingUtilities.invokeLater(() -> inputField.selectAll());
            }
        });
        ApplyStyles.INPUT_STYLE.on(inputField);
        this.add(inputField);
    }

    public void addSolution(int n){
        submissions.add(n);
    }
    public void setOpAmount(int amount){
        this.amount = amount;
        operand.setText("" + amount);

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
class AdditionLane extends Lane{
    AdditionLane(int x, int y, int amount, GameContext gameContext) {
        super(x, y, amount, gameContext);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void addSolution(int n){
        submissions.add(n + super.amount);
    }
    @Override
    public void setOpAmount(int amount){
        super.amount = amount;
        operand.setText("+" + super.amount);
    }
}
class SubtractionLane extends Lane{
    SubtractionLane(int x, int y, int amount, GameContext gameContext) {
        super(x, y, amount, gameContext);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void addSolution(int n){
        submissions.add(n - super.amount);
    }
    @Override
    public void setOpAmount(int amount){
        super.amount = amount;
        operand.setText("-" + super.amount);
    }
}
class MultiplicationLane extends Lane{
    MultiplicationLane(int x, int y, int amount, GameContext gameContext) {
        super(x, y, amount, gameContext);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void addSolution(int n){
        submissions.add(n * super.amount);
    }
    @Override
    public void setOpAmount(int amount){
        super.amount = amount;
        operand.setText("×" + super.amount);
    }
}
class DivisionLane extends Lane{
    DivisionLane(int x, int y, int amount, GameContext gameContext) {
        super(x, y, amount, gameContext);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void addSolution(int n){
        submissions.add(n / super.amount);
    }
    @Override
    public void setOpAmount(int amount){
        super.amount = amount;
        operand.setText("÷" + super.amount);
    }
}

class Block extends JPanel {
    double y;
    int x;
    int number;
    JLabel label;

    Block(int number, GameContext GC) {
        ApplyStyles.BLOCK_MAIN_STYLE.on(this);
        this.number = number;
        label = new JLabel("" + number);
        label.setForeground(this.getForeground());
        this.setLayout(new BorderLayout());
        // center horizontally
        label.setHorizontalAlignment(SwingConstants.CENTER);
        // center vertically
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont((float) 0.3 * DimensionConstants.BLOCK.get().height));
        this.add(label, BorderLayout.CENTER);

        x = (DimensionConstants.LANE.get().width - DimensionConstants.BLOCK.get().width) / 2;
        y = 0;
        this.setBounds(x, (int) y, DimensionConstants.BLOCK.get().width,DimensionConstants.BLOCK.get().height);
    }
    public void timeUpdate(int t, GameContext GC) {
        double blockSpeed = (double) DistanceConstants.BLOCK_TRAVEL_DISTANCE.get() / (double) GC.blockTravelTimeS;
        y += blockSpeed * t / 1000.0;

        this.setLocation(this.x, (int) y);
    }
}

