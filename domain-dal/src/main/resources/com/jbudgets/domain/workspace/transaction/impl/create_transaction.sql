INSERT INTO transactions
(posted, assigned, amount, description, workspace_id, budget_id)
VALUES(
   :posted,
   :assigned,
   :amount,
   :description,
   :workspaceId,
   :budgetId
);