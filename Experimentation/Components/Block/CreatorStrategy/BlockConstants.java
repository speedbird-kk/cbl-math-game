package Experimentation.Components.Block.CreatorStrategy;

import java.util.Random;

/**
 * Constants for block creation strategies.
 * Note that the context of the strategy pattern is the Lane class.
 */
public class BlockConstants {
    private static final double CHANCE_OF_RED_BLOCK = 0.1;
    private static final Random RANDOM = new Random();

    static double getChanceOfRedBlock() {
        return CHANCE_OF_RED_BLOCK;
    }

    static Random getRandom() {
        return RANDOM;
    }
}