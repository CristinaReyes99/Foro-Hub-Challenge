CREATE TABLE topicos(
    id bigint NOT NULL AUTO_INCREMENT,
    titulo varchar(100) NOT NULL UNIQUE,
    mensaje varchar(200) NOT NULL UNIQUE,
    autor varchar(30) NOT NULL,
    curso varchar(30) NOT NULL,
    PRIMARY KEY (id)
);