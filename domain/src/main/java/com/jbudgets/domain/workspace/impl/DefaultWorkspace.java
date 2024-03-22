package com.jbudgets.domain.workspace.impl;

import com.jbudgets.domain.workspace.Workspace;
import com.jbudgets.domain.workspace.WorkspaceId;
import com.jbudgets.domain.workspace.budget.Budget;

public class DefaultWorkspace implements Workspace {

    private final WorkspaceId id;

    public DefaultWorkspace(WorkspaceId id) {
        this.id = id;
    }
    @Override
    public WorkspaceId id() {
        return id;
    }

    @Override
    public void addBudget(Budget budget) {

    }
}
