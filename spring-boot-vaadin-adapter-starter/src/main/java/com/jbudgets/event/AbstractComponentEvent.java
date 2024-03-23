package com.jbudgets.event;


import com.jbudgets.widget.Widget;

import java.util.Optional;

public abstract class AbstractComponentEvent implements ComponentEvent {

    private final Widget producedBy;
    private final Object data;

    protected AbstractComponentEvent(Widget producedBy) {
        this.producedBy = producedBy;
        this.data = null;
    }

    protected AbstractComponentEvent(Widget producedBy, Object data) {
        this.producedBy = producedBy;
        this.data = data;
    }

    @Override
    public Widget producedBy() {
        return producedBy;
    }

    @Override
    public <T> Optional<T> data(Class<T> dataClass) {
        if (null == data) {
            return Optional.empty();
        }
        if (dataClass.isAssignableFrom(data.getClass())) {
            return Optional.of(dataClass.cast(data));
        } else {
            throw new VaadinEventException(String.format("Data class '%s' not of specified class '%s'", data.getClass().getName(), dataClass.getName()));
        }
    }
}
