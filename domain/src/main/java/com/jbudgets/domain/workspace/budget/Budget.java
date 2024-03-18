package com.jbudgets.domain.workspace.budget;

public interface Budget {

    BudgetId id();

    String name();

    void save();
}
