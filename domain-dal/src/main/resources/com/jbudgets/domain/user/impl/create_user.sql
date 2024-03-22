INSERT INTO app_user (email, password, enabled, locked)
VALUES (
    :username,
    :password,
    'Y',
    'N'
)