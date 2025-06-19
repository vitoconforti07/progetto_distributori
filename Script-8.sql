CREATE SCHEMA  v_0_1;

SET search_path TO v_0_1;

drop table comune;
drop table provincia; 
drop table regione;

create table regione(
id_regione serial  primary key,
cod_regione int unique,
nome_regione varchar(50) unique,
geometria varchar
);

create table provincia(
id_provincia serial  primary key,
codProvincia int unique,
nomeProvincia varchar unique,
siglaProvincia varchar unique,
codRegione_fk int,
geometria varchar,

CONSTRAINT fk_provincia
      FOREIGN KEY(codRegione_fk) 
        REFERENCES Regione(id_regione)

);

create table comune(
id_comune serial  primary key,
codComune int unique,
nomeComune varchar,
id_provincia_fk int,
geometria varchar,

CONSTRAINT fk_comune
      FOREIGN KEY(id_provincia_fk) 
        REFERENCES Provincia(id_provincia)
);

drop table distributore; 

create table distributore(
idImpianto serial primary key,
Gestore varchar(500),
Bandiera varchar(500),
Tipo_Impianto varchar(500),
Nome_Impianto varchar(500),
Indirizzo varchar(500),
Comune varchar(500),
Provincia varchar(500),
Latitudine varchar(500),
Longitudine varchar(500)
);