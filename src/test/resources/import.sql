insert into endereco (ID, CEP, LOGRADOURO) values (1L,'04865-000','Av. Interlagos, 100');
insert into endereco (ID, CEP, LOGRADOURO) values (2L,'04865-001','Av. Washington Luís, 100');

insert into contato (ID, EMAIL, TELEFONE) values (1L,'michael_thomas@outlook.com','1198455-0000');
insert into contato (ID, EMAIL, TELEFONE) values (2L,'george_alexander@outlook.com','1198000-0000');

insert into pessoa (ID, NOME, DATA_NASCIMENTO, CONTATO_ID, ENDERECO_ID) values (1L,'Michael Thomas','1990-05-03',1L,1L);
insert into pessoa (ID, NOME, DATA_NASCIMENTO, CONTATO_ID, ENDERECO_ID) values (2L,'George Alexander','1989-02-03',2L,2L);