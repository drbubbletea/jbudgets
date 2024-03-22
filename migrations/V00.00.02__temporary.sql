-- allow us to avoid user registration and login for now
INSERT INTO budgets.app_user (id, email, password, enabled, locked, created) VALUES(1, 'test@example.com', 'test', 'Y', 'N', current_timestamp());

INSERT INTO budgets.workspace (id, owner_user_id, created) VALUES(1, 1, current_timestamp());