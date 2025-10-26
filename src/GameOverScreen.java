import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import Experimentation.view.styles.constants.DimensionConstants;

public class GameOverScreen extends JPanel {
    ReturnToMenuButton returnToMenuButton;
    JTextArea tutorialText;

    GameOverScreen() {
        ApplyStyles.TITLE_SCREEN_STYLE.on(this);
        this.setLayout(null);
        returnToMenuButton = new ReturnToMenuButton();
        this.add(returnToMenuButton);
        tutorialText = new JTextArea();
        tutorialText.setWrapStyleWord(true);
        tutorialText.setLineWrap(true);
        tutorialText.setEditable(false);
        tutorialText.setFocusable(false);
        tutorialText.setBounds(DimensionConstants.GRID.get().width*4,DimensionConstants.GRID.get().height*3,DimensionConstants.GRID.get().width*8,DimensionConstants.GRID.get().height*3);
        tutorialText.setOpaque(false);
        tutorialText.setFont(UIManager.getFont("Label.font"));
        tutorialText.setFont(this.getFont().deriveFont((float)(DimensionConstants.GRID.get().height*1.3)));
        tutorialText.setForeground(Color.WHITE);
        tutorialText.setText("Game Over!");

        this.add(tutorialText);



    }
    public void timeUpdate(int t) {
        returnToMenuButton.timeUpdate(t);
    }
}
class ReturnToMenuButton extends JButton {
    long animationTime = 0;
    boolean isPressed = false;
    int tileWidth = DimensionConstants.GRID.get().width;
    int tileHeight = DimensionConstants.GRID.get().height;

    ReturnToMenuButton() {
        this.setBounds(tileWidth * 6, tileHeight * 0, DimensionConstants.TITLE_BUTTON.get().width,
                DimensionConstants.TITLE_BUTTON.get().height);
        this.setFocusable(false);
        this.setText("Return to title screen");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPressed = true;
                // TODO Auto-generated method stub
            }
        });
    }
    public void timeUpdate(int t) {
        animationTime += t;
        double angle = (animationTime % 2000) / 2000.0 * 2 * Math.PI;
        double sinT = Math.sin(angle);
        int newWidth = tileWidth * 4 + (int) (tileWidth / 2 * sinT);
        int newHeight = tileHeight + (int) (tileHeight / 4 * sinT);
        int newX = 16 * tileWidth / 2 - newWidth / 2;
        int newY = 14 * tileHeight / 2 - newHeight / 2;
        
        this.setFont(this.getFont().deriveFont((float)(newHeight*0.3)));

        this.setBounds(newX, newY, newWidth, newHeight);
    }
}