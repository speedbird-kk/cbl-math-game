package Experimentation.view.components;

import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.SubscribesTo;
import Experimentation.core.events.ScoreChangedEvent;
import Experimentation.view.styles.Style;
import javax.swing.JLabel;

/**
 * JLabel displaying the current score.
 * @SubscribesTo ScoreChangedEvent
 */
public class ScoreLabel extends JLabel {
    /**
     * Set styling, text displaying the score and subscribe to ScoreChangedEvent.
     */
    public ScoreLabel(int score) {
        Style.SCORE_LABEL.accept(this);
        this.setText("Score: " + score);
        
        EventBroker.getInstance().subscribe(ScoreChangedEvent.class, this::updateScore);
    }

    public void deregister() {
        EventBroker.getInstance().unsubscribe(ScoreChangedEvent.class, this::updateScore);
    }

    @SubscribesTo(event = ScoreChangedEvent.class)
    public void updateScore(ScoreChangedEvent event) {
        this.setText("Score: " + event.updatedScore());
    }
}
