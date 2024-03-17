package com.jbudgets.domain.workspace.transaction;

import com.jbudgets.domain.workspace.WorkspaceId;

public class TransactionId {
    private final Integer value;
    private TransactionId(Integer value) {
        this.value = value;
    }

    public static TransactionId from(Integer value) {
        return new TransactionId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Integer value() {
        return value;
    }
}
