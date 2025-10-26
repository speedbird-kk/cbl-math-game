package Experimentation.core.events;

public sealed interface Subscribable permits
    BlockCreatedEvent,
    ScoreChangedEvent,
    LevelChangedEvent,
    TravelTimeChangedEvent,
    HeartChangedEvent,
    OperandsChangedEvent,
    CorrectResponseEvent,
    WrongResponseEvent,
    GameOverEvent {
}