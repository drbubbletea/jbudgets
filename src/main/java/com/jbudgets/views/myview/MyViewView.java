package com.jbudgets.views.myview;

import com.jbudgets.domain.DomainFactory;
import com.jbudgets.domain.User;
import com.jbudgets.views.MainLayout;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.inject.Inject;

@PageTitle("My View")
@Route(value = "my-view", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class MyViewView extends Composite<VerticalLayout> {

    @Inject
    public MyViewView(DomainFactory domainFactory, WidgetAdapter adapter) {
        User user = domainFactory.create();

        Widget widget = adapter.adapt(user, WidgetPurpose.VIEW).get();
        getContent().add(widget.get());
    }

    public MyViewView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
