create table menus(
menu_id serial primary key,
name varchar(100) not null,
description varchar(100) not null,
price decimal,
created_at timestamp default current_timestamp,
updated_at timestamp default current_timestamp

)