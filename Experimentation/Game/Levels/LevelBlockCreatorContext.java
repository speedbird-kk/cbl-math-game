package Experimentation.game.levels;

import java.util.List;

public sealed interface LevelBlockCreatorContext permits LevelContext {
    public List<Integer> getPossibleProducts();

    public List<Integer> getPossibleQuotients();

    public List<Integer> getPossibleSums();

    public List<Integer> getPossibleDifferences();
}
