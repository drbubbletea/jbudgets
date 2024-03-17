package com.jbudgets.widget.adapter;

import com.jbudgets.widget.Widget;

import java.util.Optional;

public interface WidgetAdapter {

    Optional<Widget> adapt(Object source, WidgetPurpose purpose);
}
