package Experimentation.view.styles;

import Experimentation.view.styles.constants.BoundsConstants;
import Experimentation.view.styles.constants.ColourConstants;
import Experimentation.view.styles.constants.DimensionConstants;
import Experimentation.view.styles.constants.FontConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public final class Style {
    /**
     * .=== PANEL STYLES ===.
     */
    public static final Consumer<JPanel> LANE_PANEL = panel -> {
        panel.setBackground(ColourConstants.LANE_BACKGROUND.get());
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setLayout(null);
    };

    public static final Consumer<JPanel> BLOCK_PANEL = panel -> {
        panel.setBackground(ColourConstants.BLOCK_MAIN.get());
        panel.setForeground(Color.WHITE);
        panel.setBounds(BoundsConstants.BLOCK_BOUNDS.get());
    };

    private static final Consumer<JPanel> MAKE_BLOCK_RED = panel -> {
        panel.setBackground(ColourConstants.BLOCK_RED.get());
    };

    public static final Consumer<JPanel> RED_BLOCK_PANEL =
        BLOCK_PANEL.andThen(MAKE_BLOCK_RED);
    
    public static final Consumer<JPanel> TITLE_SCREEN_PANEL = panel -> {
        panel.setLayout(null);
        panel.setBackground(ColourConstants.TITLE_SCREEN_BACKGROUND.get());
    };
    
    /**
     * .=== LABEL STYLES ===.
     */
    public static final Consumer<JLabel> BLOCK_LABEL = label -> {
        label.setForeground(Color.WHITE);
        label.setLayout(new BorderLayout());
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

    public static final Consumer<JLabel> SCORE_LABEL = label -> {
        label.setBounds(BoundsConstants.SCORE_LABEL_BOUNDS.get());
        label.setOpaque(true);
        label.setBackground(ColourConstants.SCORE_BACKGROUND_COLOR.get());
        label.setForeground(Color.WHITE);
        label.setFont(FontConstants.SCORE_LABEL.get()
            .deriveFont((float) 0.5 * DimensionConstants.SCORE_LABEL.get().height));
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
    };

    public static final Consumer<JLabel> LEVEL_LABEL = label -> {
        label.setBounds(BoundsConstants.LEVEL_LABEL_BOUNDS.get());
        label.setOpaque(true);
        label.setBackground(ColourConstants.LEVEL_BACKGROUND_COLOR.get());
        label.setForeground(Color.WHITE);
        label.setFont(FontConstants.LEVEL_LABEL.get()
            .deriveFont((float) 0.5 * DimensionConstants.LEVEL_LABEL.get().height));
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
    };

    /**
     * .=== TEXT FIELD STYLES ===.
     */
    public static final Consumer<JTextField> INPUT_TEXTFIELD = textField -> {
        textField.setBackground(ColourConstants.INPUT_BACKGROUND.get());
        textField.setFont(FontConstants.INPUT_TEXTFIELD.get()
            .deriveFont((float) 0.3 * DimensionConstants.INPUT_LABEL.get().height));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(0, 10, 0, 0))
        );
        
        // disable default tab for focus
        textField.setFocusTraversalKeysEnabled(false);
        textField.setBounds(BoundsConstants.INPUT_TEXTFIELD_BOUNDS.get());
    };

    public static final Consumer<JTextField> INPUT_TEXTFIELD_WRONG = textField -> {
        textField.setBackground(ColourConstants.INPUT_BACKGROUND_WRONG.get());
    };

    /**
     * .=== TEXT AREA STYLES ===.
     */
    public static final Consumer<JTextArea> TUTORIAL_TEXTAREA = textArea -> {
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBounds(BoundsConstants.TUTORIAL_TEXTAREA_BOUNDS.get());
        textArea.setOpaque(false);
        textArea.setFont(UIManager.getFont("Label.font"));
        textArea.setForeground(Color.WHITE);
    };
}
