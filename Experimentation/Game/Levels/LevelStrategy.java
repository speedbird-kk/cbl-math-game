package Experimentation.game.levels;

import Experimentation.core.GameLevelStrategyContext;

public interface LevelStrategy {
    public void setTravelTime(LevelStrategyContext context);

    public void setProductLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext
    );

    public void setQuotientLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext
    );

    public void setSumLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext
    );

    public void setDiffLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext
    );

    public void setScoreMultiplier(LevelStrategyContext levelContext);
}
