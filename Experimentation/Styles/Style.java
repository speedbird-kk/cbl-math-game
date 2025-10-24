package Experimentation.Styles;

import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public final class Style {
    public static final Consumer<JLabel> BLOCK_LABEL = label -> {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(FontConstants.BLOCK_LABEL.get()
            .deriveFont((float) 0.3 * DimensionConstants.BLOCK.get().height));
    };
}
