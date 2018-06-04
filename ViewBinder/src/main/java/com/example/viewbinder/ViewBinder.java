package com.example.viewbinder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mac on 2018/6/5.
 */

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD })
public @interface ViewBinder {

    int value() default -1;

}
