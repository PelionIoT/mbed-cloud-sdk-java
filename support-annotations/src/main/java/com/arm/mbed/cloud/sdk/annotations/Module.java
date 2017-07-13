package com.arm.mbed.cloud.sdk.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Preamble(description = "Specifies an SDK module")
@Documented
@Retention(RUNTIME)
@Target({ TYPE })
public @interface Module {
}
