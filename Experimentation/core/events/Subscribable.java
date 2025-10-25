package Experimentation.core.events;

public sealed interface Subscribable permits
    BlockCreatedEvent,
    ScoreChangedEvent,
    LevelChangedEvent,
    HeartChangedEvent,
    OperandsChangedEvent {
}