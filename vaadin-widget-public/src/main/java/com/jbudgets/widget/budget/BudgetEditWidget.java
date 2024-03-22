package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.Budget;
import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;


@WidgetFor(forClass = Budget.class, purpose = WidgetPurpose.EDIT)
public class BudgetEditWidget implements Widget {

    private final Budget budget;
    private final VerticalLayout layout = new VerticalLayout();

    @Inject
    public BudgetEditWidget(@Source Budget budget) {
        this.budget = budget;
        setup();
        layout();
        bind();
    }

    private void setup() {

    }

    private void bind() {

    }

    private void layout() {

    }

    @Override
    public Component get() {
        return layout;
    }
}