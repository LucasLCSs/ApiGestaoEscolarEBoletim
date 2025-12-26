package com.straloo.ApiGestaoEscolarEBoletim.repository;

import com.straloo.ApiGestaoEscolarEBoletim.model.Aluno;
import com.straloo.ApiGestaoEscolarEBoletim.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByTurma(Turma turma);
}
