package Experimentation.core.broker;

import Experimentation.core.events.Subscribable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark methods that subscribe to a Subscribable event.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface SubscribesTo {
    /**
     * Subscribable event method is subscribed to.
     */
    Class<? extends Subscribable> event();
}
