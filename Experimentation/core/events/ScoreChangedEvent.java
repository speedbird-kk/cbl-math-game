package Experimentation.core.events;

public record ScoreChangedEvent(int updatedScore) implements Subscribable {
    
}
