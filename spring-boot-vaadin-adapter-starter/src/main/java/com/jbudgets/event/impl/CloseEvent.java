package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class CloseEvent extends AbstractComponentEvent {
    public CloseEvent(Widget producedBy) {
        super(producedBy);
    }

    public CloseEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
