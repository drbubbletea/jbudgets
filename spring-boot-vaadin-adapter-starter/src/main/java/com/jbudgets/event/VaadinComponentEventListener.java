package com.jbudgets.event;

@FunctionalInterface
public interface VaadinComponentEventListener<T extends ComponentEvent> {

    void onEvent(T event);
}
