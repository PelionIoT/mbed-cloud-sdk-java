/**
 *
 */
package com.arm.mbed.cloud.sdk.annotations;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(SOURCE)
@Target({ TYPE, PACKAGE })
/**
 * Defines source file preamble.
 *
 */
public @interface Preamble {
    String licence() default "/* ---------------------------------------------------------------------------\n"
                             + "* The confidential and proprietary information contained in this file may\n"
                             + "* only be used by a person authorised under and to the extent permitted\n"
                             + "* by a subsisting licensing agreement from Arm Limited or its affiliates.\n" + "*\n"
                             + "*       (C) COPYRIGHT 2017 Arm Limited or its affiliates.\n"
                             + "*           ALL RIGHTS RESERVED\n" + "*\n"
                             + "* This entire notice must be reproduced on all copies of this file\n"
                             + "* and copies of this file may only be made by a person if such person is\n"
                             + "* permitted to do so under the terms of a subsisting license agreement\n"
                             + "* from Arm Limited or its affiliates.\n"
                             + "--------------------------------------------------------------------------*/";

    /** @return Short description of the file. **/
    String description() default "N/A";

    /** @return Last version this API was changed. **/
    String lastApiModification() default "1.0.0";
}
