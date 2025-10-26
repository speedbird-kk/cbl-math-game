package Experimentation.core.events;

import Experimentation.components.block.Block;
import Experimentation.components.lanes.LaneType;
import Experimentation.core.broker.PublishedBy;
import Experimentation.core.broker.SubscribedBy;
import Experimentation.view.components.BlockView;
import Experimentation.view.components.LaneView;

@PublishedBy(publisher = BlockView.class)
@SubscribedBy(subscriber = LaneView.class)
public record BlockHasHitBottomEvent(Block block) implements Subscribable {
    
}
