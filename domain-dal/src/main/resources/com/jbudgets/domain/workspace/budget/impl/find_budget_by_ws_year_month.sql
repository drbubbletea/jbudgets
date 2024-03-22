SELECT id, workspace_id, name
FROM budget
WHERE workspace_id = :workspaceId
ORDER BY name asc
LIMIT :limit
OFFSET :offset