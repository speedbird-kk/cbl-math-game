package Experimentation.core.events;

import Experimentation.components.block.Block;

public record BlockCreatedEvent(Block block) implements Subscribable {
    
}
