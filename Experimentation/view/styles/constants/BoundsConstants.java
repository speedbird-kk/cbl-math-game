package Experimentation.view.styles.constants;

import java.awt.Rectangle;

public enum BoundsConstants {
    BLOCK_BOUNDS(new Rectangle(
        (DimensionConstants.LANE.get().width
            - DimensionConstants.BLOCK.get().width) / 2,

        -DimensionConstants.BLOCK.get().height,
        DimensionConstants.BLOCK.get().width,
        DimensionConstants.BLOCK.get().height
    )),

    SCORE_LABEL_BOUNDS(new Rectangle(
        12 * LengthConstants.GRID_WIDTH.get(),
        2 * LengthConstants.GRID_HEIGHT.get(),
        DimensionConstants.SCORE_LABEL.get().width,
        DimensionConstants.SCORE_LABEL.get().height
    )),

    LEVEL_LABEL_BOUNDS(new Rectangle(
        12 * LengthConstants.GRID_WIDTH.get(),
        3 * LengthConstants.GRID_HEIGHT.get(),
        DimensionConstants.LEVEL_LABEL.get().width,
        DimensionConstants.LEVEL_LABEL.get().height
    )),
    
    INPUT_TEXTFIELD_BOUNDS(new Rectangle(
        0,
        25 * LengthConstants.GRID_HEIGHT.get() / 4,
        DimensionConstants.LANE.get().width,
        3 * LengthConstants.GRID_HEIGHT.get() / 4
    )),

    TUTORIAL_TEXTAREA_BOUNDS(new Rectangle(
        DimensionConstants.GRID.get().width * 4,
        DimensionConstants.GRID.get().height * 5,
        DimensionConstants.GRID.get().width * 8,
        DimensionConstants.GRID.get().height * 3
    ));

    private Rectangle bounds;

    BoundsConstants(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle get() {
        return bounds;
    }
}
