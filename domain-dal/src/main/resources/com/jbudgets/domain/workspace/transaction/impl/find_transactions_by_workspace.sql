SELECT id, posted, assigned, amount, description, workspace_id, budget_id
FROM transactions
WHERE workspace_id = :workspaceId
ORDER BY assigned desc;