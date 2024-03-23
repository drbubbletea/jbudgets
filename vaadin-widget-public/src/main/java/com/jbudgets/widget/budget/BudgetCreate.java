package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.BudgetDAL;
import jakarta.inject.Inject;

public class BudgetCreate {
    private String name;

    private final BudgetDAL budgetDAL;

    @Inject
    public BudgetCreate(BudgetDAL budgetDAL) {
        this.budgetDAL = budgetDAL;
    }

    public void save() {
//        budgetDAL.;
    }

    public String getName() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }
}
