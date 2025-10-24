package Experimentation.Components.Block;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Experimentation.Styles.ApplyStyles;

public class BlockView extends JPanel {
    private final Block block;

    public BlockView(Block block) {
        this.block = block;
        if (!block.getIsRed()) {
            ApplyStyles.BLOCK_MAIN_STYLE.on(this);
        } else {
            
        }
        JLabel label = new JLabel("" + block.getNumber())
    }
}
