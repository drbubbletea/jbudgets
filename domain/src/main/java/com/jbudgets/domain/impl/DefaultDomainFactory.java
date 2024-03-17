package com.jbudgets.domain.impl;

import com.jbudgets.domain.user.User;
import com.jbudgets.domain.DomainFactory;
import com.jbudgets.domain.user.impl.DefaultUser;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


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
