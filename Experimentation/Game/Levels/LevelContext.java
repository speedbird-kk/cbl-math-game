package Experimentation.Game.Levels;

import Experimentation.Components.Lanes.Lane;
import java.util.List;

public class LevelContext implements LevelStrategyContext {
    private LevelStrategy strategy;
    private int travelTime;
    private List<Integer> possibleProducts;
    private List<Integer> possibleQuotients;
    private List<Integer> possibleSums;
    private List<Integer> possibleDifferences;
    private int scoreMultiplier;

    // LevelContext needs to know Lanes
    // Should have LaneFactory create the 4 lanes ?

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public void setPossibleProducts(List<Integer> possibleProducts) {
        this.possibleProducts = possibleProducts;
    }

    public void setPossibleQuotients(List<Integer> possibleQuotients) {
        this.possibleQuotients = possibleQuotients;
    }

    public void setPossibleSums(List<Integer> possibleSums) {
        this.possibleSums = possibleSums;
    }

    public void setPossibleDifferences(List<Integer> possibleDifferences) {
        this.possibleDifferences = possibleDifferences;
    }

    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }
}
