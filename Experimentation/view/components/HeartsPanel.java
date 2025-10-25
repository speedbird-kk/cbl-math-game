package Experimentation.view.components;

import Experimentation.core.observer.Observer;
import Experimentation.core.observer.Subject;
import Experimentation.utils.SwingUtils;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.LengthConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeartsPanel extends JPanel implements Observer {
    /**
     * Display hearts or otherwise number with a heart if overflow.
     */
    public HeartsPanel(int hearts) {
        // Makes transparent and right aligns layout
        Style.HEARTS_PANEL.accept(this);

        if (hearts
            > ((5 * LengthConstants.HEART_WIDTH.get()) / LengthConstants.HEART_WIDTH.get())) {
            
            JLabel numericHearts = new JLabel("×" + hearts);
            Style.HEART_NUMERIC_LABEL.accept(numericHearts);
            SwingUtils.addAll(this, numericHearts, new HeartLabel());
        } else {
            for (int i = 0; i < hearts; i++) {
                this.add(new HeartLabel());
            }
        }
    }

    public void update(Subject subject) {

    }
}