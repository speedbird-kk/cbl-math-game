package Experimentation.components.block.creator;

import Experimentation.components.block.Block;
import Experimentation.game.levels.LevelBlockCreatorContext;

public interface BlockCreatorStrategy {
    public Block createBlock(LevelBlockCreatorContext context);
}