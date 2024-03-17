package com.jbudgets.widget.adapter.impl;

import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetForCreator;
import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DefaultWidgetAdapter implements WidgetAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultWidgetAdapter.class);
    private final Map<Class<?>, Map<WidgetPurpose, WidgetForCreator>> sourcePurposeWidgetMap;

    public DefaultWidgetAdapter(Map<Class<?>, Map<WidgetPurpose, WidgetForCreator>> sourcePurposeWidgetMap) {
        this.sourcePurposeWidgetMap = sourcePurposeWidgetMap;
    }

    // TODO: caching the creator from a source class and purpose may be a good addition here
    @Override
    public Optional<Widget> adapt(Object source, WidgetPurpose purpose) {
        LOG.info("Called");
        WidgetForCreator creator = null;

        // TODO: room for optimization here. may be a way to specify candidates but not resolve function calls until necessary
        List<Class<?>> candidateClasses = new ArrayList<>();
        candidateClasses.add(source.getClass());
        candidateClasses.addAll(Arrays.asList(source.getClass().getInterfaces()));
        candidateClasses.add(source.getClass().getSuperclass());
        candidateClasses.addAll(Arrays.asList(source.getClass().getSuperclass().getInterfaces()));

        for (Class<?> candidate: candidateClasses) {
            creator = findCreator(candidate, purpose);
            if (null != creator) {
                break;
            }
        }

        return Optional.of(creator.create(source));
    }

    private WidgetForCreator findCreator(Class<?> sourceClass, WidgetPurpose purpose) {
        if (sourcePurposeWidgetMap.containsKey(sourceClass)) {
            Map<WidgetPurpose, WidgetForCreator> creators = sourcePurposeWidgetMap.get(sourceClass);
            if (creators.containsKey(purpose)) {
                return creators.get(purpose);
            } else if (creators.containsKey(WidgetPurpose.DEFAULT)) {
                return creators.get(WidgetPurpose.DEFAULT);
            }
        }
        return null;
    }
}
