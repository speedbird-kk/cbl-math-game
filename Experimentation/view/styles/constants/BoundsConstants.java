package Experimentation.view.styles.constants;

import java.awt.Rectangle;

public enum BoundsConstants {
    BLOCK_BOUNDS(new Rectangle(
        (DimensionConstants.LANE.get().width
            - DimensionConstants.BLOCK.get().width) / 2,

        0,
        DimensionConstants.BLOCK.get().width,
        DimensionConstants.BLOCK.get().height
    )),
    SCORE_LABEL_BOUNDS(new Rectangle(
        12 * LengthConstants.GRID_WIDTH.get(),
        2 * LengthConstants.GRID_HEIGHT.get(),
        DimensionConstants.SCORE_LABEL.get().width,
        DimensionConstants.SCORE_LABEL.get().height
    ));

    private Rectangle bounds;

    BoundsConstants(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle get() {
        return bounds;
    }
}
