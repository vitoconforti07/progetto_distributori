
CREATE SCHEMA  v_0_2;

SET search_path TO v_0_2;

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
cod_provincia int unique,
nome_provincia varchar unique,
sigla_provincia varchar unique,
cod_regione_fk int,
geometria varchar,

CONSTRAINT fk_provincia
      FOREIGN KEY(cod_regione_fk) 
        REFERENCES Regione(id_regione)

);

create table comune(
id_comune serial  primary key,
cod_comune int unique,
nome_comune varchar,
id_provincia_fk int,
geometria varchar,

CONSTRAINT fk_comune
      FOREIGN KEY(id_provincia_fk) 
        REFERENCES Provincia(id_provincia)
);

drop table distributore; 


create table tipo_bandiera(
id_tipo_bandiera serial primary key,
tipo_bandiera varchar(500)
); 

create table tipo_impianto(
id_tipo_impianto serial primary key,
tipo_impianto varchar(500)
);

create table distributore(
id_impianto serial primary key,
cod_impianto int unique,
gestore varchar(500),
tipo_bandiera_fk int,
tipo_impianto_fk int,
nome_impianto varchar(500),
indirizzo varchar(500),
id_comune_fk int,
latitudine double precision,
longitudine double precision,

CONSTRAINT fk_tipo_bandiera
      FOREIGN KEY(tipo_bandiera_fk) 
        REFERENCES tipo_bandiera(id_tipo_bandiera),
CONSTRAINT fk_tipo_impianto
      FOREIGN KEY(tipo_impianto_fk) 
        REFERENCES tipo_impianto(id_tipo_impianto),

 CONSTRAINT fk_distributore
      FOREIGN KEY(id_comune_fk) 
        REFERENCES Comune(id_comune)
);


create table tipo_carburante(
id_tipo_carburante serial primary key,
tipo_carburante varchar(500)
);

drop table prezzi_distributore;

create table prezzi_distributore(
id_prezzo serial primary key,
id_impianto_fk int,
tipo_carburante_fk int,
prezzo numeric,
is_self boolean,
data_comunicazione timestamp,
CONSTRAINT fk_prezzi_distributore
      FOREIGN KEY(id_impianto_fk) 
        REFERENCES distributore(id_impianto),
CONSTRAINT fk_tipo_carburante
      FOREIGN KEY(tipo_carburante_fk) 
        REFERENCES tipo_carburante(id_tipo_carburante)

);