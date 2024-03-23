package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class DeleteEvent extends AbstractComponentEvent {
    public DeleteEvent(Widget producedBy) {
        super(producedBy);
    }

    public DeleteEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
