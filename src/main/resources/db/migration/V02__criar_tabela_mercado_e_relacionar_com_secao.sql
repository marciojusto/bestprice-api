CREATE TABLE mercado (
	id_mercado INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE mercado_secao (
	id_mercado INT,
	id_secao INT,
	CONSTRAINT fk_mercado_ms_pk FOREIGN KEY (id_mercado) REFERENCES mercado (id_mercado),
	CONSTRAINT fk_secao_ms_pk FOREIGN KEY (id_secao) REFERENCES secao (id_secao),
	PRIMARY KEY (id_mercado, id_secao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;