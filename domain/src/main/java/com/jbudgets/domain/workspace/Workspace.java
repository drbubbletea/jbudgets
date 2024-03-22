package com.jbudgets.domain.workspace;

import com.jbudgets.domain.workspace.budget.Budget;

public interface Workspace {

    WorkspaceId id();

    void addBudget(Budget budget);
}
