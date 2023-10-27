-- d1atabase name : vehicule_flotte

create table marque(
	id_marque VARCHAR(7) primary key not null, --prefix : MRQ
	des_marque VARCHAR(50) not null
);

create table vehicule(
	id_vehicule VARCHAR(7) primary key not null, -- prefix : CAR
	id_marque VARCHAR(7) REFERENCES marque(id_marque) not null,
	des_vehicule VARCHAR(50) not null
);

create table kilometrage(
	id_kilometrage VARCHAR(7) primary key not null, -- prefix : KMT
	id_vehicule VARCHAR(7) REFERENCES vehicule(id_vehicule), not null
	date_kilometrage date not null,
	debutkm double precision default 0,
	finkm double precision not null
);

create table materiel(
	id_materiel VARCHAR(7) primary key not null, --prefix : MTR
	des_materiel VARCHAR(50)
);

create table materiel_vehicule(
	id_materiel_vehicule serial primary key not null,
	id_vehicule VARCHAR(7) REFERENCES vehicule(id_vehicule) not null,
	id_materiel VARCHAR(7) REFERENCES materiel(id_materiel) not null
);

create table entretien_materiel(
	id_entretien_materiel serial primary key not null,
	id_materiel_vehicule int references materiel(id_materiel) not null,
	date_entretien date not null,
	statut int not null
);

create table papier(
	id_papier VARCHAR(7) primary key not null, --prefix : PPR
	des_papier VARCHAR(50) not null
);

create table papier_vehicule(
	id_papier_vehicule serial primary key not null, 
	id_vehicule VARCHAR(7) REFERENCES vehicule(id_vehicule) not null,
	id_papier VARCHAR(7) REFERENCES papier(id_papier) not null,
	duree_expiration INT default null -- En jour
);


