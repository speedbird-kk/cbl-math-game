package Experimentation.core.events;

import Experimentation.components.block.Block;
import Experimentation.components.lanes.Lane;
import Experimentation.components.lanes.LaneType;
import Experimentation.core.broker.PublishedBy;
import Experimentation.core.broker.SubscribedBy;
import Experimentation.game.levels.LevelScoringContext;
import Experimentation.view.components.LaneView;

@PublishedBy(publisher = Lane.class)
@SubscribedBy(subscriber = LaneView.class)
public record CorrectResponseEvent(
    Block currentBlock, LevelScoringContext context) implements Subscribable {
    
}
