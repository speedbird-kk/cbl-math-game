package Experimentation.core.events;

import Experimentation.components.block.Block;
import Experimentation.components.lanes.LaneType;

public record BlockCreatedEvent(Block block, LaneType laneType) implements Subscribable {
    
}
