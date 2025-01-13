create table orders(
order_id serial primary key,
status varchar(100) not null,
created_at timestamp default current_timestamp,
updated_at timestamp default current_timestamp

)