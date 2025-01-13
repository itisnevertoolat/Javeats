create table users(
    user_id serial primary key,
    username varchar(100) not null,
    email varchar(200) not null unique,
    password varchar(200) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
)