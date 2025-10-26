package Experimentation.game.levels;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.LevelChangedEvent;
import Experimentation.core.events.TravelTimeChangedEvent;
import java.util.List;

public final class LevelContext
    implements LevelStrategyContext, LevelBlockCreatorContext, LevelInformation,
    LevelScoringContext {

    private LevelStrategy strategy;
    private int travelTime;
    private int currentLevel;
    private List<Integer> possibleProducts;
    private List<Integer> possibleQuotients;
    private List<Integer> possibleSums;
    private List<Integer> possibleDifferences;
    private int scoreMultiplier;

    /**
     * Sets strategy on LevelChangedEvent depending on updatedLevel record component.
     */
    @SubscribesTo(event = LevelChangedEvent.class)
    public void setStrategy(LevelChangedEvent event) {
        int updatedLevel = event.updatedLevel();

        if (updatedLevel == 1) {
            setStrategy(new LevelOneStrategy());
        } else if (updatedLevel == 2) {
            setStrategy(new LevelTwoStrategy());
        } else if (updatedLevel == 3) {
            setStrategy(new LevelThreeStrategy());
        } else if (updatedLevel > 3) {
            setStrategy(new LevelHigherStrategy(updatedLevel));
        }
    }

    private void setStrategy(LevelStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * .=== Implementations of abstract methods inherited from LevelStrategyContext ===.
     */
    @Override
    @Publishes(event = TravelTimeChangedEvent.class)
    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
        EventBroker.getInstance().publish(new TravelTimeChangedEvent(travelTime));
    }

    @Override
    @Publishes(event = LevelChangedEvent.class)
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
        EventBroker.getInstance().publish(new LevelChangedEvent(currentLevel));
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
     * .=== Implementations of abstract methods inherited from LevelScoringContext ===.
     */
    @Override
    public int getScoreMultiplier() {
        return scoreMultiplier;
    }
}
