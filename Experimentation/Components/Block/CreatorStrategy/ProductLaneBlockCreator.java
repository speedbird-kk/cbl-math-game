package Experimentation.Components.Block.CreatorStrategy;

import Experimentation.Components.Block.Block;
import Experimentation.Game.Levels.LevelBlockCreatorContext;
import java.util.List;

public class ProductLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleProducts = context.getPossibleProducts();
        int value = possibleProducts.get(
            BlockCreator.getRandom().nextInt(possibleProducts.size())
        );
        
        boolean isRed = BlockCreator.getRandom().nextDouble() < BlockCreator.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}