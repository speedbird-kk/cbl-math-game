package Experimentation.core.broker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotation to mark event with its publisher.
 */
@Target(ElementType.MODULE)
@Retention(RetentionPolicy.SOURCE)
public @interface PublishedBy {
    /**
     * Publisher of the Subscribable event.
     */
    Class<?> publisher();
}
