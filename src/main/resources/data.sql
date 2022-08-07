insert into avizandum2.TERRAIN (ID, NAME) values (1, 'Bog');
insert into avizandum2.TERRAIN (ID, NAME) values (2, 'Forest');
insert into avizandum2.TERRAIN (ID, NAME) values (3, 'Plains');
insert into avizandum2.TERRAIN (ID, NAME) values (4, 'Desert');
insert into avizandum2.TERRAIN (ID, NAME) values (5, 'Loch');

insert into avizandum2.DISTRICT (ID, DOMAIN_ID, TERRAIN_ID , NAME) values (1, 2, 1, 'Bogtown');
insert into avizandum2.DISTRICT (ID, DOMAIN_ID, TERRAIN_ID , NAME) values (2, 1, 2, 'Tabula Rasa');

insert into avizandum2.DOMAIN (ID, NAME, OWNER_ID) values (2, 'Bogtopia', 2);
insert into avizandum2.DOMAIN (ID, NAME, OWNER_ID) values (1, 'Unowned', 1);
