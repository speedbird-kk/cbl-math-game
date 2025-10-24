import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;

import Experimentation.view.styles.ApplyStyles;
import Experimentation.view.styles.DimensionConstants;

public class TitleScreenPanel extends JPanel {
    TitleButton titleButton;

    TitleScreenPanel() {
        ApplyStyles.TITLE_SCREEN_STYLE.on(this);
        this.setLayout(null);
        titleButton = new TitleButton();
        this.add(titleButton);
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