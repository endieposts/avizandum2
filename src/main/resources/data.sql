insert into TERRAIN (ID, NAME) values (1, 'Bog');
insert into TERRAIN (ID, NAME) values (2, 'Forest');
insert into TERRAIN (ID, NAME) values (3, 'Plains');
insert into TERRAIN (ID, NAME) values (4, 'Desert');
insert into TERRAIN (ID, NAME) values (5, 'Loch');
insert into TERRAIN (ID, NAME) values (6, 'Ocean');

insert into DISTRICT (ID, DOMAIN_ID, TERRAIN_ID , NAME) values (1, 2, 1, 'Bogtown');
insert into DISTRICT (ID, DOMAIN_ID, TERRAIN_ID , NAME) values (2, 1, 2, 'Tabula Rasa');

insert into DOMAIN (ID, NAME, OWNER_ID) values (2, 'Bogtopia', 2);
insert into DOMAIN (ID, NAME, OWNER_ID) values (1, 'Unowned', 1);
