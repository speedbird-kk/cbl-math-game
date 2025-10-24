package Experimentation.components.block.creator;

import Experimentation.components.block.Block;
import Experimentation.game.levels.LevelBlockCreatorContext;

import java.util.List;

public class SumLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleSums = context.getPossibleSums();
        int value = possibleSums.get(
            BlockConstants.getRandom().nextInt(possibleSums.size())
        );
        
        boolean isRed = 
            BlockConstants.getRandom().nextDouble() < BlockConstants.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}
