package com.arm.mbed.cloud.sdk.annotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Preamble(description = "Specifies that a method is defined but its functionality is not yet implemented")
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ METHOD, CONSTRUCTOR })
public @interface NotImplemented {

}
