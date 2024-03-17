package com.jbudgets.domain.workspace;

public class WorkspaceId {

    private final Integer value;
    private WorkspaceId(Integer value) {
        this.value = value;
    }

    public static WorkspaceId from(Integer value) {
        return new WorkspaceId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Integer value() {
        return value;
    }
}
