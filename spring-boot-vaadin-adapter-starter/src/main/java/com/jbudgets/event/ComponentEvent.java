package com.jbudgets.event;


import com.jbudgets.widget.Widget;

import java.util.Optional;

public interface ComponentEvent {

    /**
     * The VaadinComponent that produced this event.
     * @return
     */
    Widget producedBy();

    /**
     * The data associated with this event.
     */
    <T> Optional<T> data(Class<T> dataClass);
}
