CREATE TABLE turma (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE aluno (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    turma_id BIGINT NOT NULL,
    CONSTRAINT fk_aluno_turma
        FOREIGN KEY (turma_id)
        REFERENCES turma (id)
);