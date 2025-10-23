package Experimentation.Game.Levels;

import Experimentation.Game.GameLevelStrategyContext;

/**
 * Level 1.
 * Multiplication lane must only have blocks that are multiples of the multiplicand
 * (up to x10), and all lanes must be such that the correct answer is less than 100
 */

public class LevelOneStrategy implements LevelStrategy {
    public static final int MAX_MULTIPLIER = 10;
    public static final int MAX_ANSWER = 100;
    public static final int TRAVEL_TIME = 20;

    public void setTravelTime(LevelStrategyContext context) {
        context.setTravelTime(TRAVEL_TIME);
    }

    @Override
    public void setProductLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {

    }

    @Override
    public void setQuotientLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {

    }

    @Override
    public void setSumLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {

    }

    @Override
    public void setDiffLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {

    }

    @Override
    public void setScoreMultiplier(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {

    }
}
