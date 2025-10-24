package Experimentation.core;

import Experimentation.view.frame.MainFrame;
import Experimentation.components.block.Block;
import Experimentation.components.lanes.AllLanes;
import Experimentation.game.GameProgress;
import Experimentation.game.levels.LevelContext;
import Experimentation.core.states.GameState;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GameContext implements GameStatesContext, GameLevelStrategyContext {
    private GameProgress progress;
    private MainFrame frame;
    private List<Block> activeBlocks;
    private AllLanes lanes;
    private GameState state;
    private LevelContext levelContext;

    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public void setLanes(AllLanes lanes) {
        this.lanes = lanes;
    }

    public void request(GameContext context) {
        state.handleRequest(this);
    }

    @Override
    public MainFrame getFrame() {
        return frame;
    }

    @Override
    public AllLanes getLanes() {
        return lanes;
    }
}
