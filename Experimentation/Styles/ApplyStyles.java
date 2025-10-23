package Experimentation.Styles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.text.StyleConstants.ColorConstants;

public enum ApplyStyles {
    STYLE_NAME {
        @Override
        public void on(JComponent c) {

        }
    },
    LANE_STYLE{
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.LANE_BACKGROUND.get());
        }
    },
    OPERAND_STYLE{
        @Override
        public void on(JComponent c) {
            c.setOpaque(true);
            c.setBackground(ColourConstants.OPERAND_BACKGROUND.get());
            c.setForeground(Color.WHITE);
            c.setFont(c.getFont().deriveFont((float) 0.5 * DimensionConstants.OP_LABEL.get().height));
        }
    },
    INPUT_STYLE{
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.INPUT_BACKGROUND.get());
        }
    },
    BLOCK_MAIN_STYLE{
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.BLOCK_MAIN.get());
            c.setForeground(Color.WHITE);
        }
    };

    public abstract void on(JComponent c);

    /**
     * Apply multiple styles on a component.
     */
    @SafeVarargs
    public static final void on(JComponent c, String... styles)
        throws UnsupportedOperationException {

        for (String style : styles) {
            boolean isFound = false;

            for (ApplyStyles constant : ApplyStyles.values()) {
                if (constant.name().equals(style)) {
                    isFound = true;
                    constant.on(c);
                }
            }

            if (!isFound) {
                throw new UnsupportedOperationException("Unknown style.");
            }
        }
    }
}