package Experimentation.view.components;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.LevelChangedEvent;
import Experimentation.view.styles.Style;
import javax.swing.JLabel;

/**
 * JLabel displaying the current label.
 * @SubscribesTo LevelChangedEvent
 */
public class LevelLabel extends JLabel {
    /**
     * Set styling, text displaying level and subscribe to LevelChangedEvent.
     */
    public LevelLabel(int level) {
        Style.LEVEL_LABEL.accept(this);
        this.setText("Level " + level);

        EventBroker.getInstance().subscribe(LevelChangedEvent.class, this::updateLevel);
    }

    @SubscribesTo(event = LevelChangedEvent.class)
    public void updateLevel(LevelChangedEvent event) {
        this.setText("Level " + event.updatedLevel());
    }
}