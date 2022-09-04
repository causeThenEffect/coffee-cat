package com.cause.request.repeat.annotation;

import java.lang.annotation.*;

/**
 *
 * @author causeThenEffect
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestRepeatIntercept {

    String value();

}
