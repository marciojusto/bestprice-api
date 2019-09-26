CREATE TABLE secao (
	id_secao INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO secao (nome) VALUES ('Higiene');
INSERT INTO secao (nome) VALUES ('Limpeza');
INSERT INTO secao (nome) VALUES ('Peixaria');
INSERT INTO secao (nome) VALUES ('Charcutaria');
INSERT INTO secao (nome) VALUES ('Bebidas');

