DROP TABLE endereco;
DROP TABLE servico;


CREATE TABLE IF NOT EXISTS endereco(
    id INT AUTO_INCREMENT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    municipio VARCHAR(30) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
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
    endereco_busca_id INT NOT NULL,
    endereco_entrega_id INT NOT NULL,
    largura INT NOT NULL,
    altura INT NOT NULL,
    comprimento INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(endereco_busca_id) REFERENCES endereco(id),
    FOREIGN KEY(endereco_entrega_id) REFERENCES endereco(id)
);

CREATE TABLE IF NOT EXISTS orcamento(
   id INT AUTO_INCREMENT NOT NULL,
   custo_embalagem  DOUBLE NOT NULL,
   taxa_desistencia  DOUBLE NOT NULL,
   valor  DOUBLE NOT NULL,
   prazo  INT NOT NULL,
   servico_id INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(servico_id) REFERENCES servico(id)
);
