package FormerExperimentation;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

/**
 * Enum of styling classes.
 */
public enum ClassList {
    TITLE {
        @Override
        public void add(JComponent c) {
            c.setBackground(Color.CYAN);
            c.setFont(new Font("Verdana", Font.BOLD, 20));
        }
    },

    BUTTON {
        @Override
        public void add(JComponent c) {
            c.setBorder(BorderFactory.createEtchedBorder());
            c.setBackground(StyleVariable.MAIN_BTN_COLOUR.colour());
            c.setFont(new Font("Verdana", Font.ITALIC, 25));
            c.setVisible(true);
        }
    },

    BUTTON_EXTRA {
        @Override
        public void add(JComponent c) {
            c.setFont(StyleVariable.MAIN_FONT.font());
            c.setSize(50, 50);
            c.setBackground(Color.BLUE);
        }
    };

    public abstract void add(JComponent c);

    /**
     * Add multiple classes.
     */
    @SafeVarargs
    public static final void add(JComponent c, String... classes) {
        for (String cl : classes) {
            for (ClassList l : ClassList.values()) {
                if (l.name().equals(cl)) {
                    l.add(c);
                }
            }
        }
    }
}
