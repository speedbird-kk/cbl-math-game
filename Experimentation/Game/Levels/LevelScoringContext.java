package Experimentation.game.levels;

public sealed interface LevelScoringContext permits LevelContext {
    public int getScoreMultiplier();
}
