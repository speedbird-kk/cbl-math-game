package Experimentation.Game;

import Experimentation.Components.Block;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GameContext {
    private GameProgress progress;
    private List<Block> activeBlocks;

    private GameState currentState;
    private JFrame mainFrame;
}
