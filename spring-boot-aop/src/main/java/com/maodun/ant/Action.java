package com.maodun.ant;

import java.lang.annotation.*;

/**
 * @author tongjian
 * @date 2020/9/16 9:51
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Action {
    String name();
}
