
use ecommerce;

insert into fabricante(nome) values('Samsung');
insert into fabricante(nome) values('Apple');
insert into fabricante(nome) values('Microsoft');
insert into fabricante(nome) values('Nokia');
insert into fabricante(nome) values('Sony');
insert into fabricante(nome) values('LG');
insert into fabricante(nome) values('HTC');
insert into fabricante(nome) values('Motorola');
insert into fabricante(nome) values('Lenovo');
insert into fabricante(nome) values('Acer');
insert into fabricante(nome) values('Asus');

update categoria set nome = 'Smartphones' where nome = 'Smartphone';
insert into categoria (nome) values ("Tablets");
insert into categoria (nome) values ("Equipamentos");
insert into categoria (nome) values ("Acessórios");
insert into categoria (nome) values ("PCs e Laptops");
insert into categoria (nome) values ("Áudio");

insert into produto(id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela) 
 values (6, 6, "Caixa Multimídia Bluetooth", "Caixa Multimídia 20W Bluetooth/Microfone SRS-X2 Preta SONY", 
 549.90, 0, 0);

insert into produto(id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela)
 values (1, 2, "Sony Xperia Z3", "Sony Xperia Z3 Android 4.4 Tela 5.2 16GB 4GWi-Fi Câmera 20.7MP - Branco + Pulseira SmartBand", 
 3399.00, 48, 5.2);

insert into produto(id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela)
 values (2, 3, "iPad Mini 4", "iPad Mini 4 16GB Wi-Fi 7.9 8MP Cinza Espacial", 2924.99, 72, 7.9);

insert into produto(id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela)
 values (5, 11, "Notebook Acer Aspire", "Notebook Acer Aspire ES1-431-C494 Intel Quad Core - 4GB 500GB LED 14 Windows 10",
 1471.55, 5, 14);

insert into produto(id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela)
 values (3, 2, "Impressora Laser Monocromática", "Impressora Samsung Laser Monocromática Sl-M2020 - Usb 2.0, 127 V",
 479.90, 0, 0);

insert into produto(id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela)
 values (4, 3, "Carregador Apple 60w", "Fonte Carregador Magsafe 60w Para Apple Macbook E Pro 13 -13.3 - 16,5v 3.65a",
 139.00, 0, 0);
