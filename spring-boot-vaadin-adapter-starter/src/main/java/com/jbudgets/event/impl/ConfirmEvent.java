package com.jbudgets.event.impl;

import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class ConfirmEvent extends AbstractComponentEvent {
    public ConfirmEvent(Widget producedBy) {
        super(producedBy);
    }

    public ConfirmEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
