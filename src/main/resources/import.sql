insert into contacts(id, first_name, last_name, picture, lead_status, email) values(1, 'Patrick', 'Rules', null, 0, 'Patrick.Rules@crm.com');
insert into contacts(id, first_name, last_name, picture, lead_status, email) values(2, 'Ivo', 'Rocks', null, 1, 'Ivo.Rocks@crm.com');
insert into contacts(id, first_name, last_name, picture, lead_status, email) values(3, 'Johan', 'Owns', null, 2, 'Johan.Owns@crm.com');
insert into contacts(id, first_name, last_name, picture, lead_status, email) values(4, 'Gertrude', 'De Nil', null, 3, 'Gertrude.Denil@crm.com');
insert into contacts(id, first_name, last_name, picture, lead_status, email) values(5, 'Adelbrecht', 'Fonkel', null, 4, 'Adelbrecht.Fonkel@crm.com');

insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(1, 1, '9000', 'Gent', 'Lange Breestraat', '26', null);
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(2, 2, '2300', 'Kortrijk', 'Feeststraat', '144', null);
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(3, 3, '4400', 'Muizingen', 'Kerkhoflaan', '12', '6');
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(4, 4, '5242', 'Baasrode', 'Paddestraat', '10', null);
insert into addresses(id, contact_id, zip_code, city, street_name, house_number, bus) values(5, 5, '1834', 'Oostende', 'Lange munte', '4', null);

insert into users(id, first_name, last_name, email, password) values (1,'pat','vdc','patvdc@gmail.com',' ');
insert into users(id, first_name, last_name, email, password) values (2,'johan','vdn','jvdn.java@gmail.com',' ');
insert into users(id, first_name, last_name, email, password) values (3,'ivo','stv','ivelinstamatov@gmail.com',' ');