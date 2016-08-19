insert into fabricante (nome) values ("LG");
insert into categoria (nome, descricao) values ("Smartphone", "Celulares dos bons");
insert into produto (id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela) values (1, 1, "LG G2", "LG G3", 900.00, 30, 5);
insert into produto (id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela) values (1, 1, "LG G3", "LG G4", 1500.00, 30, 5);
insert into produto (id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela) values (1, 1, "LG G4", "LG G5", 1900.00, 30, 5);

insert into imagem (id_produto, imagem) values("1", "http://i1255.photobucket.com/albums/hh638/Marcos_Freitas_Parra/lg-g2_zpsj81euvbl.jpg");
insert into imagem (id_produto, imagem) values("2", "http://i1255.photobucket.com/albums/hh638/Marcos_Freitas_Parra/lgg3_zpszjj2bvyd.png");
insert into imagem (id_produto, imagem) values("3", "http://i1255.photobucket.com/albums/hh638/Marcos_Freitas_Parra/lgg4_zpswc22vjet.jpg");

update produto set promocao = 1 where id=1;
update produto set promocao = 1 where id=3;

