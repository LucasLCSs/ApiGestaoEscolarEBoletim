CREATE TABLE nota (
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT NOT NULL,
    turma_id BIGINT NOT NULL,
    disciplina VARCHAR(100) NOT NULL,
    valor NUMERIC(4,2) NOT NULL
);