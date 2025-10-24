package Experimentation.Components.Block.CreatorStrategy;

import Experimentation.Components.Block.Block;
import Experimentation.Game.Levels.LevelBlockCreatorContext;
import java.util.List;

public class SumLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleSums = context.getPossibleSums();
        int value = possibleSums.get(
            BlockCreator.getRandom().nextInt(possibleSums.size())
        );
        
        boolean isRed = BlockCreator.getRandom().nextDouble() < BlockCreator.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}
