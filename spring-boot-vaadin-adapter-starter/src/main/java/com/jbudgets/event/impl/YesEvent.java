package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class YesEvent extends AbstractComponentEvent {
    public YesEvent(Widget producedBy) {
        super(producedBy);
    }

    public YesEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
