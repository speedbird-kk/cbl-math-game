package Experimentation.core.broker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark events with its subscriber.
 * Documentation purposes only.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface SubscribedBy {
    /**
     * Subscriber of the Subscribable event.
     */
    Class<?> subscriber();
}
