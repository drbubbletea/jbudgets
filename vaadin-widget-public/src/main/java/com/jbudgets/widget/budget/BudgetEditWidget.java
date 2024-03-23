package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.Budget;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;
import net.timeboxing.spring.vaadin.widget.Source;
import net.timeboxing.spring.vaadin.widget.Widget;
import net.timeboxing.spring.vaadin.widget.WidgetFor;
import net.timeboxing.spring.vaadin.widget.adapter.WidgetPurpose;


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