package com.jbudgets.domain.user.impl;

import com.jbudgets.domain.user.User;
import com.jbudgets.domain.user.UserId;

public class DefaultUser implements User {

    private final UserId id;

    public DefaultUser(UserId id) {
        this.id = id;
    }

    @Override
    public UserId id() {
        return id;
    }
}
