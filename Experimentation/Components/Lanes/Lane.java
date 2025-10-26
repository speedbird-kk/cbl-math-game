package Experimentation.components.lanes;

import Experimentation.components.block.Block;
import Experimentation.components.block.creator.BlockCreatorStrategy;
import Experimentation.components.input.Input;
import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.events.BlockCreatedEvent;
import Experimentation.core.events.CorrectResponseEvent;
import Experimentation.core.events.GameOverEvent;
import Experimentation.core.events.WrongResponseEvent;
import Experimentation.game.levels.LevelBlockCreatorContext;
import Experimentation.game.levels.LevelScoringContext;

public abstract class Lane implements LaneState {
    protected final int operand;
    protected final String operationSymbol;
    protected final LaneType type;
    protected final BlockCreatorStrategy blockCreatorStrategy; 
    protected LevelScoringContext levelScoringContext;
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

    /**
     * Check response and then publish event.
     */
    public void afterResponseChecked() {
        if (checkResponse()) {
            publishCorrect();
        } else {
            if (currentBlock.getIsRed()) {
                publishGameOver();
            } else {
                publishWrong();
            }
        }
    }

    /**
     * .=== Getters ===.
     */
    // region getters
    public int getOperand() {
        return operand;
    }

    public LaneType getType() {
        return type;
    }
    //endregion

    /**
     * .=== Publishing methods ===.
     */
    // region publishers
    @Publishes(event = WrongResponseEvent.class)
    private void publishWrong() {
        EventBroker.getInstance().publish(new WrongResponseEvent(currentBlock));
    }

    @Publishes(event = GameOverEvent.class)
    private void publishGameOver() {
        EventBroker.getInstance().publish(new GameOverEvent());
    }
    
    @Publishes(event = CorrectResponseEvent.class)
    private void publishCorrect() {
        EventBroker.getInstance().publish(
            new CorrectResponseEvent(currentBlock, levelScoringContext));
    }

    @Override
    @Publishes(event = BlockCreatedEvent.class)
    public Block createBlock(LevelBlockCreatorContext context) {
        Block newBlock = blockCreatorStrategy.createBlock(context);
        currentBlock = newBlock;
        EventBroker.getInstance().publish(new BlockCreatedEvent(newBlock, type));

        return newBlock;
    }
    // endregion

    /**
     * .=== Abstract methods ===.
     */
    // region abstract methods
    public abstract boolean checkResponse();

    public abstract void parseResponse(Input input);
    // endregion
}