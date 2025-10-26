package Experimentation.game;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.CorrectResponseEvent;
import Experimentation.core.events.HeartChangedEvent;
import Experimentation.core.events.LevelChangedEvent;
import Experimentation.core.events.ScoreChangedEvent;
import Experimentation.core.events.WrongResponseEvent;

/**
 * Singleton.
 */
public final class GameProgress {
    private static GameProgress INSTANCE;

    private int hearts;
    private int score;
    private int blocksCompleted;
    private int currentLevel;

    private GameProgress() {
        reset();
    }

    public static synchronized GameProgress getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameProgress();
        }

        return INSTANCE;
    }


    public void reset() {
        hearts = 3;
        score = 0;
        blocksCompleted = 0;
    }

    public void addHeart() {
        hearts++;
        publishHearts();
    }

    @SubscribesTo(event = WrongResponseEvent.class)
    public void subtractHeart() {
        if (hearts > 0) {
            hearts--;
        }
        publishHearts();
    }

    public void removeHearts() {
        hearts = 0;
        publishHearts();
    }

    @Publishes(event = HeartChangedEvent.class)
    private void publishHearts() {
        EventBroker.getInstance().publish(new HeartChangedEvent(hearts));
    }

    /**
     * Updates score and publishes result.
     */
    @Publishes(event = ScoreChangedEvent.class)
    @SubscribesTo(event = CorrectResponseEvent.class)
    public void incrementScore(int increment) {
        score += increment;

        EventBroker.getInstance().publish(new ScoreChangedEvent(score));
    }

    public void incrementBlocksCompleted() {
        blocksCompleted++;

        if (blocksCompleted > 16) {
            resetBlocksCompleted();
            updateLevel();
        }
    }

    public void resetBlocksCompleted() {
        blocksCompleted = 0;
    }

    @Publishes(event = LevelChangedEvent.class)
    public void updateLevel() {
        currentLevel++;
        EventBroker.getInstance().publish(new LevelChangedEvent(currentLevel));
    }

    
    public int getHearts() {
        return hearts;
    }

    public int getScore() {
        return score;
    }

    public int getBlocksCompleted() {
        return blocksCompleted;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}