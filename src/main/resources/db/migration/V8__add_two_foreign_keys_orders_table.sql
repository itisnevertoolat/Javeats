alter table orders
add constraint users_fk
foreign key (user_id)
references users(user_id)
on delete cascade;

alter table orders
add constraint restaurant_fk
foreign key (restaurant_id)
references restaurants(restaurant_id)
on delete cascade;