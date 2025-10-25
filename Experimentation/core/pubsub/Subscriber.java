package Experimentation.core.pubsub;

import Experimentation.core.events.Subscribable;

public interface Subscriber<T extends Subscribable> {
    public void onEvent(T event);
}
