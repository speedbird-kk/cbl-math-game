package Experimentation.core.events;

import Experimentation.components.block.Block;
import Experimentation.components.lanes.Lane;
import Experimentation.core.broker.PublishedBy;
import Experimentation.core.broker.SubscribedBy;
import Experimentation.view.components.LaneView;

@PublishedBy(publisher = Lane.class)
@SubscribedBy(subscriber = LaneView.class)
public record WrongResponseEvent(Block currentBlock) implements Subscribable {
    
}
