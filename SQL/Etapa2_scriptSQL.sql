-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-07-16 19:33:26.873

CREATE DATABASE ecommerce;
USE ecommerce;

-- tables
-- Table: Categoria
CREATE TABLE categoria (
    id int NOT NULL AUTO_INCREMENT,
    nome char(100) NOT NULL,
    descricao varchar(500) NULL,
    CONSTRAINT Categoria_pk PRIMARY KEY (id)
);

-- Table: Cliente
CREATE TABLE cliente (
    id int NOT NULL AUTO_INCREMENT,
    tipoCliente char(1) NOT NULL,
    nome varchar(50) NOT NULL,
    razaoSocial varchar(50) NULL,
    email varchar(80) NULL,
    endereco varchar(80) NULL,
    cep char(8) NULL,
    rg char(9) NULL,
    cpf char(11) NULL,
    cnpj char(14) NULL,
    telefone char(11) NULL,
    CONSTRAINT Cliente_pk PRIMARY KEY (id)
);

-- Table: Fabricante
CREATE TABLE fabricante (
    id int NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    CONSTRAINT Fabricante_pk PRIMARY KEY (id)
);

-- Table: Imagem
CREATE TABLE imagem (
    id int NOT NULL AUTO_INCREMENT,
    id_produto int NOT NULL,
    imagem varchar(10000) NOT NULL,
    CONSTRAINT Imagem_pk PRIMARY KEY (id)
);

-- Table: ItemPedido
CREATE TABLE itemPedido (
    id int NOT NULL AUTO_INCREMENT,
    id_pedido int NOT NULL,
    id_produto int NOT NULL,
    quantidade int NOT NULL,
    CONSTRAINT ItemPedido_pk PRIMARY KEY (id)
);

-- Table: Pedido
CREATE TABLE pedido (
    id int NOT NULL AUTO_INCREMENT,
    id_cliente int NOT NULL,
    data timestamp NOT NULL,
    CONSTRAINT Pedido_pk PRIMARY KEY (id)
);

-- Table: Produto
CREATE TABLE produto (
    id int NOT NULL AUTO_INCREMENT,
    id_categoria int NOT NULL,
    id_fabricante int NOT NULL,
    modelo varchar(100) NOT NULL,
    descricao varchar(500) NULL,
    valor double(10,2) NOT NULL,
    duracaoBateria int NULL,
    tamanhoTela int NULL,
    CONSTRAINT Produto_pk PRIMARY KEY (id)
);

-- Table: Usuario
CREATE TABLE usuario (
    id int NOT NULL AUTO_INCREMENT,
    id_cliente int NOT NULL,
    login char(10) NOT NULL,
    senha varchar(200) NULL,
    nome char(100) NULL,
    cpf char(11) NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Cliente_Usuario (table: Usuario)
ALTER TABLE usuario ADD CONSTRAINT Cliente_Usuario FOREIGN KEY Cliente_Usuario (id_cliente)
    REFERENCES cliente (id);

-- Reference: Fabricante_Produto (table: Produto)
ALTER TABLE produto ADD CONSTRAINT Fabricante_Produto FOREIGN KEY Fabricante_Produto (id_fabricante)
    REFERENCES fabricante (id);

-- Reference: Imagem_Produto (table: Imagem)
ALTER TABLE imagem ADD CONSTRAINT Imagem_Produto FOREIGN KEY Imagem_Produto (id_produto)
    REFERENCES produto (id);

-- Reference: ItemPedido_Pedido (table: ItemPedido)
ALTER TABLE itemPedido ADD CONSTRAINT ItemPedido_Pedido FOREIGN KEY ItemPedido_Pedido (id_pedido)
    REFERENCES pedido (id);

-- Reference: ItemPedido_Produto (table: ItemPedido)
ALTER TABLE itemPedido ADD CONSTRAINT ItemPedido_Produto FOREIGN KEY ItemPedido_Produto (id_produto)
    REFERENCES produto (id);

-- Reference: Pedido_Cliente (table: Pedido)
ALTER TABLE pedido ADD CONSTRAINT Pedido_Cliente FOREIGN KEY Pedido_Cliente (id_cliente)
    REFERENCES cliente (id);

-- Reference: Produto_Categoria (table: Produto)
ALTER TABLE produto ADD CONSTRAINT Produto_Categoria FOREIGN KEY Produto_Categoria (id_categoria)
    REFERENCES categoria (id);

-- End of file.

