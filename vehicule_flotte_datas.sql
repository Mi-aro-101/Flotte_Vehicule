insert into marque (id_marque, des_marque) values 
	('MRQ0001', 'Toyota'),
	('MRQ0002', 'Mercedes');
	
insert into vehicule (id_vehicule, id_marque, des_vehicule) values
	('CAR0001', 'MRQ0001', 'Land Cruiser'),
	('CAR0002', 'MRQ0002', 'ML550');
	
insert into kilometrage (id_kilometrage, id_vehicule, date_kilometrage, debutkm, finkm) values
	('KMT0001', 'CAR0001', TO_DATE('2022-05-12', 'YYYY-MM-DD'), 0, 60.50),
	('KMT0002', 'CAR0002', TO_DATE('2022-06-05', 'YYYY-MM-DD'), 3600.00, 7000.00),
	('KMT0003', 'CAR0003', TO_DATE('2022-08-08', 'YYYY-MM-DD'), 2500.66, 8000.30);
	
insert into materiel (id_materiel, id_vehicule, des_materiel) values
	('MTR0001', 'Pneu'),
	('MTR0002', 'vidange'),

insert into materiel_vehicule (id_vehicule, id_materiel) values
	('CAR0001', 'MTR0001'),
	('CAR0001', 'MTR0002'),
	('CAR0002', 'MTR0001'),
	('cAR0002', 'MTR0002');
	
insert into entretien_materiel (id_materiel_vehicule, date_entretien, statut) values
	(1, TO_DATE('2023-05-12', 'YYYY-MM-DD'), 10),
	(2, TO_DATE('2023-05-12', 'YYYY-MM-DD'), 10),
	(3, TO_DATE('2023-06-05', 'YYYY-MM-DD'), 0),
	(4, TO_DATE('2023-06-05', 'YYYY-MM-DD'), 10);
	
insert into papier (id_papier, des_papier) values
	('PPR0001', 'Assurance'),
	('PPR0002', 'Carte grise'),

insert into papier_vehicule (id_vehicule, id_papier, duree_expiration) values
	('CAR0001', 'PPR0001', 90),
	('CAR0001', 'PPR0002', null),
	('CAR0002', 'PPR0001', 61),
	('CAR0002', 'PPR0002', null);