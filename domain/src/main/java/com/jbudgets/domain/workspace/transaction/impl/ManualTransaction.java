package com.jbudgets.domain.workspace.transaction.impl;

import com.jbudgets.domain.workspace.transaction.Transaction;
import com.jbudgets.domain.workspace.transaction.TransactionId;

public class ManualTransaction implements Transaction {
    @Override
    public TransactionId id() {
        return null;
    }
}
