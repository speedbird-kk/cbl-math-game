package Experimentation.Game;

import Experimentation.Components.Block.Block;
import Experimentation.ComponentsGUI.Frame.MainFrame;
import Experimentation.Game.Levels.LevelContext;
import Experimentation.Game.States.GameState;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GameContext implements GameStatesContext {
    private GameProgress progress;
    private MainFrame frame;
    private List<Block> activeBlocks;

    private GameState state;
    private JFrame mainFrame;

    private LevelContext levelContext;

    public void setState(GameState state) {
        this.state = state;
    }

    public void request(GameContext context) {
        state.handleRequest(this);
    }

    public MainFrame getFrame() {
        return frame;
    }
}
