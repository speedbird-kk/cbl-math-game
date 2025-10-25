package Experimentation.view.windows;

import Experimentation.core.observer.Observer;
import Experimentation.core.observer.Subject;
import Experimentation.game.GameProgress;
import Experimentation.game.levels.LevelTravelTime;
import Experimentation.utils.SwingUtils;
import Experimentation.view.components.LaneView;
import Experimentation.view.components.LevelLabel;
import Experimentation.view.components.ScoreLabel;
import Experimentation.view.styles.constants.DimensionConstants;
import java.util.List;
import javax.swing.JPanel;

public class ModeOneWindow implements GameWindow, Observer {
    private final JPanel panel;
    private JPanel lanesPanel;
    private List<LaneView> lanes;
    private ScoreLabel scoreLabel;
    private LevelLabel levelLabel;
    private GameProgress progress;

    public ModeOneWindow() {
        panel = new JPanel();

        for (int i = 0; i < 4; i++) {
            LaneView lane = new LaneView(i * DimensionConstants.LANE.get().width);
            lanes.add(lane);
            lanesPanel.add(lane);
        }

        SwingUtils.addAll(panel, lanesPanel, scoreLabel, levelLabel);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void show() {
        panel.setVisible(true);
    }

    @Override
    public void hide() {
        panel.setVisible(false);
    }

    @Override
    public void update(Subject subject) {
        // scoreLabel = new ScoreLabel(subject.)
    }
}
