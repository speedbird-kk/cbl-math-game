package Experimentation.view.components;

import Experimentation.view.styles.Style;
import javax.swing.JLabel;

public class LevelLabel extends JLabel {
    public LevelLabel(int level) {
        Style.LEVEL_LABEL.accept(this);
        this.setText("Level " + level);
    }
}