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

import Experimentation.view.styles.ApplyStyles;
import Experimentation.view.styles.DimensionConstants;

public class TitleScreenPanel extends JPanel {
    TitleButton titleButton;
    JTextArea tutorialText;

    TitleScreenPanel() {
        ApplyStyles.TITLE_SCREEN_STYLE.on(this);
        this.setLayout(null);
        titleButton = new TitleButton();
        this.add(titleButton);
        tutorialText = new JTextArea();
        tutorialText.setWrapStyleWord(true);
        tutorialText.setLineWrap(true);
        tutorialText.setEditable(false);
        tutorialText.setFocusable(false);
        tutorialText.setBounds(DimensionConstants.GRID.get().width*4,DimensionConstants.GRID.get().height*5,DimensionConstants.GRID.get().width*8,DimensionConstants.GRID.get().height*3);
        tutorialText.setOpaque(false);
        tutorialText.setFont(UIManager.getFont("Label.font"));
        tutorialText.setForeground(Color.WHITE);
        tutorialText.setText( 
        "Welcome to the game!\n"+
        "There are 4 lanes, on each lane blocks with numbers will start falling.\n"+
        "In order to destroy a block look at the operation on the coresponding lane and enter a number that, after the operation is applied to it, results in the number on the block.\n"+
        "If a block reaches the bottom of the lane you lose a heart, when you lose all of your hearts you lose the game.\n"+
        "As you progress the level increases and the game gets harder.\n"+
        "use TAB to quickly switch to lanes that have blocks.\n"
        );

        this.add(tutorialText);



    }
    public void timeUpdate(int t) {
        titleButton.timeUpdate(t);
    }
}
class TitleButton extends JButton {
    long animationTime = 0;
    boolean isPressed = false;
    int tileWidth = DimensionConstants.GRID.get().width;
    int tileHeight = DimensionConstants.GRID.get().height;

    TitleButton() {
        this.setBounds(tileWidth * 6, tileHeight * 0, DimensionConstants.TITLE_BUTTON.get().width,
                DimensionConstants.TITLE_BUTTON.get().height);
        this.setFocusable(false);
        this.setText("Play");
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
        int newY = 5 * tileHeight / 2 - newHeight / 2;
        
        this.setFont(this.getFont().deriveFont((float)(newHeight*0.5)));

        this.setBounds(newX, newY, newWidth, newHeight);
    }
}