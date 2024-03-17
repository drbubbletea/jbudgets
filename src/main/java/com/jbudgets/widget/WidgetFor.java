package com.jbudgets.widget;

import com.jbudgets.widget.adapter.WidgetPurpose;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface WidgetFor {

    Class<?> forClass();

    WidgetPurpose purpose() default WidgetPurpose.DEFAULT;
}
