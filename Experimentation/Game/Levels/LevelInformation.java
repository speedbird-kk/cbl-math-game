package Experimentation.game.levels;

public sealed interface LevelInformation permits LevelContext {
    public int getTravelTime();

    public int getCurrentLevel();
}
