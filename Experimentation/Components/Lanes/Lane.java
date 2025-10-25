package Experimentation.components.lanes;

import Experimentation.components.block.Block;
import Experimentation.components.block.creator.BlockCreatorStrategy;
import Experimentation.components.input.Input;
import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.events.BlockCreatedEvent;
import Experimentation.game.levels.LevelBlockCreatorContext;

public abstract class Lane implements LaneState {
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

    @Override
    public int getOperand() {
        return operand;
    }

    public LaneType getType() {
        return type;
    }

    @Override
    @Publishes(event = BlockCreatedEvent.class)
    public Block createBlock(LevelBlockCreatorContext context) {
        Block newBlock = blockCreatorStrategy.createBlock(context);
        EventBroker.getInstance().publish(new BlockCreatedEvent(newBlock, type));

        return newBlock;
    }

    @Override
    public abstract boolean checkResponse();

    public abstract void parseResponse(Input input);
}