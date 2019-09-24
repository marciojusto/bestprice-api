create table preco (
	id_produto int not null,
	id_mercado int not null,
	data DATE NOT NULL,
	valor decimal(5,2) not null,
	PRIMARY KEY (id_produto, id_mercado, data)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table preco 
	add constraint fk_produto_pk foreign key (id_produto) REFERENCES produto (id) ON DELETE CASCADE ON UPDATE CASCADE,
	add constraint fk_mercado_pk foreign key (id_mercado) REFERENCES mercado (id) ON DELETE CASCADE ON UPDATE CASCADE;