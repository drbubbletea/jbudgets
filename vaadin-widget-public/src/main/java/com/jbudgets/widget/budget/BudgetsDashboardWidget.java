package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;
import org.vaadin.lineawesome.LineAwesomeIcon;

@WidgetFor(forClass = BudgetRepository.class, purpose = WidgetPurpose.DEFAULT)
public class BudgetsDashboardWidget implements Widget {

    private final BudgetRepository budgetRepository;
    private final WidgetPurpose purpose;
    private final VerticalLayout layout = new VerticalLayout();
    private final Button add = new Button("Add", LineAwesomeIcon.PLUS_CIRCLE_SOLID.create());
    @Inject
    public BudgetsDashboardWidget(@Source BudgetRepository budgetRepository, @Purpose WidgetPurpose purpose) {
        this.budgetRepository = budgetRepository;
        this.purpose = purpose;
        setup();
        layout();
        bind();
    }

    private void setup() {
        add.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    }

    private void bind() {

    }

    private void layout() {
        layout.add(new H1("Budgets"));
        layout.add(add);

    }


    @Override
    public Component get() {
        return layout;
    }
}
