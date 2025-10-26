package Experimentation.game;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.BlockHasHitBottomEvent;
import Experimentation.core.events.CorrectResponseEvent;
import Experimentation.core.events.GameOverEvent;
import Experimentation.core.events.HeartChangedEvent;
import Experimentation.core.events.LevelChangedEvent;
import Experimentation.core.events.ScoreChangedEvent;
import Experimentation.game.levels.LevelContext;

/**
 * Singleton.
 */
public final class GameProgress {
    private static GameProgress INSTANCE;

    private final LevelContext levelContext;
    private int hearts;
    private int score;
    private int blocksCompleted;
    private int currentLevel;

    private GameProgress() {
        reset();

        levelContext = new LevelContext();
        EventBroker broker = EventBroker.getInstance();

        broker.subscribe(BlockHasHitBottomEvent.class, this::subtractHeart);
        broker.subscribe(GameOverEvent.class, this::removeHearts);
        broker.subscribe(CorrectResponseEvent.class, this::incrementScore);
        broker.subscribe(CorrectResponseEvent.class, this::incrementBlocksCompleted);

        broker.subscribe(LevelChangedEvent.class, levelContext::onLevelChanged);
    }

    /**
     * Return singleton instance.
     */
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

    @SubscribesTo(event = CorrectResponseEvent.class)
    public void incrementBlocksCompleted(CorrectResponseEvent event) {
        blocksCompleted++;

        if (blocksCompleted > 16) {
            resetBlocksCompleted();
            updateLevel();
        }
    }

    private void resetBlocksCompleted() {
        blocksCompleted = 0;
    }

    /**
     * .=== Getters ===.
     */
    // region getters
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

    public LevelContext getLevelContext() {
        return levelContext;
    }
    // endregion

    /**
     * .=== Subscribers and publishers ===.
     */
    // region subscribers and publishers
    @SubscribesTo(event = BlockHasHitBottomEvent.class)
    public void subtractHeart(BlockHasHitBottomEvent event) {
        if (hearts > 0) {
            hearts--;
        }
        publishHearts();
    }

    @SubscribesTo(event = GameOverEvent.class)
    public void removeHearts(GameOverEvent event) {
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
    public void incrementScore(CorrectResponseEvent event) {
        score += event.context().getScoreMultiplier();

        EventBroker.getInstance().publish(new ScoreChangedEvent(score));
    }

    @Publishes(event = LevelChangedEvent.class)
    public void updateLevel() {
        currentLevel++;
        EventBroker.getInstance().publish(new LevelChangedEvent(currentLevel));
    }
    // endregion
}