package com.jbudgets.widget.transaction;

import com.jbudgets.domain.workspace.transaction.TransactionRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;
import net.timeboxing.spring.vaadin.widget.Purpose;
import net.timeboxing.spring.vaadin.widget.Source;
import net.timeboxing.spring.vaadin.widget.Widget;
import net.timeboxing.spring.vaadin.widget.WidgetFor;
import net.timeboxing.spring.vaadin.widget.adapter.WidgetPurpose;

@WidgetFor(forClass = TransactionRepository.class, purpose = WidgetPurpose.DEFAULT)
public class TransactionDashboardWidget implements Widget {

    private final TransactionRepository transactionRepository;
    private final WidgetPurpose purpose;
    private final VerticalLayout layout = new VerticalLayout();

    @Inject
    public TransactionDashboardWidget(@Source TransactionRepository transactionRepository, @Purpose WidgetPurpose purpose) {
        this.transactionRepository = transactionRepository;
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
        layout.add(new H1("Transactions"));
    }


    @Override
    public Component get() {
        return layout;
    }
}
