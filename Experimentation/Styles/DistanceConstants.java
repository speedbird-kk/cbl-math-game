package Experimentation.Styles;

import Experimentation.Styles.DimensionConstants;

public enum DistanceConstants {
    BLOCK_TRAVEL_DISTANCE(DimensionConstants.LANE.get().height
            - DimensionConstants.BLOCK.get().height - DimensionConstants.TEXT_FIELD.get().height
            - DimensionConstants.OP_LABEL.get().height);

    int distance;
    private DistanceConstants(int distance) {
        this.distance = distance;
    }
    public int get() {
        return distance;
    }
}
