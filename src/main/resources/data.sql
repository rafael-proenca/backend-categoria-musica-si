-- CREATE OR REPLACE SCHEMA dml;

USE dml;




INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (1, 'MPB');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (2, 'Rock');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (3, 'Vira');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (4, 'Bossa Nova');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (5, 'Jazz');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (6, 'Pop rock');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (7, 'Eletronic');
INSERT INTO categoria (cod_categoria, desc_categoria) VALUES (8, 'Pop');


INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (1, 1, 240, 'Amor I love you');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (2, 1, 300, 'Nao e facil');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (3, 1, 250, 'Gentileza');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (4, 2, 500, 'Daniel na cova dos leoes');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (5, 2, 322, 'Fabrica');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (6, 2, 440, 'Tempo perdido');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (7, 2, 312, 'Acrilic on canvas');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (8, 3, 298, 'Vira-vira');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (9, 4, 348, 'Chega de saudade');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (10, 4, 231, 'Luiza');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (11, 4, 355, 'Aguas de marco');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (12, 4, 250, 'Wave');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (13, 6, 333, 'Politik');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (14, 6, 225, 'Green eyes');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (15, 6, 440, 'A Rush of Blood to the head');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (16, 6, 320, 'Clocks');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (17, 6, 300, 'Codinome beija-flor');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (18, 6, 290, 'Faz parte do meu show');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (19, 5, 446, 'New York');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (20, 8, 299, 'Solitudine');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (21, 1, 430, 'Oceano');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (22, 2, 511, 'With or without you');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (23, 2, 300, 'Beautiful day');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (24, 2, 458, 'Bullet The Blue Sky');
INSERT INTO musica (cod_musica, cod_categoria, duracao, titulo) VALUES (25, 1, 300, 'Sua');

-- no maria db
/*
Delimiter $$
CREATE PROCEDURE proc_adicione_tempo(IN int_valor INT)

BEGIN
    UPDATE musica
    SET duracao = duracao + int_valor;
END $$;
DELIMITER ;

USE dml;
Delimiter $$
CREATE PROCEDURE proc_subtrai_tempo(IN int_valor INT)

BEGIN
    UPDATE musica
    SET duracao = duracao -  int_valor;
END $$;
DELIMITER ;

USE dml;
CALL proc_adicione_tempo(1000);
*/