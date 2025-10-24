package Experimentation.Components.Lanes;

import Experimentation.Components.Block.Block;
import Experimentation.Components.Block.CreatorStrategy.BlockCreatorStrategy;
import Experimentation.Components.Input.Input;
import Experimentation.Game.Levels.LevelBlockCreatorContext;

public abstract class Lane {
    protected final int operand;
    protected final String operationSymbol;
    protected final LaneType type;
    protected final BlockCreatorStrategy blockCreatorStrategy;
    protected Block currentBlock;
    protected int response;

    protected Lane(int operand, LaneType type, String operationSymbol,
        BlockCreatorStrategy blockCreatorStrategy) {

        this.operand = operand;
        this.type = type;
        this.operationSymbol = operationSymbol;
        this.blockCreatorStrategy = blockCreatorStrategy;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public int getOperand() {
        return operand;
    }

    public LaneType getType() {
        return type;
    }

    public Block createBlock(LevelBlockCreatorContext context) {
        return blockCreatorStrategy.createBlock(context);
    }

    public abstract boolean checkResponse();

    public abstract void parseResponse(Input input);
}