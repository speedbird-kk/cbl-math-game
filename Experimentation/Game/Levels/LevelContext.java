package Experimentation.game.levels;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.LevelChangedEvent;
import Experimentation.core.events.TravelTimeChangedEvent;
import Experimentation.game.GameProgress;

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
     * .=== Implementations of abstract methods inherited from LevelStrategyContext ===.
     */
    // region abstract methods inherited from LevelStrategyContext
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
    // endregion

    /**
     * .=== Implementations of abstract methods inherited from LevelBlockCreatorContext ===.
     */
    // region abstract methods inherited from LevelBlockCreatorContext
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
    // endregion

    /**
     * .=== Implementations of abstract methods inherited from LevelInformation ===.
     */
    //region abstract methods inherited from LevelInformation
    @Override
    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }
    // endregion

    /**
     * .=== Implementations of abstract methods inherited from LevelScoringContext ===.
     */
    // region abstract methods inherited from LevelScoringContext
    @Override
    public int getScoreMultiplier() {
        return scoreMultiplier;
    }
    //endregion

    /**
     * .=== Subscription and Publisher methods ===.
     */
    //region subscription and publisher methods
    @SubscribesTo(event = LevelChangedEvent.class)
    @Publishes(event = TravelTimeChangedEvent.class)
    public void onLevelChanged(LevelChangedEvent event) {
        this.currentLevel = event.updatedLevel();
        this.strategy = switch (currentLevel) {
            case 1 -> new LevelOneStrategy();
            case 2 -> new LevelTwoStrategy();
            case 3 -> new LevelThreeStrategy();
            default -> new LevelHigherStrategy(currentLevel);
        };

        strategy.setTravelTime(GameProgress.getInstance().getLevelContext());
        EventBroker.getInstance().publish(new TravelTimeChangedEvent(travelTime));
    }
    // endregion
}
