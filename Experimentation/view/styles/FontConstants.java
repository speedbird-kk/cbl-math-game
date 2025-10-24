package Experimentation.view.styles;

import java.awt.Font;

public enum FontConstants {
    BLOCK_LABEL(new Font("Arial", Font.BOLD, 1)),
    OPERAND_LABEL(new Font("Arial", Font.BOLD, 1));

    private Font font;

    FontConstants(Font font) {
        this.font = font;
    }

    public Font get() {
        return font;
    }
}
