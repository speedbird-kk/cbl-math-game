package Experimentation.view.components;

import Experimentation.view.styles.Style;
import javax.swing.JLabel;

public class ScoreLabel extends JLabel {
    public ScoreLabel(int score) {
        Style.SCORE_LABEL.accept(this);
        this.setText("" + score);
    }
}
