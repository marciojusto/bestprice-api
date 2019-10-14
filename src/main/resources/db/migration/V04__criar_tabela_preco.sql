create table preco (
	id_preco BIGINT(20) AUTO_INCREMENT,
	id_produto BIGINT(20) NOT NULL,
	id_mercado INT NOT NULL,
	data DATE NOT NULL,
	valor decimal(5,2) NOT NULL,
	status TINYINT(1) NOT NULL DEFAULT 1,
	constraint fk_produto_pk foreign key (id_produto) REFERENCES produto (id_produto),
	constraint fk_mercado_pk foreign key (id_mercado) REFERENCES mercado (id_mercado),
	PRIMARY KEY (id_preco, id_produto, id_mercado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ALTER TABLE produto
--	ADD COLUMN id_preco BIGINT(20);
	
-- ALTER TABLE mercado
--	ADD id_preco BIGINT(20);

-- ALTER TABLE produto
--	ADD CONSTRAINT fk_preco_produto FOREIGN KEY (id_preco) REFERENCES preco (id_preco) ON DELETE CASCADE;
	
-- ALTER TABLE mercado
--	ADD CONSTRAINT fk_preco_mercado FOREIGN KEY (id_preco) REFERENCES preco (id_preco) ON DELETE CASCADE;