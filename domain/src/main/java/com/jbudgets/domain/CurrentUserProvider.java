package com.jbudgets.domain;

import com.jbudgets.domain.user.User;
import jakarta.inject.Provider;

public class CurrentUserProvider implements Provider<User> {

    @Override
    public User get() {
        return null;
    }
}
