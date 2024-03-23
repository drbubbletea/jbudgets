package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.widget.PublicWidgetFactory;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;
import jakarta.inject.Inject;
import net.timeboxing.spring.vaadin.event.VaadinComponentEventBus;
import net.timeboxing.spring.vaadin.event.impl.CancelEvent;
import net.timeboxing.spring.vaadin.widget.Source;
import net.timeboxing.spring.vaadin.widget.Widget;
import net.timeboxing.spring.vaadin.widget.WidgetFor;
import net.timeboxing.spring.vaadin.widget.adapter.WidgetPurpose;


@WidgetFor(forClass = BudgetRepository.class, purpose = WidgetPurpose.CREATE)
public class BudgetCreateWidget implements Widget {

    private final BudgetRepository budgetRepository;
    private final BudgetCreate create;
    private final VerticalLayout layout = new VerticalLayout();

    private final TextField name = new TextField("Name");

    private final Button add = new Button("Add");
    private final Button cancel = new Button("Cancel");

    private final VaadinComponentEventBus eventBus;

    private final Binder<BudgetCreate> binder = new Binder<>();

    @Inject
    public BudgetCreateWidget(@Source BudgetRepository budgetRepository, PublicWidgetFactory factory, VaadinComponentEventBus eventBus) {
        this.budgetRepository = budgetRepository;
        this.create = factory.budgetCreate();
        this.eventBus = eventBus;
        setup();
        layout();
        bind();
    }

    private void setup() {
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        add.addClickListener(event -> {
            binder.validate();
            if (binder.isValid()) {
                System.out.println("OK");
            }
        });
        cancel.addClickListener(event -> eventBus.send(new CancelEvent(this)));
    }

    private void bind() {
        binder.setBean(create);
        binder.forField(name)
                .asRequired()
                .withValidator(new StringLengthValidator("Max length is 40", 0, 40))
                .bind(BudgetCreate::getName, BudgetCreate::name);
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