package Experimentation.view.components;

import Experimentation.components.block.Block;
import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.events.BlockHasHitBottomEvent;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.BoundsConstants;
import Experimentation.view.styles.constants.DimensionConstants;
import Experimentation.view.styles.constants.LengthConstants;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlockView extends JPanel {
    private final Block block;
    private final int x;
    private int y;
    private int travelTime;

    public BlockView(Block block) {
        this.block = block;

        if (block.getIsRed()) {
            Style.RED_BLOCK_PANEL.accept(this);
        } else {
            Style.BLOCK_PANEL.accept(this);
        }

        JLabel label = new JLabel("" + block.getNumber());
        Style.BLOCK_LABEL.accept(label);

        this.add(label, BorderLayout.CENTER);

        x = (DimensionConstants.LANE.get().width
            - DimensionConstants.BLOCK.get().width) / 2;
        
        y = 0;

        this.setBounds(BoundsConstants.BLOCK_BOUNDS.get());
    }

    @Publishes(event = BlockHasHitBottomEvent.class)
    public void moveDown(int deltaY) {
        Point location = getLocation();
        if (location.y + deltaY > LengthConstants.BLOCK_TRAVEL_DISTANCE.get()) {
            // TODO: Constructor BlockHasHitBottomEvent must have LaneType, how to reference ??
            EventBroker.getInstance().publish(new BlockHasHitBottomEvent(block));
        } else {
            setLocation(location.x, location.y + deltaY);
        }
    }

    public Block getBlock() {
        return block;
    }
}