package Experimentation.core.events;

import Experimentation.core.broker.PublishedBy;
import Experimentation.core.broker.SubscribedBy;
import Experimentation.game.GameProgress;
import Experimentation.view.components.HeartsPanel;

/**
 * Event published on number of hearts changed.
 */
@PublishedBy(publisher = GameProgress.class)
@SubscribedBy(subscriber = HeartsPanel.class)
public record HeartChangedEvent(int updatedHeart) implements Subscribable {
    
}
