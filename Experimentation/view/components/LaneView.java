package Experimentation.view.components;

import Experimentation.components.block.Block;
import Experimentation.components.lanes.LaneType;
import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.BlockCreatedEvent;
import Experimentation.core.events.CorrectResponseEvent;
import Experimentation.core.events.WrongResponseEvent;
import Experimentation.utils.SwingUtils;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.DimensionConstants;
import Experimentation.view.styles.constants.LengthConstants;

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
    private final JLabel operand;
    private final JTextField input;
    private final LaneType laneType;
    private List<BlockView> activeBlocks = new ArrayList<>();
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

    /**
     * Adds a new block on event if it is of the same lane type as this.
     */
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
            .filter(blockView -> blockView.getBlock().equals(event.currentBlock()))
            .collect(Collectors.toList());
        
        if (!blocksToRemove.isEmpty()) {
            Style.INPUT_TEXTFIELD_CORRECT.accept(input);
            blocksToRemove.forEach((blockView -> {
                this.remove(blockView);
                activeBlocks.remove(blockView);
            }));
        }
    }

    public void actionPerformed(ActionEvent evt) {
        rawInput = input.getText();
    }

    public LaneType getLaneType() {
        return laneType;
    }

    public String getRawInput() {
        return rawInput;
    }
}