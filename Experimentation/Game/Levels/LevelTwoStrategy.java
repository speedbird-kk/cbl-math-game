package Experimentation.Game.Levels;

import Experimentation.Game.GameLevelStrategyContext;

public class LevelTwoStrategy implements LevelStrategy {
    public static final int MAX_MULTIPLIER = 10;
    public static final int MAX_ANSWER = 100;
    public static final int TRAVEL_TIME = 15;
    public static final int SCORE_MULTIPLIER = 200;

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
