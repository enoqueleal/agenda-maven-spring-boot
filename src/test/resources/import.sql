insert into endereco (ID, CEP, LOGRADOURO) values (1,'04865-000','Av. Interlagos, 100');
insert into endereco (ID, CEP, LOGRADOURO) values (2,'04865-001','Av. Washington Luís, 100');

insert into contato (ID, EMAIL, TELEFONE) values (1,'michael_thomas@outlook.com','1198455-0000');
insert into contato (ID, EMAIL, TELEFONE) values (2,'george_alexander@outlook.com','1198000-0000');

insert into pessoa (ID, NOME, DATA_NASCIMENTO, CONTATO_ID, ENDERECO_ID) values (1,'Michael Thomas','1990-05-03',1,1);
insert into pessoa (ID, NOME, DATA_NASCIMENTO, CONTATO_ID, ENDERECO_ID) values (2,'George Alexander','1989-02-03',2,2);