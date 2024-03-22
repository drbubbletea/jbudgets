package com.jbudgets.domain.workspace.budget;

import java.util.List;

public interface BudgetRepository {

    List<Budget> budgets();

    int count();
}
