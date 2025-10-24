package Experimentation.Components.Block.CreatorStrategy;

import Experimentation.Components.Block.Block;
import Experimentation.Game.Levels.LevelBlockCreatorContext;
import java.util.List;

public class QuotientLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleQuotients = context.getPossibleQuotients();
        int value = possibleQuotients.get(
            BlockConstants.getRandom().nextInt(possibleQuotients.size())
        );

        boolean isRed =
            BlockConstants.getRandom().nextDouble() < BlockConstants.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}