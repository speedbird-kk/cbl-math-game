package Experimentation.view.styles;

import java.awt.Color;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Experimentation.view.styles.ColourConstants;

public final class Style {
    public static final Consumer<JLabel> BLOCK_LABEL = label -> {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(FontConstants.BLOCK_LABEL.get()
            .deriveFont((float) 0.3 * DimensionConstants.BLOCK.get().height));
    };

    public static final Consumer<JLabel> OPERAND_LABEL = label -> {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(ColourConstants.OPERAND_BACKGROUND.get());
        label.setForeground(Color.WHITE);
        label.setFont(FontConstants.OPERAND_LABEL.get()
            .deriveFont((float) 0.3 * DimensionConstants.OPERAND_LABEL.get().height));
    };
}
