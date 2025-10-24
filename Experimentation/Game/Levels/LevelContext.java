package Experimentation.Game.Levels;

import Experimentation.Components.Lanes.Lane;
import java.util.List;

public class LevelContext implements LevelStrategyContext, LevelBlockCreatorContext {
    private LevelStrategy strategy;
    private int travelTime;
    private List<Integer> possibleProducts;
    private List<Integer> possibleQuotients;
    private List<Integer> possibleSums;
    private List<Integer> possibleDifferences;
    private int scoreMultiplier;

    public void setStrategy(LevelStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public void setPossibleProducts(List<Integer> possibleProducts) {
        this.possibleProducts = possibleProducts;
    }

    @Override
    public void setPossibleQuotients(List<Integer> possibleQuotients) {
        this.possibleQuotients = possibleQuotients;
    }

    @Override
    public void setPossibleSums(List<Integer> possibleSums) {
        this.possibleSums = possibleSums;
    }

    @Override
    public void setPossibleDifferences(List<Integer> possibleDifferences) {
        this.possibleDifferences = possibleDifferences;
    }

    @Override
    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    @Override
    public List<Integer> getPossibleProducts() {
        return possibleProducts;
    }

    @Override
    public List<Integer> getPossibleQuotients() {
        return possibleQuotients;
    }

    @Override
    public List<Integer> getPossibleSums() {
        return possibleSums;
    }

    @Override
    public List<Integer> getPossibleDifferences() {
        return possibleDifferences;
    }
}
