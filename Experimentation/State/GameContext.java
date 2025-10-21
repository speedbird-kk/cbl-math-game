package Experimentation.State;

import Experimentation.Components.Block;
import java.util.ArrayList;
import java.util.List;

public class GameContext {
    private int hearts;
    private int score;
    private int completedBlocks;
    
    private List<Block> activeBlocks;

    private GameState currentState;
}
