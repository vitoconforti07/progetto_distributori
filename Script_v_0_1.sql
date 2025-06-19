
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


create table distributore(
id_impianto serial primary key,
cod_impianto int unique,
gestore varchar(500),
bandiera varchar(500),
tipo_impianto varchar(500),
nome_impianto varchar(500),
indirizzo varchar(500),
id_comune_fk int,
latitudine double precision,
longitudine double precision,

CONSTRAINT fk_distributore
      FOREIGN KEY(id_comune_fk) 
        REFERENCES Comune(id_comune)
);

drop table prezzi_distributore;

create table prezzi_distributore(
id_prezzo serial primary key,
id_impianto_fk int,
desc_carburante varchar(500),
prezzo numeric,
is_self boolean,
data_comunicazione timestamp,
CONSTRAINT fk_prezzi_distributore
      FOREIGN KEY(id_impianto_fk) 
        REFERENCES distributore(id_impianto)
);

insert into prezzi_distributore (id_impianto_fk, descCarburante, prezzo,isSelf, dtComu) values (3464,	'Benzina', 2.327, false, to_timestamp('05/03/2024 22:00', 'DD/MM/YYYY hh24:mi'));
select p.* from "Progetto_distributori_V_0.1".v_0_1.provincia  p
inner join "Progetto_distributori_V_0.1".v_0_1.regione r 
on p.codregione_fk  = r.id_regione 
where r.nome_regione = 'Piemonte';

select d.id_impianto ,d.cod_impianto  from distributore d; 

select * from prezzi_distributore pd 
where pd.id_impianto_fk in (17685, 17785 ,17786 ,17787, 17788,17789, 17790, 17792, 17793, 17794);

--select * from prezzi_distributore pd where pd.data_comunicazione =  

SELECT * FROM pg_catalog.pg_tables where schemaname ='v_0_1';

select count( distinct(d.bandiera)) as "numero bandiera" , count( distinct(d.tipo_impianto)) as "tipo impianto"  , count (*) as "numero impianti" from distributore d;

select count( distinct(d.tipo_impianto)) as "tipo impianto", d.tipo_impianto
from distributore d
group by d.tipo_impianto;
