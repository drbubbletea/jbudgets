package com.jbudgets.widget.user;

import com.jbudgets.domain.User;
import com.jbudgets.widget.Purpose;
import com.jbudgets.widget.Source;
import com.jbudgets.widget.Widget;
import com.jbudgets.widget.WidgetFor;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import jakarta.inject.Inject;

@WidgetFor(forClass = User.class, purpose = WidgetPurpose.VIEW)
public class UserViewWidget implements Widget {

    private final User user;
    private final WidgetPurpose purpose;

    private final VerticalLayout layout = new VerticalLayout();
    @Inject
    public UserViewWidget(@Source User user, @Purpose WidgetPurpose purpose) {
        this.user = user;
        this.purpose = purpose;
    }

    @Override
    public Component get() {
        return layout;
    }
}
