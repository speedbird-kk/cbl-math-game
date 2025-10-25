package Experimentation.game.levels;

import Experimentation.core.observer.Observer;
import Experimentation.core.observer.Subject;
import java.util.List;

public class LevelContext
    implements LevelStrategyContext, LevelBlockCreatorContext, LevelInformation, Subject {

    private LevelStrategy strategy;
    private int travelTime;
    private int currentLevel;
    private List<Integer> possibleProducts;
    private List<Integer> possibleQuotients;
    private List<Integer> possibleSums;
    private List<Integer> possibleDifferences;
    private int scoreMultiplier;

    public void setStrategy(LevelStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * .=== Implementations of abstract methods inherited from LevelStrategyContext ===.
     */
    @Override
    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
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

    /**
     * .=== Implementations of abstract methods inherited from LevelBlockCreatorContext ===.
     */
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

    /**
     * .=== Implementations of abstract methods inherited from LevelInformation ===.
     */
    @Override
    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * .=== Implementations of abstract methods inherited from Subject ===.
     */
    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void detach(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
