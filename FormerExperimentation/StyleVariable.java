package Experimentation;

import java.awt.*;

/**
 * Colour and fonts styling variables.
 */
public enum StyleVariable {
    MAIN_BG_COLOUR(new Color(240, 220, 220)),
    MAIN_BTN_COLOUR(new Color(230, 20, 88)),

    MAIN_FONT(new Font("Futura", Font.ITALIC, 30));
    
    private Color rgbColour;
    private Font font;

    private StyleVariable(Color rgbColour) {
        this.rgbColour = rgbColour;
    }

    private StyleVariable(Font font) {
        this.font = font;
    }

    public Color colour() {
        return rgbColour;
    }

    public Font font() {
        return font;
    }
}