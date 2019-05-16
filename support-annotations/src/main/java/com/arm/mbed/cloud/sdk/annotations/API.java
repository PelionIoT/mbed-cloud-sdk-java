package com.arm.mbed.cloud.sdk.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation.
 */
@Preamble(description = "Specifies a SDK method")
@Documented
@Retention(RUNTIME)
@Target({ METHOD })
public @interface API {

}
