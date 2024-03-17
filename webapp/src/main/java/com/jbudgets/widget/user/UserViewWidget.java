package com.jbudgets.widget.user;

import com.jbudgets.TestService;
import com.jbudgets.domain.user.User;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;

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
