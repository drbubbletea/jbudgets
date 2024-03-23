package com.jbudgets.widget.user;

import com.jbudgets.domain.TestService;
import com.jbudgets.domain.user.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;
import net.timeboxing.spring.vaadin.widget.Purpose;
import net.timeboxing.spring.vaadin.widget.Source;
import net.timeboxing.spring.vaadin.widget.Widget;
import net.timeboxing.spring.vaadin.widget.WidgetFor;
import net.timeboxing.spring.vaadin.widget.adapter.WidgetPurpose;

@WidgetFor(forClass = User.class, purpose = WidgetPurpose.VIEW)
public class UserViewWidget implements Widget {

    private final User user;
    private final WidgetPurpose purpose;

    private final TestService testService;

    private final VerticalLayout layout = new VerticalLayout();
    @Inject
    public UserViewWidget(@Source User user, @Purpose WidgetPurpose purpose, TestService testService) {
        this.user = user;
        this.purpose = purpose;
        this.testService = testService;
        setup();
    }

    private void setup() {
        layout.add(new H3("User View"));
        testService.doSomething();
    }

    @Override
    public Component get() {
        return layout;
    }
}
