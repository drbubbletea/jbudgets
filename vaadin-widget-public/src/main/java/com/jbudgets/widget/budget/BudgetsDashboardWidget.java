package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;

@WidgetFor(forClass = BudgetRepository.class, purpose = WidgetPurpose.DEFAULT)
public class BudgetsDashboardWidget implements Widget {

    private final BudgetRepository budgetRepository;
    private final WidgetPurpose purpose;
    private final VerticalLayout layout = new VerticalLayout();

    @Inject
    public BudgetsDashboardWidget(@Source BudgetRepository budgetRepository, @Purpose WidgetPurpose purpose) {
        this.budgetRepository = budgetRepository;
        this.purpose = purpose;
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
