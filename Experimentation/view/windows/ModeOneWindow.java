package Experimentation.view.windows;

import Experimentation.components.lanes.LaneType;
import Experimentation.core.events.BlockCreatedEvent;
import Experimentation.game.GameProgress;
import Experimentation.game.levels.LevelInformation;
import Experimentation.utils.SwingUtils;
import Experimentation.view.components.BlockView;
import Experimentation.view.components.LaneView;
import Experimentation.view.components.LevelLabel;
import Experimentation.view.components.ScoreLabel;
import Experimentation.view.styles.constants.DimensionConstants;
import Experimentation.view.styles.constants.TimerConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ModeOneWindow implements GameWindow {
    private final JPanel panel;
    private JPanel lanesPanel;
    private List<LaneView> lanes;
    private ScoreLabel scoreLabel;
    private LevelLabel levelLabel;
    private GameProgress progress;

    public ModeOneWindow() {
        panel = new JPanel();

        for (int i = 0; i < LaneType.values().length; i++) {
            LaneView lane = new LaneView(
                LaneType.values()[i],
                i * DimensionConstants.LANE.get().width
            );

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

    public void update() {
        ActionListener performer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (LaneView lane : lanes) {
                    lane.updateBlocks();
                }
                // update game
                // revalidate and repaint
            }
        };

        new Timer(TimerConstants.DELAY_MS.get(), performer).start();
    }
}
