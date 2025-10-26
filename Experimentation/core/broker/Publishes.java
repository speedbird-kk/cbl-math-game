package Experimentation.core.broker;

import Experimentation.core.events.Subscribable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotation to mark methods that publish a Subscribable event.
 * Documentation purposes only.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Publishes {
    /**
     * Subscribable event the method publishes.
     */
    Class<? extends Subscribable> event();
}
