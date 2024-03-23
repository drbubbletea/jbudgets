package com.jbudgets.event.impl;


import com.jbudgets.event.AbstractComponentEvent;
import com.jbudgets.widget.Widget;

public class NoEvent extends AbstractComponentEvent {

    public NoEvent(Widget producedBy) {
        super(producedBy);
    }

    public NoEvent(Widget producedBy, Object data) {
        super(producedBy, data);
    }
}
