/**
 * 
 */
package com.arm.mbed.cloud.sdk.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Preamble(description = "Specifies that the annotated method has a role in starting/stopping a daemon task")
@Documented
@Retention(RUNTIME)
@Target(METHOD)

public @interface Daemon {
    /**
     * Daemon Task name or description
     * 
     * @return task name of the daemon
     */
    String task() default "N/A";

    /**
     * Specifies whether the method should be used to start the daemon
     * 
     * @return whether the method should be used to start the daemon
     */
    boolean start() default false;

    /**
     * Specifies whether the method should be used to stop the daemon
     * 
     * @return whether the method should be used to stop the daemon
     */
    boolean stop() default false;

    /**
     * Specifies whether the method should be used to shutdown the daemon service
     * 
     * @return whether the method should be used to shutdown the daemon service
     */
    boolean shutdown() default false;
}
