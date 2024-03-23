package com.jbudgets.event.impl;

import com.jbudgets.event.ComponentEvent;
import com.jbudgets.event.ListenerRegistration;
import com.jbudgets.event.VaadinComponentEventListener;

import java.lang.ref.WeakReference;
import java.util.Map;

public class DefaultListenerRegistration implements ListenerRegistration {

    private final VaadinComponentEventListener<?> listener;
    private final WeakReference<VaadinComponentEventListener<?>> reference;

    private final Map<WeakReference<VaadinComponentEventListener<?>>, Class<? extends ComponentEvent>> listeners;

    public DefaultListenerRegistration(WeakReference<VaadinComponentEventListener<?>> reference, Map<WeakReference<VaadinComponentEventListener<?>>, Class<? extends ComponentEvent>> listeners) {
        this.reference = reference;
        this.listener = reference.get();
        this.listeners = listeners;
    }
    @Override
    public void unregister() {
        listeners.remove(reference);
    }
}
