package Experimentation.view.components;

import Experimentation.components.block.Block;
import Experimentation.components.lanes.LaneType;
import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.BlockCreatedEvent;
import Experimentation.core.events.BlockHasHitBottomEvent;
import Experimentation.core.events.CorrectResponseEvent;
import Experimentation.core.events.TravelTimeChangedEvent;
import Experimentation.core.events.WrongResponseEvent;
import Experimentation.game.levels.LevelOneStrategy;
import Experimentation.utils.SwingUtils;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.DimensionConstants;
import Experimentation.view.styles.constants.LengthConstants;
import Experimentation.view.styles.constants.TimerConstants;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaneView extends JPanel implements ActionListener {
    private static final int DEFAULT_TRAVEL_TIME_MS = LevelOneStrategy.TRAVEL_TIME_MS;

    private final JLabel operand;
    private final JTextField input;
    private final LaneType laneType;
    private List<BlockView> activeBlocks = new ArrayList<>();
    private int deltaY;
    private String rawInput;

    /**
     * Sets lane type, bounds, adds components and subscribes to BlockCreatedEvent.
     */
    public LaneView(LaneType laneType, int x) {
        this.laneType = laneType;

        this.setBounds(
            x,
            LengthConstants.GRID_HEIGHT.get(),
            DimensionConstants.LANE.get().width,
            DimensionConstants.LANE.get().height
        );

        Style.LANE_PANEL.accept(this);

        // Initialise deltaY to Level 1 settings
        this.deltaY = 
            (LengthConstants.BLOCK_TRAVEL_DISTANCE.get() / DEFAULT_TRAVEL_TIME_MS)
            * TimerConstants.DELAY_MS.get();

        this.operand = new JLabel();
        Style.OPERAND_LABEL.accept(operand);
        
        input = new JTextField();
        Style.INPUT_TEXTFIELD.accept(input);
        input.addActionListener(this);

        SwingUtils.addAll(this, operand, input);

        EventBroker broker = EventBroker.getInstance();
        broker.subscribe(BlockCreatedEvent.class, this::addBlockToLane);
        broker.subscribe(WrongResponseEvent.class, this::wrongAnswer);
        broker.subscribe(CorrectResponseEvent.class, this::correctAnswer);
    }

    public void updateBlocks() {
        for (BlockView activeBlock : activeBlocks) {
            activeBlock.moveDown(deltaY);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        rawInput = input.getText();
    }

    /**
     * .=== Getters ===.
     */
    // region getters
    public LaneType getLaneType() {
        return laneType;
    }

    public List<BlockView> getActiveBlocks() {
        return activeBlocks;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public String getRawInput() {
        return rawInput;
    }
    // endregion

    /**
     * .=== Subscribers and publishers ===.
     */
    // region subscribers and publishers

    // Adds a new block on event if it is of the same lane type as this.
    @SubscribesTo(event = BlockCreatedEvent.class)
    public void addBlockToLane(BlockCreatedEvent event) {
        if (event.laneType() == laneType) {
            BlockView newBlock = new BlockView(event.block());
            this.add(newBlock);
            activeBlocks.add(newBlock);
        }
    }

    public void deregisterAll() {
        EventBroker broker = EventBroker.getInstance();
        broker.unsubscribe(BlockCreatedEvent.class, this::addBlockToLane);
        broker.unsubscribe(WrongResponseEvent.class, this::wrongAnswer);
        broker.unsubscribe(CorrectResponseEvent.class, this::correctAnswer);
    }

    @SubscribesTo(event = WrongResponseEvent.class)
    public void wrongAnswer(WrongResponseEvent event) {
        Style.INPUT_TEXTFIELD_WRONG.accept(input);
    }

    /**
     * Filters to check block is in lane and removes block.
     */
    @SubscribesTo(event = CorrectResponseEvent.class)
    public void correctAnswer(CorrectResponseEvent event) {
        List<BlockView> blocksToRemove = activeBlocks.stream()
            .filter(blockView -> blockView.getBlock() == event.currentBlock())
            .collect(Collectors.toList());
        
        if (!blocksToRemove.isEmpty()) {
            Style.INPUT_TEXTFIELD_CORRECT.accept(input);
            blocksToRemove.forEach((blockView -> {
                this.remove(blockView);
                activeBlocks.remove(blockView);
            }));
        }
    }

    /**
     * Updates delta y value when travel time changes.
     * deltaY [px] = (travelDistance [px] / travelTime [ms]) * timerDelay [ms]
     */
    @SubscribesTo(event = TravelTimeChangedEvent.class)
    public void updateDeltaY(TravelTimeChangedEvent event) {
        this.deltaY = 
            (LengthConstants.BLOCK_TRAVEL_DISTANCE.get() / event.travelTime())
            * TimerConstants.DELAY_MS.get();
    }

    @SubscribesTo(event = BlockHasHitBottomEvent.class)
    public void removeBlockFromLane(BlockHasHitBottomEvent event) {
        List<BlockView> blocksToRemove = activeBlocks.stream()
            .filter(blockView -> blockView.getBlock() == event.block())
            .collect(Collectors.toList());
        
        if (!blocksToRemove.isEmpty()) {
            Style.INPUT_TEXTFIELD_CORRECT.accept(input);
            blocksToRemove.forEach((blockView -> {
                this.remove(blockView);
                activeBlocks.remove(blockView);
            }));
        }
    }
    // endregion
}