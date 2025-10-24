package Experimentation.components.block.creator;

import Experimentation.components.block.Block;
import Experimentation.game.levels.LevelBlockCreatorContext;

import java.util.List;

public class ProductLaneBlockCreator implements BlockCreatorStrategy {
    @Override
    public Block createBlock(LevelBlockCreatorContext context) {
        List<Integer> possibleProducts = context.getPossibleProducts();
        int value = possibleProducts.get(
            BlockConstants.getRandom().nextInt(possibleProducts.size())
        );

        boolean isRed =
            BlockConstants.getRandom().nextDouble() < BlockConstants.getChanceOfRedBlock();

        return new Block(value, isRed);
    }
}