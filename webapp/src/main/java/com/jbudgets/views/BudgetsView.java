package com.jbudgets.views;

import com.jbudgets.MainLayout;
import com.jbudgets.domain.user.CurrentUserProvider;
import com.jbudgets.domain.user.User;
import com.jbudgets.domain.workspace.budget.BudgetRepository;
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

@Route(value = "budgets", layout = MainLayout.class)
@RouteAlias(value = "budgets", layout = MainLayout.class)
@Uses(Icon.class)
public class BudgetsView extends Composite<VerticalLayout> {

    @Inject
    public BudgetsView(BudgetRepository budgetRepository, WidgetAdapter adapter) {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");

        Widget widget = adapter.adapt(budgetRepository, WidgetPurpose.DEFAULT).get();
        getContent().add(widget.get());

    }
}