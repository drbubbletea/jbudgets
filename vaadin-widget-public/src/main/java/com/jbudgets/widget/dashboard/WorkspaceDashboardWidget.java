package com.jbudgets.widget.dashboard;

import com.jbudgets.domain.workspace.Workspace;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;
import net.timeboxing.spring.vaadin.widget.Purpose;
import net.timeboxing.spring.vaadin.widget.Source;
import net.timeboxing.spring.vaadin.widget.Widget;
import net.timeboxing.spring.vaadin.widget.WidgetFor;
import net.timeboxing.spring.vaadin.widget.adapter.WidgetPurpose;

@WidgetFor(forClass = Workspace.class, purpose = WidgetPurpose.DEFAULT)
public class WorkspaceDashboardWidget implements Widget {

    private final Workspace workspace;
    private final WidgetPurpose purpose;
    private final VerticalLayout layout = new VerticalLayout();

    @Inject
    public WorkspaceDashboardWidget(@Source Workspace workspace, @Purpose WidgetPurpose purpose) {
        this.workspace = workspace;
        this.purpose = purpose;
        setup();
        layout();
        bind();
    }

    private void setup() {
        // test


    }

    private void bind() {

    }

    private void layout() {
        layout.add(new H1("Dashboard"));
    }


    @Override
    public Component get() {
        return layout;
    }
}
