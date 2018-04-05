insert into users(id, first_name, last_name) values(1, 'Jon', 'Terry');
insert into users(id, first_name, last_name) values(2, 'Vlad', 'Dracusorul');
insert into users(id, first_name, last_name) values(3, 'Ethel', 'Lufkvist');
insert into users(id, first_name, last_name) values(4, 'Samuel', 'Estiti');
insert into users(id, first_name, last_name, email, password) values (5,'pat','vdc','patvdc@gmail.com',' ');
insert into users(id, first_name, last_name, email, password) values (6,'johan','vdn','jvdn.java@gmail.com',' ');
insert into users(id, first_name, last_name, email, password) values (7,'ivo','stv','ivelinstamatov@gmail.com',' ');

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

insert into quote(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (1,1,"NEGOTIATION",136,1,1,1);
insert into quote(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (2,2,"CONFIRMED",236,2,2,2);
insert into quote(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (3,3,"CLOSED_WON",336,3,3,3);
insert into quote(id, contact_id, stage, total, billing_address_id, owner_id, shipping_address_id) values (4,4,"CLOSED_LOST",436,4,4,4);