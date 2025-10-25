package Experimentation.core.pubsub;

import Experimentation.core.events.Subscribable;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public final class EventBroker<T extends Subscribable> {
    private static EventBroker INSTANCE;
    private Map<Class<T>, Set<Subscriber>> subscribers = new HashMap<>();

    private EventBroker() {
    }

    public static synchronized EventBroker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventBroker<T>();
        }

        return INSTANCE;
    }

    public void subscribe(Class<T> event, Subscriber<T> subscriber) {
        subscribers.computeIfAbsent(event, k -> new HashSet<>()).add(subscriber);
    }

    public void unsubscribe(Class<T> event, Subscriber<T> subscriber) {
        if (subscribers.get(event).contains(subscriber)) {
            subscribers.get(event).remove(subscriber);
        }
    }
}
