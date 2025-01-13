create table restaurants(
restaurant_id serial primary key,
name varchar(100) not null,
description varchar(100) not null,
location varchar(100) not null,
created_at timestamp default current_timestamp,
updated_at timestamp default current_timestamp

)