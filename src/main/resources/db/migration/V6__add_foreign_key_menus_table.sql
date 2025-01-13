alter table menus
add constraint menus_fk
foreign key(restaurant_id)
references restaurants(restaurant_id)
on delete cascade;