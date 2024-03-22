package com.jbudgets.domain.workspace.budget;

public class BudgetId {
    private final Integer value;
    private BudgetId(Integer value) {
        this.value = value;
    }

    public static BudgetId from(Integer value) {
        return new BudgetId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Integer value() {
        return value;
    }
}
