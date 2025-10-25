package Experimentation.view.styles.constants;

public enum LengthConstants {
    BLOCK_TRAVEL_DISTANCE(DimensionConstants.LANE.get().height
            - DimensionConstants.BLOCK.get().height - DimensionConstants.TEXT_FIELD.get().height
            - DimensionConstants.OPERAND_LABEL.get().height),
    
    GRID_WIDTH(DimensionConstants.GRID.get().width),
    GRID_HEIGHT(DimensionConstants.GRID.get().height);


    int length;

    private LengthConstants(int length) {
        this.length = length;
    }

    public int get() {
        return length;
    }
}
