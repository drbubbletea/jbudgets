package com.jbudgets.domain.impl;

import com.jbudgets.domain.User;
import com.jbudgets.domain.DomainFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class DefaultDomainFactory implements DomainFactory {

    private final ApplicationContext context;
    public DefaultDomainFactory(ApplicationContext context) {
        this.context = context;
    }
    @Override
    public User create() {
        return context.getBean(DefaultUser.class);
    }
}
