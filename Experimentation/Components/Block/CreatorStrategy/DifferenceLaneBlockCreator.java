package Experimentation.Components.Block.CreatorStrategy;

import Experimentation.Components.Block.Block;
import Experimentation.Game.Levels.LevelBlockCreatorContext;
import java.util.List;

public class DifferenceLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleDifferences = context.getPossibleDifferences();
        int value = possibleDifferences.get(
            BlockCreator.getRandom().nextInt(possibleDifferences.size())
        );
        
        boolean isRed = BlockCreator.getRandom().nextDouble() < BlockCreator.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}