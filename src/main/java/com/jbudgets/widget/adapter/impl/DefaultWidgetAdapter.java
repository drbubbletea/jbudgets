package com.jbudgets.widget.adapter.impl;

import com.jbudgets.widget.Widget;
import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultWidgetAdapter implements WidgetAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultWidgetAdapter.class);
    @Override
    public Optional<Widget> adapt(Object source, WidgetPurpose purpose) {
        LOG.info("Called");
        return Optional.empty();
    }
}
