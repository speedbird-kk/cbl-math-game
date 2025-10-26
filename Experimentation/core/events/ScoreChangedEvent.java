package Experimentation.core.events;

import Experimentation.core.broker.PublishedBy;
import Experimentation.core.broker.SubscribedBy;
import Experimentation.game.GameProgress;
import Experimentation.view.components.ScoreLabel;

/**
 * Event published on score changed.
 */
@PublishedBy(publisher = GameProgress.class)
@SubscribedBy(subscriber = ScoreLabel.class)
public record ScoreChangedEvent(int updatedScore) implements Subscribable {
    
}
