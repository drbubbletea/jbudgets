package com.jbudgets.widget.budget;

import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.event.ListenerRegistrations;
import com.jbudgets.event.VaadinComponentEventBus;
import com.jbudgets.event.impl.CancelEvent;
import com.jbudgets.event.impl.DefaultListenerRegistrations;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.ArrayList;
import java.util.List;

@WidgetFor(forClass = BudgetRepository.class, purpose = WidgetPurpose.DEFAULT)
public class BudgetsDashboardWidget implements Widget {

    private final BudgetRepository budgetRepository;
    private final WidgetPurpose purpose;
    private final VerticalLayout layout = new VerticalLayout();
    private final Button add = new Button("Add", LineAwesomeIcon.PLUS_CIRCLE_SOLID.create());
    private final VerticalLayout display = new VerticalLayout();
    private final VerticalLayout dashboardDisplay = new VerticalLayout();
    private final WidgetAdapter adapter;

    private final List<Widget> displayWidget = new ArrayList<>();

    private final ListenerRegistrations registrations = new DefaultListenerRegistrations();

    private final VaadinComponentEventBus eventBus;

    @Inject
    public BudgetsDashboardWidget(@Source BudgetRepository budgetRepository, @Purpose WidgetPurpose purpose, WidgetAdapter adapter, VaadinComponentEventBus eventBus) {
        this.budgetRepository = budgetRepository;
        this.purpose = purpose;
        this.adapter = adapter;
        this.eventBus = eventBus;
        setup();
        layout();
        bind();
    }

    private void setup() {
        add.addClickListener(event -> {
            clearDisplay();
            displayCreate();
        });
        displayDashboard();
        add.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    }

    private void displayCreate() {
        Widget widget = adapter.adapt(budgetRepository, WidgetPurpose.CREATE).get();
        displayWidget.add(widget);
        display.add(widget.get());
        registrations.add(eventBus.listen(CancelEvent.class, this::onExitCreate));
    }

    private void displayDashboard() {
        dashboardDisplay.add(add);
        display.add(dashboardDisplay);
    }
    private void clearDisplay() {
        registrations.removeAll();
        displayWidget.clear();
        display.removeAll();
    }

    private void onExitCreate(CancelEvent cancelEvent) {
        clearDisplay();
        displayDashboard();
    }

    private void bind() {

    }

    private void layout() {
        layout.add(new H1("Budgets"));
        layout.add(display);
    }


    @Override
    public Component get() {
        return layout;
    }
}
