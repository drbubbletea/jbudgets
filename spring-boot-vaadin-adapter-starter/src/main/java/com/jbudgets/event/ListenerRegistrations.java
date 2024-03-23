package com.jbudgets.event;


public interface ListenerRegistrations {

    void add(ListenerRegistration registration);

    void removeAll();
}
