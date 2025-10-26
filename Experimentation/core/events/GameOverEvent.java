package Experimentation.core.events;

import Experimentation.components.lanes.Lane;
import Experimentation.core.broker.PublishedBy;

@PublishedBy(publisher = Lane.class)
public record GameOverEvent() implements Subscribable {
    
}
