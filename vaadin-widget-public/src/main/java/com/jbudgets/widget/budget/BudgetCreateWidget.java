package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.widget.PublicWidgetFactory;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.inject.Inject;
import org.vaadin.lineawesome.LineAwesomeIcon;


@WidgetFor(forClass = BudgetRepository.class, purpose = WidgetPurpose.CREATE)
public class BudgetCreateWidget implements Widget {

    private final BudgetRepository budgetRepository;
    private final BudgetCreate create;
    private final VerticalLayout layout = new VerticalLayout();

    private final TextField name = new TextField("Name");

    private final Button add = new Button("Add");
    private final Button cancel = new Button("Cancel");

    @Inject
    public BudgetCreateWidget(@Source BudgetRepository budgetRepository, PublicWidgetFactory factory) {
        this.budgetRepository = budgetRepository;
        this.create = factory.budgetCreate();
        setup();
        layout();
        bind();
    }

    private void setup() {
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }

    private void bind() {
        // TODO: name trim
        // TODO: name max length 40
    }

    private void layout() {
        layout.add(name);
        layout.add(add);
        layout.add(cancel);
    }


    @Override
    public Component get() {
        return layout;
    }
}