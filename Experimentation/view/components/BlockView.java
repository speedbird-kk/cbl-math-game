package Experimentation.view.components;

import Experimentation.components.block.Block;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.BoundsConstants;
import Experimentation.view.styles.constants.DimensionConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlockView extends JPanel {
    private final Block block;
    private final int x;
    private int y;

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
}