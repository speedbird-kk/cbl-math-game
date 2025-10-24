package Experimentation.game.levels;

import Experimentation.core.GameLevelStrategyContext;

public class LevelHigherStrategy implements LevelStrategy {
    private static int LEVEL;

    public static final int MAX_MULTIPLIER = 12;
    public static final int MAX_ANSWER = 200;
    public static final int TRAVEL_TIME = 12;
    public static final int SCORE_MULTIPLIER = LEVEL * 100;

    LevelHigherStrategy(int level) {
        LEVEL = level;
    }

    @Override
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
    public void setScoreMultiplier(LevelStrategyContext levelContext) {
        levelContext.setScoreMultiplier(SCORE_MULTIPLIER);
    }
}
