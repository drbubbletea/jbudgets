package com.jbudgets.event.impl;

import com.jbudgets.event.ComponentEvent;
import com.jbudgets.event.ListenerRegistration;
import com.jbudgets.event.VaadinComponentEventBus;
import com.jbudgets.event.VaadinComponentEventListener;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * We have to deal with the lapsed listener problem here.
 */
public class DefaultVaadinComponentEventBus implements VaadinComponentEventBus {

    private Map<WeakReference<VaadinComponentEventListener<?>>, Class<? extends ComponentEvent>> listeners = new ConcurrentHashMap<>();

    @Override
    public <T extends ComponentEvent> ListenerRegistration listen(Class<T> event, VaadinComponentEventListener<T> listener) {
        WeakReference<VaadinComponentEventListener<?>> listenerReference = new WeakReference<>(listener);
        listeners.put(listenerReference, event);
        return new DefaultListenerRegistration(listenerReference, listeners);
    }

    @Override
    public <T extends ComponentEvent> void send(T event) {
        for (Map.Entry<WeakReference<VaadinComponentEventListener<?>>, Class<? extends ComponentEvent>> entry: listeners.entrySet()) {
            VaadinComponentEventListener listener = entry.getKey().get();
            if (null != listener) {
                if (event.getClass().equals(entry.getValue())) {
                    listener.onEvent(event);
                }
            } else {
                listeners.remove(entry.getKey());
            }
        }
    }
}
