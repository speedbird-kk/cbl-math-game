package Experimentation.components.block.creator;

import Experimentation.components.block.Block;
import Experimentation.game.levels.LevelBlockCreatorContext;

import java.util.List;

public class DifferenceLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleDifferences = context.getPossibleDifferences();
        int value = possibleDifferences.get(
            BlockConstants.getRandom().nextInt(possibleDifferences.size())
        );
        
        boolean isRed =
            BlockConstants.getRandom().nextDouble() < BlockConstants.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}