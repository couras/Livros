insert into autor (nome)values('Denis Couras');
insert into autor (nome)values('Cubas');
insert into autor (nome)values('José da silva');

INSERT INTO  LIVRO (titulo, foto, quantidade, id_autor ) VALUES ('Use a cabeça Java','image01.jpg',300,1 );
INSERT INTO  LIVRO (titulo, foto, quantidade, id_autor ) VALUES ('Java como programar','image01.jpg',500,2 );
INSERT INTO  LIVRO (titulo, foto, quantidade, id_autor ) VALUES ('Spring boot','image01.jpg',200,3 );
INSERT INTO  LIVRO (titulo, foto, quantidade, id_autor ) VALUES ('Spring boot 69','image01.jpg',200,3 );

insert into CAD_CLIENTE ( nome, endereco, cli_data) values ('denis', 'rua tiradentes 100', '1979-01-01');
insert into CAD_CLIENTE (nome, endereco, cli_data) values ('eliana', 'rua tiradentes 101', '1980-01-01');
insert into CAD_CLIENTE ( nome, endereco, cli_data) values ('maria', 'rua tiradentes 200', '1959-01-01');

insert into usuario ( user_name, email, password) values ('denis', 'a@a.com', '827ccb0eea8a706c4c34a16891f84e7b');
insert into usuario (user_name, email, password) values ('eliana', 'a@a.com', '827ccb0eea8a706c4c34a16891f84e7b');
insert into usuario ( user_name, email, password) values ('maria', 'a@a.com', '827ccb0eea8a706c4c34a16891f84e7b');

insert into emprestimo ( data_emprestimo, data_devolucao, id_livro, id_usuario)values ('2018-01-01', '2018-01-10', 1, 1);
insert into emprestimo ( data_emprestimo, data_devolucao, id_livro, id_usuario)values ('2018-01-01', NULL, 2, 2);
insert into emprestimo ( data_emprestimo, data_devolucao, id_livro, id_usuario)values ('2018-01-01', NULL, 3, 3);

insert into review (avaliacao, comentatio, id_livro, id_usuario) values (2, 'legal', 1, 1);
insert into review (avaliacao, comentatio, id_livro, id_usuario) values (5, 'bacana', 2, 2);
insert into review (avaliacao, comentatio, id_livro, id_usuario) values (3, 'não gostei muito', 3, 3);