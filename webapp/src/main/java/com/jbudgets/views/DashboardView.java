package com.jbudgets.views;

import com.jbudgets.MainLayout;
import com.jbudgets.domain.workspace.CurrentWorkspaceProvider;
import com.jbudgets.domain.workspace.Workspace;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.inject.Inject;

//@PageTitle("My View")
@Route(value = "dashboard", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class DashboardView extends Composite<VerticalLayout> {

    @Inject
    public DashboardView(CurrentWorkspaceProvider currentWorkspaceProvider, WidgetAdapter adapter) {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        Workspace workspace = currentWorkspaceProvider.get();

        Widget widget = adapter.adapt(workspace, WidgetPurpose.DEFAULT).get();
        getContent().add(widget.get());

    }
}
