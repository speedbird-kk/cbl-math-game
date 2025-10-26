package Experimentation.game.levels;

import java.util.ArrayList;
import java.util.List;

import Experimentation.core.GameLevelStrategyContext;

/**
 * Level 1.
 * Multiplication lane must only have blocks that are multiples of the multiplicand
 * (up to x10), and all lanes must be such that the correct answer is less than 100
 */

public class LevelOneStrategy implements LevelStrategy {
    public static final int MAX_MULTIPLIER = 10;
    public static final int MAX_ANSWER = 100;
    public static final int TRAVEL_TIME_MS = 10_000;
    public static final int SCORE_MULTIPLIER = 100;

    @Override
    public void setTravelTime(LevelStrategyContext context) {
        context.setTravelTime(TRAVEL_TIME_MS);
    }

    @Override
    public void setProductLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {
        
        List<Integer> possibleProducts = new ArrayList<>();
        int multiplicand = gameContext.getLanes().productLane().getOperand();

        for (int i = 1; i < 11; i++) {
            possibleProducts.add(multiplicand * i);
        }

        levelContext.setPossibleProducts(possibleProducts);
    }

    @Override
    public void setQuotientLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {
        
        List<Integer> possibleQuotients = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            possibleQuotients.add(i);
        }

        levelContext.setPossibleQuotients(possibleQuotients);
    }

    @Override
    public void setSumLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {
        
        List<Integer> possibleSums = new ArrayList<>();
        int summand = gameContext.getLanes().sumLane().getOperand();

        for (int i = summand; i < MAX_ANSWER - summand; i++) {
            possibleSums.add(i);
        }

        levelContext.setPossibleSums(possibleSums);
    }

    @Override
    public void setDiffLaneNumbers(
        LevelStrategyContext levelContext, GameLevelStrategyContext gameContext) {
        
        List<Integer> possibleDifferences = new ArrayList<>();
        int subtrahend = gameContext.getLanes().differenceLane().getOperand();

        for (int i = 1; i < MAX_ANSWER - subtrahend; i++) {
            possibleDifferences.add(i);
        }

        levelContext.setPossibleDifferences(possibleDifferences);
    }

    @Override
    public void setScoreMultiplier(LevelStrategyContext levelContext) {
        levelContext.setScoreMultiplier(SCORE_MULTIPLIER);
    }
}
