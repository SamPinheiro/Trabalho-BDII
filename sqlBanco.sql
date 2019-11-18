CREATE TABLE usuario
( idUsuario number NOT NULL,
  nome varchar2(50) NOT NULL,
  email varchar2(50) unique NOT NULL,
  senha varchar2(20) NOT NULL,
CONSTRAINT usuarioPk PRIMARY KEY (idUsuario)
);

create sequence incUsuario
    minValue 1
    MAXVALUE 300
    START WITH 1
    INCREMENT by 1
    Cache 100;

create table tipo(
    idTipo number not null,
    descricao varchar2(50) not null,
    CONSTRAINT tipoPk PRIMARY KEY (idTipo)
);

create sequence incTipo
    minValue 1
    MAXVALUE 300
    START WITH 1
    INCREMENT by 1
    Cache 100;

create table categoria(
    idCategoria number not null,
    descricao varchar2(50) not null,
    constraint categoriaPk primary key (idCategoria)
);

create sequence incCategoria
    minValue 1
    MAXVALUE 300
    START WITH 1
    INCREMENT by 1
    Cache 100;

create table item(
    idItem number not null,
    idTipo number not null,
    dataLancamento DATE not null,
    descricao varchar2(200) not null,
    download int,
    linkTrailer varchar2(100) not null,
    linkImagem varchar2(100) not null,
    constraint itemPk primary key(idItem),
    CONSTRAINT tipoFk FOREIGN KEY (idTipo) REFERENCES tipo(idTipo)
);

create sequence incItem
    minValue 1
    MAXVALUE 300
    START WITH 1
    INCREMENT by 1
    Cache 100;

create table itemCategoria(
   idItem number not null,
   idCategoria number not null,
   CONSTRAINT itemFk FOREIGN KEY (idItem) REFERENCES item(idItem),
   CONSTRAINT categoriaFk FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria)
);

create table ator(
   idAtor number not null,
   nome varchar2(50)not null,
   idade int not null,
   constraint atorPk primary key(idAtor)
);

create sequence incAtor
    minValue 1
    MAXVALUE 300
    START WITH 1
    INCREMENT by 1
    Cache 100;

create table itemAtor(
   idItem number not null,
   idAtor number not null,
   CONSTRAINT itemAtorFk FOREIGN KEY (idItem) REFERENCES item(idItem),
   CONSTRAINT atorItemFk FOREIGN KEY (idAtor) REFERENCES ator(idAtor)
);


