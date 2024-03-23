package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class CreateEvent extends AbstractComponentEvent {
    public CreateEvent(Widget producedBy) {
        super(producedBy);
    }

    public CreateEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
