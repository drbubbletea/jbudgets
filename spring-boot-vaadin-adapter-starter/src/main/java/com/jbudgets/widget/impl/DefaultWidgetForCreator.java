package com.jbudgets.widget.impl;

import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetAdaptException;
import com.jbudgets.widget.WidgetForCreator;
import com.jbudgets.widget.adapter.WidgetPurpose;
import jakarta.inject.Inject;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

public class DefaultWidgetForCreator implements WidgetForCreator {

    private final ApplicationContext context;
    private final Class<?> widgetForClass;
    private final WidgetPurpose purpose;

    private final Constructor<?> constructor;

    private final Map<TypeVariable, Type> typeVariables;

    private final Annotation[][] parameterAnnotations;


    public DefaultWidgetForCreator(ApplicationContext  context, Class<?> widgetForClass, WidgetPurpose purpose) {
        this.context = context;
        this.widgetForClass = widgetForClass;
        this.purpose = purpose;
        this.constructor = getConstructor();
        this.typeVariables = GenericTypeResolver.getTypeVariableMap(widgetForClass);
        parameterAnnotations = constructor.getParameterAnnotations();;
    }
    @Override
    public Widget create(Object source) {
        Object[] parameters = getParameters(source);
        try {
            Object instance = constructor.newInstance(parameters);
            context.getAutowireCapableBeanFactory().autowireBean(instance);
            return (Widget) instance;
        } catch (Exception e) {
            throw new WidgetAdaptException("Failed to create instance. Possibly forgot to annotate @Source or @Purpose on the source constructor parameter?", e);
        }
    }

    /**
     * Get paramters for constructor while passing in the source class and purpose if applicable annotations are defined.
     */
    private Object[] getParameters(Object source) {
        Object[] parameters = new Object[constructor.getParameterCount()];
        for (int i = 0; i < parameters.length; i++) {
            for (Annotation annotation: parameterAnnotations[i]) {
                if (Source.class == annotation.annotationType()) {
                    parameters[i] = source;
                    break;
                } else if (Purpose.class == annotation.annotationType()) {
                    parameters[i] = purpose;
                    break;
                }
            }
            if (null == parameters[i]) {
                parameters[i] = context.getBean(GenericTypeResolver.resolveType(constructor.getGenericParameterTypes()[i], typeVariables));
            }
        }
        return parameters;
    }

    private Constructor<?> getConstructor() {
        for (Constructor<?> ctor: widgetForClass.getConstructors()) {
            if (ctor.isAnnotationPresent(Inject.class)) {
                return ctor;
            }
        }
        throw new WidgetAdaptException("No suitable constructor found with jakarata @Inject annotation");
    }
}
