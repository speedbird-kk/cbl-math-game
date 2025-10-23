package Experimentation.State;

import Experimentation.Components.Block;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GameContext {
    private int hearts;
    private int score;
    private int blocksCompleted;
    
    private List<Block> activeBlocks;

    private GameState currentState;
    private JFrame mainFrame;
}
