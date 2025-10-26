import java.awt.Color;

public class GameContext {
    int FPS = 0;
    int state = 0;

    Color titleScreenBackgroundColor = Color.CYAN;
    Color mode1BackgroundColor = Color.WHITE;
    Color squareColor = Color.RED;
    Color laneLabelColor = Color.GREEN;

    int InitialNumberOfHearts = 5;

    double blockTravelTimeS = 17;

    GameContext(double frameWidth, double frameHeight) {}
}
