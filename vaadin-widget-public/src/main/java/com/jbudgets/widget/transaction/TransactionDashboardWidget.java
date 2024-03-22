package com.jbudgets.widget.transaction;

import com.jbudgets.domain.workspace.transaction.TransactionRepository;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;

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
