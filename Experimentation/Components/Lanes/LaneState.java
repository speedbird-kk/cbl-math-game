package Experimentation.components.lanes;

import Experimentation.components.block.Block;
import Experimentation.game.levels.LevelBlockCreatorContext;

public interface LaneState {
    public int getOperand();

    public Block createBlock(LevelBlockCreatorContext context);

    public abstract boolean checkResponse();
}
