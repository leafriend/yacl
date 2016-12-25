package com.leafriend.yacl.lang;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides utility method for lambda expression.
 *
 * @author leafriend
 */
public class Lambda {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lambda.class);

    private static final String CALLABLE_FAILURE_MESSAGE = "Failled to call Callable";

    public static <V> V wrapTrying(final Callable<V> callable) {
        try {
            return callable.call();
        } catch (Exception e) { // NOPMD
            // Avoid catching generic exceptions such as NullPointerException,
            // RuntimeException, Exception in try-catch block
            LOGGER.error(CALLABLE_FAILURE_MESSAGE, e);
            throw new LambdaException(CALLABLE_FAILURE_MESSAGE, e);
        }

    }

}
