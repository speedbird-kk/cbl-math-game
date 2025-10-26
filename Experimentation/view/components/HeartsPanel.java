package Experimentation.view.components;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.HeartChangedEvent;
import Experimentation.utils.SwingUtils;
import Experimentation.view.styles.Style;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel for displaying hearts.
 * @SubscribesTo HeartChangedEvent
 */
public class HeartsPanel extends JPanel {
    private static final int MAX_HEARTS = 5;

    /**
     * Display hearts or otherwise number with a heart if overflow.
     */
    public HeartsPanel(int hearts) {
        // Makes transparent and right aligns layout
        Style.HEARTS_PANEL.accept(this);
        displayHearts(hearts);
        EventBroker.getInstance().subscribe(HeartChangedEvent.class, this::updateHearts);
    }

    private void displayHearts(int hearts) {
        if (hearts > MAX_HEARTS) {
            JLabel numericHearts = new JLabel("×" + hearts);
            Style.HEART_NUMERIC_LABEL.accept(numericHearts);
            SwingUtils.addAll(this, numericHearts, new HeartLabel());
        } else {
            for (int i = 0; i < hearts; i++) {
                this.add(new HeartLabel());
            }
        }

        this.revalidate();
        this.repaint();
    }

    /**
     * Updates hearts display on HeartChangeEvent.
     */
    @SubscribesTo(event = HeartChangedEvent.class)
    public void updateHearts(HeartChangedEvent event) {
        this.removeAll();
        displayHearts(event.updatedHeart());
    }

    public void deregister() {
        EventBroker.getInstance().unsubscribe(HeartChangedEvent.class, this::updateHearts);
    }
}