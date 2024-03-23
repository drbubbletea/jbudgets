package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class CancelEvent extends AbstractComponentEvent {
    public CancelEvent(Widget producedBy) {
        super(producedBy);
    }

    public CancelEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
