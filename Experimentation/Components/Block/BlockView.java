package Experimentation.Components.Block;

import Experimentation.Styles.ApplyStyles;
import Experimentation.Styles.DimensionConstants;
import Experimentation.Styles.Style;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlockView extends JPanel {
    private final Block block;

    public BlockView(Block block) {
        this.block = block;

        if (block.getIsRed()) {
            ApplyStyles.BLOCK_RED_STYLE.on(this);
        } else {
            ApplyStyles.BLOCK_MAIN_STYLE.on(this);
        }

        JLabel label = new JLabel("" + block.getNumber());
        label.setForeground(this.getForeground());
        Style.BLOCK_LABEL.accept(label);

        this.add(label, BorderLayout.CENTER);


        // x = (DimensionConstants.LANE.get().width - DimensionConstants.BLOCK.get().width) / 2;
        // y = 0;
        // this.setBounds(x, (int) y, DimensionConstants.BLOCK.get().width,DimensionConstants.BLOCK.get().height);
    }
}
