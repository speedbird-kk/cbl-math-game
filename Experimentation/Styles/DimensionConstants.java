package Experimentation.Styles;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

public enum DimensionConstants {
    SCREEN_SIZE(screenSize()),
    FRAME(new Dimension(
        SCREEN_SIZE.get().width / 2,
        SCREEN_SIZE.get().height / 2
    )),
    GRID(new Dimension(
        FRAME.get().width / 16,
        FRAME.get().height / 9
    )),
    TITLE_BUTTON(new Dimension(
        GRID.get().width * 6,
        GRID.get().height * 4
    )),
    LANE(new Dimension(
        GRID.get().width * 2,
        GRID.get().height * 7
    )),
    TEXT_FIELD(new Dimension(
        LANE.get().width,
        (int) (GRID.get().height * 0.75)
    )),
    OP_LABEL(new Dimension(
        LANE.get().width,
        (int) (GRID.get().height * 0.75)
    )),
    BLOCK(new Dimension(
        (int) (GRID.get().width * 1.5),
        (int) (GRID.get().height * 1.5)
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
