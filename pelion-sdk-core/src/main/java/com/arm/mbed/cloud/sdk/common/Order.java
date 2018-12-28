package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description="Ordering options")public enum Order implements SdkEnum{ASC("ASC"),DESC("DESC"),UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

private final String value;

/**
 * Constructor.
 * 
 * @param value
 *            string representation
 */
Order(String value){this.value=value;}

/**
 * Gets string representation.
 * 
 * @see Object#toString()
 */
@Override public String toString(){return getString();}

/**
 * Gets order from its string representation.
 * 
 * @param str
 *            string
 * @return corresponding order or default if not recognised
 */
public static Order getOrderOrDefault(String str){return parseOrder(str,getDefault());}

/**
 * Parses a string and returns corresponding Order value or defaultValue if the order could not be identified.
 * 
 * @param str
 *            string to parse
 * @param defaultValue
 *            default value to apply if parsing failed.
 * @return corresponding order or defaultValue when parsing failed;
 */
public static Order parseOrder(String str,Order defaultValue){if(str==null||str.isEmpty()){return defaultValue;}if(ASC.toString().equalsIgnoreCase(str)){return ASC;}if(DESC.toString().equalsIgnoreCase(str)){return DESC;}return defaultValue;}

/**
 * Gets default order.
 * 
 * @return default order.
 */
public static Order getDefault(){return ASC;}

/**
 * Gets Unknown state value.
 * 
 * @return unknown state.
 */
public static Order getUnknownEnum(){return UNKNOWN_ENUM;}

/**
 * Gets string representation.
 * 
 * @see SdkEnum#getString()
 */
@Override public String getString(){return value;}

/**
 * States whether it is the default value.
 * 
 * @see SdkEnum#isDefault()
 */
@Override public boolean isDefault(){return this==getDefault();}

/**
 * States whether the value is unknown and an error happened during parsing.
 * 
 * @see SdkEnum#isUnknownValue()
 */
@Override public boolean isUnknownValue(){return this==getUnknownEnum();}

/**
 * Merges two orders.
 * 
 * @see SdkEnum#merge(SdkEnum, SdkEnum)
 */
@Override public<T extends SdkEnum>T merge(T obj1,T obj2){if(obj1==null){return obj2;}if(obj2==null){return obj1;}if(obj1.isDefault()){return obj2;}if(obj2.isDefault()){return obj1;}return obj2;}}
