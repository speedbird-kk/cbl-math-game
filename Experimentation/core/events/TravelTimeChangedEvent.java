package Experimentation.core.events;

import Experimentation.core.broker.PublishedBy;
import Experimentation.game.levels.LevelContext;

@PublishedBy(publisher = LevelContext.class)
public record TravelTimeChangedEvent(int travelTime) implements Subscribable {
    
}
