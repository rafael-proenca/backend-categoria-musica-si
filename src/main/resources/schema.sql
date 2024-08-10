-- executar no maria db
-- CREATE OR REPLACE schema dml;
CREATE or replace table categoria  (
    cod_categoria integer NOT NULL auto_increment,
    desc_categoria character varying(50)  ,
     CONSTRAINT categoria_pkey PRIMARY KEY (cod_categoria)
);

CREATE or replace table musica (
    cod_musica integer NOT NULL AUTO_INCREMENT,
    cod_categoria integer NOT NULL,
    duracao integer,
    titulo character varying(100),
    CONSTRAINT musica_pkey PRIMARY KEY (cod_musica),
    CONSTRAINT musica_cod_categoria_fkey FOREIGN KEY (cod_categoria) REFERENCES categoria(cod_categoria)
);

