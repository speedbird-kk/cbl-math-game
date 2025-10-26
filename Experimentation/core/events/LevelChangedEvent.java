package Experimentation.core.events;

import Experimentation.core.broker.PublishedBy;
import Experimentation.core.broker.SubscribedBy;
import Experimentation.game.levels.LevelContext;
import Experimentation.view.components.LevelLabel;

/**
 * Event published on level changed.
 */
@PublishedBy(publisher = LevelContext.class)
@SubscribedBy(subscriber = LevelLabel.class)
public record LevelChangedEvent(int updatedLevel) implements Subscribable {
    
}
