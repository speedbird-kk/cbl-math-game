package Experimentation.core.events;

import Experimentation.components.lanes.factory.all.Operands;

public record OperandsChangedEvent(Operands operands) implements Subscribable {
    
}
