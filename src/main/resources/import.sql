insert into lead_status(id, status) values(1, 'NEW')
insert into lead_status(id, status) values(2, 'CONTACTED')
insert into lead_status(id, status) values(3, 'MEETING')
insert into lead_status(id, status) values(4, 'WON')
insert into lead_status(id, status) values(5, 'LOST')

insert into contacts(id, first_name, last_name, address, picture, lead_status, email) values(1, 'Patrick', 'Rules', 1, null, 1, 'Patrick.Rules@crm.com')
insert into contacts(id, first_name, last_name, address, picture, lead_status, email) values(2, 'Ivo', 'Rocks', 2, null, 2, 'Ivo.Rocks@crm.com')
insert into contacts(id, first_name, last_name, address, picture, lead_status, email) values(3, 'Johan', 'Owns', 3, null, 3, 'Johan.Owns@crm.com')
insert into contacts(id, first_name, last_name, address, picture, lead_status, email) values(4, 'Gertrude', 'De Nil', 4, null, 4, 'Gertrude.Denil@crm.com')
insert into contacts(id, first_name, last_name, address, picture, lead_status, email) values(5, 'Adelbrecht', 'Fonkel', 5, null, 5, 'Adelbrecht.Fonkel@crm.com')

insert into addresses(id, zip_code, city, street_name, house_number, bus) values(1, '9000', 'Gent', 'Lange Breestraat', '26', null)
insert into addresses(id, zip_code, city, street_name, house_number, bus) values(2, '2300', 'Kortrijk', 'Feeststraat', '144', null)
insert into addresses(id, zip_code, city, street_name, house_number, bus) values(3, '4400', 'Muizingen', 'Kerkhoflaan', '12', '6')
insert into addresses(id, zip_code, city, street_name, house_number, bus) values(4, '5242', 'Baasrode', 'Paddestraat', '10', null)
insert into addresses(id, zip_code, city, street_name, house_number, bus) values(4, '1834', 'Oostende', 'Lange munte', '4', null)

