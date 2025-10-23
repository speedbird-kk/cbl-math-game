import java.awt.Color;

public class GameContext {
    int FPS = 0;
    int state = 0;

    int screenWidth = 0;
    int screenHeight = 0;
    int tileWidth = 0;
    int tileHeight = 0;

    int titleButtonWidth = 0;
    int titleButtonHeight = 0;

    int laneWidth = 0;
    int laneHeight = 0;
    int textFieldWidth = 0;
    int textFieldHeight = 0;
    int opLabelWidth = 0;
    int opLabelHeight = 0;

    int blockWidth = 0;
    int blockHeight = 0;

    Color titleScreenBackgroundColor = Color.CYAN;
    Color mode1BackgroundColor = Color.WHITE;
    Color squareColor = Color.RED;
    Color laneLabelColor = Color.GREEN;

    int InitialNumberOfHearts = 5;

    int blockTravelDistance = 0;
    int blockTravelTimeS = 20;

    GameContext(double frameWidth, double frameHeight) {
        screenWidth = (int) frameWidth;
        screenHeight = (int) frameHeight;

        tileWidth = (int) frameWidth / 16;
        tileHeight = (int) frameHeight / 9;

        titleButtonWidth = tileWidth * 6;
        titleButtonHeight = tileHeight * 4;

        laneWidth = tileWidth * 2;
        laneHeight = tileHeight * 7;
        textFieldWidth = laneWidth;
        textFieldHeight = (int) (0.75 * tileHeight);
        opLabelWidth = laneWidth;
        opLabelHeight = (int) (0.75 * tileHeight);

        blockWidth = (int) (1.5 * tileWidth);
        blockHeight = (int) (1.5 * tileHeight);

        blockTravelDistance = laneHeight - blockHeight - textFieldHeight - opLabelHeight;
    }
}
