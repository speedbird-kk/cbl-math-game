package Experimentation.Components.Block.CreatorStrategy;

import Experimentation.Components.Block.Block;
import Experimentation.Components.Lanes.Lane;
import Experimentation.Game.Levels.LevelBlockCreatorContext;

public interface BlockCreatorStrategy {
    public Block createBlock(Lane lane, LevelBlockCreatorContext context);
}