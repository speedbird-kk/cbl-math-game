import Experimentation.view.styles.constants.ColourConstants;
import Experimentation.view.styles.constants.DimensionConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.StyleConstants.ColorConstants;

public enum ApplyStyles {
    LANE_STYLE {
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.LANE_BACKGROUND.get());
            c.setBorder(new LineBorder(Color.BLACK));
            c.setLayout(null);
        }
    },
    OPERAND_STYLE {
        @Override
        public void on(JComponent c) {
            c.setOpaque(true);
            c.setBackground(ColourConstants.OPERAND_BACKGROUND.get());
            c.setForeground(Color.WHITE);
            c.setFont(c.getFont().deriveFont((float) 0.3 * DimensionConstants.OP_LABEL.get().height));
        }
    },
    INPUT_STYLE {
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.INPUT_BACKGROUND.get());
            c.setFont(c.getFont().deriveFont((float) 0.3 * DimensionConstants.INPUT_LABEL.get().height));
            c.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(0, 10, 0, 0)
            ));
        }
    },
    BLOCK_MAIN_STYLE {
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.BLOCK_MAIN.get());
            c.setForeground(Color.WHITE);
        }
    },
    BLOCK_RED_STYLE {
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.BLOCK_RED.get());
            c.setForeground(Color.WHITE);
        }
    },
    SCORE_LABEL_STYLE {
        @Override
        public void on(JComponent c) {
            c.setOpaque(true);
            c.setBackground(ColourConstants.SCORE_BACKGROUND_COLOR.get());
            c.setForeground(Color.WHITE);
            c.setFont(c.getFont().deriveFont((float) 0.5 * DimensionConstants.SCORE_LABEL.get().height));
            c.setBorder(new EmptyBorder(0, 10, 0, 0));
        }
    },
    LEVEL_LABEL_STYLE {
        @Override
        public void on(JComponent c) {
            c.setOpaque(true);
            c.setBackground(ColourConstants.LEVEL_BACKGROUND_COLOR.get());
            c.setForeground(Color.WHITE);
            c.setFont(c.getFont().deriveFont((float) 0.5 * DimensionConstants.LEVEL_LABEL.get().height));
            c.setBorder(new EmptyBorder(0, 10, 0, 0));
        }
    },
    TITLE_SCREEN_STYLE {
        @Override
        public void on(JComponent c) {
            c.setBackground(ColourConstants.TITLE_SCREEN_BACKGROUND.get());
        }

    };

    public abstract void on(JComponent c);

    /**
     * Apply multiple styles on a component.
     */
    @SafeVarargs
    public static final void on(JComponent c, ApplyStyles... styles) {
        for (ApplyStyles style : styles) {
            style.on(c);
        }
    }
}