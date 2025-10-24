package Experimentation.game;

import Experimentation.core.observer.Subject;

/**
 * Singleton.
 */
public final class GameProgress implements Subject {
    private static GameProgress INSTANCE;

    private int hearts;
    private int score;
    private int blocksCompleted;

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
    }

    public void subtractHeart() {
        if (hearts > 0) {
            hearts--;
        }
    }

    public void removeHearts() {
        hearts = 0;
    }

    public void incrementScore(int increment) {
        score += increment;
    }

    public void incrementBlocksCompleted() {
        blocksCompleted++;
    }

    public void resetBlocksCompleted() {
        blocksCompleted = 0;
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
}