package Experimentation.Components.Block.CreatorStrategy;

import Experimentation.Game.Levels.LevelBlockCreatorContext;
import java.util.Random;

public class BlockCreator {
    private static final double CHANCE_OF_RED_BLOCK = 0.1;
    private static final Random RANDOM = new Random();
    private LevelBlockCreatorContext context;
    private BlockCreatorStrategy strategy;

    public BlockCreator(BlockCreatorStrategy strategy) {
        this.strategy = strategy;
    }

    static double getChanceOfRedBlock() {
        return CHANCE_OF_RED_BLOCK;
    }

    static Random getRandom() {
        return RANDOM;
    }
}
