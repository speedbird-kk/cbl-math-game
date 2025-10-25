package Experimentation.core.pubsub;

import Experimentation.core.events.Subscribable;

public interface Publisher<T extends Subscribable> {
    public T publish();
}
