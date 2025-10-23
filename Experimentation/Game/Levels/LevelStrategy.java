package Experimentation.Game.Levels;

/**
 * Level 1, 2
 * Multiplication lane must only have blocks that are multiples of the multiplicand
 * (up to x10), and all lanes must be such that the correct answer is less than 100
 * 
 * Level 3
 * Multiplication lane can have multiples up to x 12, division lane has correct answer up to 144
 * (ie. 12 x 12 times table)
 * addition and subtraction lanes can have correct answers less than 200.
 * 
 * Level infinity
 * Multiplication lane can have multiples up to x (9 + level)
 * division lane has correct answer up to
 * (9 + level) ^ 2 (ie. (9 + level) x (9 + level) times table)
 * addition and subtraction lanes can have correct answers less than (level - 1) * 100.
 */

public interface LevelStrategy {
    public void setTravelTime(LevelStrategyContext context);

    public void setProductLaneNumbers(LevelStrategyContext context);

    public void setQuotientLaneNumbers(LevelStrategyContext context);

    public void setSumLaneNumbers(LevelStrategyContext context);

    public void setDiffLaneNumbers(LevelStrategyContext context);

    public void setScoreMultiplier(LevelStrategyContext context);
}
