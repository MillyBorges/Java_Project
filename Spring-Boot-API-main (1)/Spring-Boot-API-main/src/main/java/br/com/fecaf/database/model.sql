CREATE DATABASE  titanium_bank;
USE titanium_bank;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE contas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    numero_conta VARCHAR(20) NOT NULL UNIQUE,
    saldo DECIMAL(12,2) DEFAULT 0.00,
    tipo_conta ENUM('corrente', 'poupanca') DEFAULT 'corrente',
    criada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE transacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    conta_origem_id INT,
    conta_destino_id INT,
    tipo ENUM('deposito', 'saque', 'transferencia') NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_origem_id) REFERENCES contas(id),
    FOREIGN KEY (conta_destino_id) REFERENCES contas(id)
);

CREATE TABLE pix_chaves (
    id INT AUTO_INCREMENT PRIMARY KEY,
    conta_id INT NOT NULL,
    tipo ENUM('cpf', 'email', 'telefone', 'aleatoria') NOT NULL,
    chave VARCHAR(255) NOT NULL UNIQUE,
    criada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

CREATE TABLE emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    conta_id INT NOT NULL,
    valor_solicitado DECIMAL(12,2) NOT NULL,
    valor_total DECIMAL(12,2) NOT NULL,
    parcelas INT NOT NULL,
    juros_mensal DECIMAL(5,2) NOT NULL,
    status ENUM('pendente', 'aprovado', 'rejeitado', 'quitado') DEFAULT 'pendente',
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

CREATE TABLE pagamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    conta_id INT NOT NULL,
    codigo_barras VARCHAR(80) NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

CREATE TABLE cartoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    conta_id INT NOT NULL,
    numero_cartao VARCHAR(16) NOT NULL UNIQUE,
    validade DATE NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    tipo ENUM('credito', 'debito') NOT NULL,
    limite DECIMAL(12,2),
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

SELECT * FROM usuarios, contas, transacoes, pix_chaves, emprestimos, pagamentos, cartoes;
