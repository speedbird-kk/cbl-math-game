package Experimentation.view.styles.constants;

import java.awt.Color;

public enum ColourConstants {
    TITLE_SCREEN_BACKGROUND(new Color(0, 60, 180)),
    MODE_ONE_BACKGROUND(new Color(255, 255, 255)),
    BLOCK_MAIN(new Color(16, 72, 98)),
    BLOCK_RED(new Color(240, 0, 20)),
    LANE_BACKGROUND(new Color(217, 217, 217)),
    LANE_BORDER(new Color(0, 0, 0)),
    OPERAND_BACKGROUND(new Color(4, 36, 51)),
    INPUT_BACKGROUND(new Color(220, 234, 247)),
    INPUT_BACKGROUND_WRONG(new Color(220, 0, 20)),
    SCORE_BACKGROUND_COLOR(new Color(16, 72, 98)),
    LEVEL_BACKGROUND_COLOR(new Color(16, 72, 98));
    

    private Color colour;

    private ColourConstants(Color colour) {
        this.colour = colour;
    }

    public Color get() {
        return colour;
    }
}