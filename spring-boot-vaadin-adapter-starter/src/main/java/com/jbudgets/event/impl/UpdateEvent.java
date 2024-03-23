package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class UpdateEvent extends AbstractComponentEvent {
    public UpdateEvent(Widget producedBy) {
        super(producedBy);
    }

    public UpdateEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
