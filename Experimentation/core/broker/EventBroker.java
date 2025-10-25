package Experimentation.core.broker;

import Experimentation.core.events.Subscribable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;

/**
 * Mediator singleton managing event subscriptions and applying consumer accepting event.
 */
public final class EventBroker {
    private static EventBroker INSTANCE;

    // Producer Extends, Consumer Super (PECS)
    private final Map<Class<? extends Subscribable>,
        Set<Consumer<? super Subscribable>>> subscribers = new HashMap<>();

    private EventBroker() {
    }

    /**
     * Get unique instance of EventBroker singleton.
     */
    public static synchronized EventBroker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventBroker();
        }

        return INSTANCE;
    }

    /**
     * Allow subscribers to subscribe to an event and define onEvent consumer.
     */
    @SuppressWarnings("unchecked")
    public synchronized <T extends Subscribable> void subscribe(
        Class<T> event, Consumer<T> consumer) {

        subscribers.computeIfAbsent(event, k -> new HashSet<>())
            .add((Consumer<? super Subscribable>) consumer);
    }

    /**
     * Allow subscribers to unsubscribe from event and its associated consumer.
     */
    @SuppressWarnings("unchecked")
    public synchronized <T extends Subscribable> void unsubscribe(
        Class<T> event, Consumer<T> consumer) {

        Set<Consumer<? super Subscribable>> consumers = subscribers.get(event);

        if (consumers != null) {
            consumers.remove((Consumer<? super Subscribable>) consumer);
            
            if (consumers.isEmpty()) {
                subscribers.remove(event);
            }
        }
    }

    /**
     * Applies the consumer on all subscribed to the event when publisher publishes the event.
     * Runs on Event Dispatch Thread (EDT).
     */
    public void publish(Subscribable event) {
        Set<Consumer<? super Subscribable>> consumers = subscribers.get(event.getClass());

        if (consumers != null) {
            for (Consumer<? super Subscribable> consumer : Set.copyOf(consumers)) {
                SwingUtilities.invokeLater(() -> consumer.accept(event));
            }
        }
    }
}