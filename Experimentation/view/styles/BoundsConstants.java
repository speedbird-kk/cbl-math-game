package Experimentation.view.styles;

import java.awt.Rectangle;

public enum BoundsConstants {
    BLOCK_BOUNDS(new Rectangle(
        (DimensionConstants.LANE.get().width
            - DimensionConstants.BLOCK.get().width) / 2,

        0,
        DimensionConstants.BLOCK.get().width,
        DimensionConstants.BLOCK.get().height
    ));

    private Rectangle bounds;

    BoundsConstants(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle get() {
        return bounds;
    }
}
