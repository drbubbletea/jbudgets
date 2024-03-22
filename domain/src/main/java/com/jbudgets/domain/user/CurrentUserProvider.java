package com.jbudgets.domain.user;

import com.jbudgets.domain.user.User;
import jakarta.inject.Provider;

import java.util.concurrent.atomic.AtomicReference;

public class CurrentUserProvider implements Provider<User> {

    private AtomicReference<User> reference = new AtomicReference<>();

    @Override
    public User get() {
        return reference.get();
    }

    public void set(User user) {
        reference.set(user);
    }
}
