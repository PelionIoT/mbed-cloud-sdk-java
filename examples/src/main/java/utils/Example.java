package utils;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 *
 * Specifies blocks of code that are SDK examples
 *
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Example {
    // No fields.
}
