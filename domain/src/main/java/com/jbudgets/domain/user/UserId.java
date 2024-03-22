package com.jbudgets.domain.user;

public class UserId {
    private final Integer value;
    private UserId(Integer value) {
        this.value = value;
    }

    public static UserId from(Integer value) {
        return new UserId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Integer value() {
        return value;
    }
}
