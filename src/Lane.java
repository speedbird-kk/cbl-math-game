import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lane extends JPanel {
    int tileWidth;
    int tileHeight;

    JLabel label;
    JTextField textField;

    Lane(int x, int y, int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
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

    public void timeUpdate(int timeElapsedMs) {}
}
