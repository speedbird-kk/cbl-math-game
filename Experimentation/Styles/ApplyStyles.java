package Experimentation.Styles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

public enum ApplyStyles {
    STYLE_NAME {
        @Override
        public void on(JComponent c) {

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