package Experimentation.Game.Levels;

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

    public void setProductLaneNumbers(LevelStrategyContext context) {
        
    }

    public void setQuotientLaneNumbers(LevelStrategyContext context);

    public void setSumLaneNumbers(LevelStrategyContext context);

    public void setDiffLaneNumbers(LevelStrategyContext context);

    public void setScoreMultiplier(LevelStrategyContext context);
}
