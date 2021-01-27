/**
 * 
 */
package com.goh.gcommons.reflection.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * <strong>ReflectionUtils.java</strong><br>
 * Reflection utilities.<br>
 * <br>
 * Version control:<br>
 * <ol>
 * <li>1.0.0 | 27/01/2021 | Gustavo Olivares Hernandez |
 * golivaresh.dev@gmail.com</li>
 * </ol>
 * 
 * @author golivaresh
 * @version 1.0.0
 * @since 1.0.0
 * 
 */

public final class ReflectionUtils {

    /**
     * Constructor of ReflectionUtils.
     */
    private ReflectionUtils() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Method that gets the value of the specified field.
     * 
     * @param field
     *            Field to get the value.
     * @param object
     *            Object for the obtain the field value.
     * @return Value obtained from the field.
     */
    public static Object getterValue(final Field field, final Object object) {
        if (object == null) {
            return null;
        }
        for (Method method : object.getClass().getMethods()) {
            if (isFieldGetter(method, field)) {
                try {
                    // Invoke method.
                    return method.invoke(object);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // An error occurred when obtain the field value.
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Method to validate if the method is of type getter and belongs to the
     * specified field.
     * 
     * @param method
     *            {@link Method} object to validate.
     * @param field
     *            {@link Field} object to validate.
     * @return True if the method corresponds to the field, false otherwise.
     */
    private static final boolean isFieldGetter(final Method method, final Field field) {
        if (method == null || field == null) {
            return Boolean.FALSE;
        }
        return (method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)
                && method.getName().toLowerCase().endsWith(field.getName().toLowerCase()));
    }

}
