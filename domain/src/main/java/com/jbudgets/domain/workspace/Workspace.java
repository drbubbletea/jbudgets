package com.jbudgets.domain.workspace;

import com.jbudgets.domain.user.User;
import com.jbudgets.domain.workspace.budget.Budget;

import javax.money.CurrencyUnit;
import java.util.List;

public interface Workspace {

    WorkspaceId id();

    void addBudget(Budget budget);
}
