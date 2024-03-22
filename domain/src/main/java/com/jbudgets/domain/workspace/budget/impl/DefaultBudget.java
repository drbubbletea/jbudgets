package com.jbudgets.domain.workspace.budget.impl;

import com.jbudgets.domain.workspace.budget.Budget;
import com.jbudgets.domain.workspace.budget.BudgetId;

public class DefaultBudget implements Budget {

    private final BudgetId id;
    private final String name;

    public DefaultBudget(BudgetId id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public BudgetId id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void save() {

    }
}
