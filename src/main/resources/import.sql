insert into users(id, first_name, last_name,email, password,role) values(1, 'Jon', 'Terry','patvdc@gmail.com',' ','ADMIN');
insert into users(id, first_name, last_name,email, password,role) values(2, 'Vlad', 'Dracusorul','patvdc@gmail.com',' ','ADMIN');
insert into users(id, first_name, last_name,email, password,role) values(3, 'Ethel', 'Lufkvist','patvdc@gmail.com',' ','ADMIN');
insert into users(id, first_name, last_name,email, password,role) values(4, 'Samuel', 'Estiti','patvdc@gmail.com',' ','ADMIN');
insert into users(id, first_name, last_name, email, password,role) values (5,'pat','vdc','patvdc@gmail.com',' ','ADMIN');
insert into users(id, first_name, last_name, email, password,role) values (6,'johan','vdn','jvdn.java@gmail.com',' ','SALES');
insert into users(id, first_name, last_name, email, password,role) values (7,'ivo','stv','ivelinstamatov@gmail.com',' ','SALES');

insert into phone_numbers(id, number, type, contact_id) values(1, '0032/412597', 'LANDLINE', 1);
insert into phone_numbers(id, number, type, contact_id) values(2, '0031/457577', 'MOBILE', 2);
insert into phone_numbers(id, number, type, contact_id) values(3, '0032/452377', 'MOBILE', 1);

insert into contacts(id, first_name, last_name, picture, lead_status, email, owner_id) values(1, 'Patrick', 'Rules', null, 0, 'Patrick.Rules@crm.com',1);
insert into contacts(id, first_name, last_name, picture, lead_status, email, owner_id) values(2, 'Ivo', 'Rocks', null, 1, 'Ivo.Rocks@crm.com',1);
insert into contacts(id, first_name, last_name, picture, lead_status, email, owner_id) values(3, 'Johan', 'Owns', null, 2, 'Johan.Owns@crm.com',2);
insert into contacts(id, first_name, last_name, picture, lead_status, email, owner_id) values(4, 'Gertrude', 'De Nil', null, 3, 'Gertrude.Denil@crm.com',4);
insert into contacts(id, first_name, last_name, picture, lead_status, email, owner_id) values(5, 'Adelbrecht', 'Fonkel', null, 4, 'Adelbrecht.Fonkel@crm.com',2);

insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(1, 1, '9000', 'Gent', 'Lange Breestraat', '26', null);
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(2, 2, '2300', 'Kortrijk', 'Feeststraat', '144', null);
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(3, 3, '4400', 'Muizingen', 'Kerkhoflaan', '12', '6');
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(4, 4, '5242', 'Baasrode', 'Paddestraat', '10', null);
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(5, 5, '1834', 'Oostende', 'Lange munte', '4', null);

insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (1,1,"NEGOTIATION",136,1,1,1);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (2,2,"CONFIRMED",236,2,2,2);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (3,3,"CLOSED_WON",336,3,3,3);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (4,4,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (5,1,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (6,2,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (7,3,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (8,4,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (9,1,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (10,1,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (11,2,"CLOSED_LOST",436,4,4,4);
insert into quotes(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (12,2,"CLOSED_LOST",436,4,4,4);

insert into product(id, category, name, picture, unit_price) values(1,"PORTABLE","Toshiba 500",null,500);
insert into product(id, category, name, picture, unit_price) values(2,"PORTABLE","Toshiba 600",null,600);
insert into product(id, category, name, picture, unit_price) values(3,"PORTABLE","Toshiba 700",null,700);
insert into product(id, category, name, picture, unit_price) values(4,"LAPTOP","Asus 500",null,500);
insert into product(id, category, name, picture, unit_price) values(5,"LAPTOP","Asus 600",null,600);
insert into product(id, category, name, picture, unit_price) values(6,"LAPTOP","Asus 700",null,700);
insert into product(id, category, name, picture, unit_price) values(7,"SERVER","IBM 5000",null,5000);
insert into product(id, category, name, picture, unit_price) values(8,"SERVER","IBM 6000",null,6000);
insert into product(id, category, name, picture, unit_price) values(9,"SERVER","IBM 7000",null,7000);

