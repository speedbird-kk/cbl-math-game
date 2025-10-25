package Experimentation.game.levels;

import java.util.List;

/**
 * Interface exposing only what is necessary of the context for level strategies.
 */
public sealed interface LevelStrategyContext permits LevelContext {
    public void setTravelTime(int travelTime);

    public void setCurrentLevel(int currentLevel);

    public void setPossibleProducts(List<Integer> possibleProducts);

    public void setPossibleQuotients(List<Integer> possibleQuotients);

    public void setPossibleSums(List<Integer> possibleSums);

    public void setPossibleDifferences(List<Integer> possibleDifferences);

    public void setScoreMultiplier(int scoreMultiplier);
}