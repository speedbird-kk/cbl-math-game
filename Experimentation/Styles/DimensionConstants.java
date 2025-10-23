package Experimentation.Styles;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

public enum DimensionConstants {
    SCREEN_SIZE(screenSize()),
    FRAME(new Dimension(
        (int) SCREEN_SIZE.get().getWidth() / 2,
        (int) SCREEN_SIZE.get().getHeight() / 2
    )),
    GRID(new Dimension(
        (int) FRAME.get().getWidth() / 16,
        (int) FRAME.get().getHeight() / 9
    ));
    
    private Dimension dimension;
    
    private DimensionConstants(Dimension dimension) {
        this.dimension = dimension;
    }

    private static Dimension screenSize() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize();
        } catch (HeadlessException e) {
            return new Dimension(1920, 1080);
        }
    }

    public Dimension get() {
        return new Dimension(dimension);
    }
}
