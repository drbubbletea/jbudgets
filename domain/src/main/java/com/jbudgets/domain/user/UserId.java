package com.jbudgets.domain.user;

import com.jbudgets.domain.workspace.WorkspaceId;

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
