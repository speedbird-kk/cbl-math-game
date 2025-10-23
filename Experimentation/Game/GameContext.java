package Experimentation.Game;

import Experimentation.Components.Block;
import Experimentation.Frame.MainFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GameContext {
    private GameProgress progress;
    private MainFrame frame;
    private List<Block> activeBlocks;

    private GameState state;
    private JFrame mainFrame;

    public void setState(GameState state) {
        this.state = state;
    }

    public void request(GameContext context) {
        state.handleRequest(this);
    }

    MainFrame getFrame() {
        return frame;
    }
}
