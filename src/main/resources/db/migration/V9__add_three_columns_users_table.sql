alter table users
add column is_account_non_expired boolean,
add column is_account_non_locked boolean,
add column is_credentials_non_expired boolean,
add column is_enabled boolean;