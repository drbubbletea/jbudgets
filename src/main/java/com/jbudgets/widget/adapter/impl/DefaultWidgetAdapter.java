package com.jbudgets.widget.adapter.impl;

import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetForCreator;
import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

public class DefaultWidgetAdapter implements WidgetAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultWidgetAdapter.class);
    private final Map<Class<?>, Map<WidgetPurpose, WidgetForCreator>> sourcePurposeWidgetMap;

    public DefaultWidgetAdapter(Map<Class<?>, Map<WidgetPurpose, WidgetForCreator>> sourcePurposeWidgetMap) {
        this.sourcePurposeWidgetMap = sourcePurposeWidgetMap;
    }

    // TODO: caching the creator from a source class and purpose would be a good addition here
    @Override
    public Optional<Widget> adapt(Object source, WidgetPurpose purpose) {
        LOG.info("Called");
        WidgetForCreator creator = null;
        // source class
        creator = findCreator(source.getClass(), purpose);
        if (null == creator) {
            LOG.info("Did not find class for {}", source.getClass());
        }
        // try interfaces?
        for (Class<?> classInterface: source.getClass().getInterfaces()) {
            creator = findCreator(classInterface, purpose);
            if (null != creator) {
                break;
            }
        }
        return Optional.of(creator.create(source));
    }

    private WidgetForCreator findCreator(Class<?> sourceClass, WidgetPurpose purpose) {
        LOG.info("Checking for source class {}", sourceClass);
        if (sourcePurposeWidgetMap.containsKey(sourceClass)) {
            Map<WidgetPurpose, WidgetForCreator> creators = sourcePurposeWidgetMap.get(sourceClass);
            if (creators.containsKey(purpose)) {
                return creators.get(purpose);
            } else if (creators.containsKey(WidgetPurpose.DEFAULT)) {
                return creators.get(WidgetPurpose.DEFAULT);
            }
        }
        LOG.info("... did not find creator");
        return null;
    }
}
