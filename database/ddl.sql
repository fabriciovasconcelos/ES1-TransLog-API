CREATE DATABASE IF NOT EXISTS translog;

CREATE TABLE IF NOT EXISTS endereco(
    id INT AUTO_INCREMENT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    municipio VARCHAR(30) NOT NULL,
    rua VARCHAR(30) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(70) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS servico(
    id INT AUTO_INCREMENT NOT NULL,
    peso DOUBLE NOT NULL,
    descricao VARCHAR(250) NOT NULL,
    endereco_id INT NOT NULL,
    largura INT NOT NULL,
    altura INT NOT NULL,
    comprimento INT NOT NULL,
    primary key(id),
    FOREIGN KEY(endereco_id) REFERENCES endereco(id)
);


