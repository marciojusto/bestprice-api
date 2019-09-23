CREATE TABLE mercado (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL,
	id_secao INT,
	CONSTRAINT fk_secao FOREIGN KEY (id_secao) REFERENCES secao (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;