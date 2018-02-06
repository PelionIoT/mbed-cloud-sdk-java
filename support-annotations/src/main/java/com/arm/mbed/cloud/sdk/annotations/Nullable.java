/**
 * 
 */
package com.arm.mbed.cloud.sdk.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Preamble(description = "Specifies that the element (e.g. field, method, etc) can return null value.")
@Documented
@Retention(CLASS)
@Target({ TYPE, FIELD, METHOD, PARAMETER, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE })
public @interface Nullable {

}
