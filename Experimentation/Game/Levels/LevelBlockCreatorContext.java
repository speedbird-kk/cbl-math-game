package Experimentation.game.levels;

import java.util.List;

public interface LevelBlockCreatorContext {
    public List<Integer> getPossibleProducts();

    public List<Integer> getPossibleQuotients();

    public List<Integer> getPossibleSums();

    public List<Integer> getPossibleDifferences();
}
