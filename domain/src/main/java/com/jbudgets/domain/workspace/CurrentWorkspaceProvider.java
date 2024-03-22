package com.jbudgets.domain.workspace;

import jakarta.inject.Provider;

import java.util.concurrent.atomic.AtomicReference;

public class CurrentWorkspaceProvider implements Provider<Workspace> {

    private final AtomicReference<Workspace> reference = new AtomicReference<>();
    @Override
    public Workspace get() {
        return reference.get();
    }

    public void set(Workspace workspace) {
        reference.set(workspace);
    }
}
