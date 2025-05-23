CREATE DATABASE tit_bank;
USE tit_bank;

CREATE TABLE clientes (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE contas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(20) NOT NULL,
    saldo DECIMAL(15,2) NOT NULL DEFAULT 0,
    cliente_cpf VARCHAR(14) NOT NULL,
    FOREIGN KEY (cliente_cpf) REFERENCES clientes(cpf)
);

CREATE TABLE chaves_pix (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    chave VARCHAR(100) NOT NULL UNIQUE,
    conta_id BIGINT NOT NULL,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

CREATE TABLE transacoes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL(15,2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    conta_id BIGINT NOT NULL,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);


INSERT INTO clientes (cpf, nome, senha)
VALUES ('123.456.789-10', 'João Silva', 'senha123'),
('333.333.333-10','Maria Jósé dos Santos', 'senha123456' ),
('111.111.111-11', 'Mario Alberto', '123456789'),
('222.222.222-22', 'Suzana Rodrigues', '101112'),
('444.444.444-44', 'Andressa Santos', '010203');

INSERT INTO contas (numero, saldo, cliente_cpf) VALUES ('12345-6', 1000.00, '123.456.789-10'),
('12345-6', 10000.00, '333.333.333-10'),
('12345-6', 200.00, '111.111.111-11'),
('12345-6', 10.00, '222.222.222-22'),
('12345-6', 5585.32, '444.444.444-44');

INSERT INTO chaves_pix (chave, conta_id) VALUES ('joao@email.com', 1),
('333.333.333-33', 2),
('Albertomario@gmail.com', 3),
('11933123456', 4),
('Sandressa@gmail.com', 5);

INSERT INTO transacoes (valor, tipo, conta_id) VALUES (100.00, 'PIX', 1),
(10.00, 'PIX', 2),
(30.00, 'PIX', 3),
(10.00, 'PIX', 4),
(106.02, 'PIX', 5);

SELECT * FROM contas;