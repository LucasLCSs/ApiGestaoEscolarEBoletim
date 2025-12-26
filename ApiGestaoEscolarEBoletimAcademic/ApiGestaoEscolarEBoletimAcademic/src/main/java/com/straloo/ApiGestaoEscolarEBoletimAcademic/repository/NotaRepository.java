package com.straloo.ApiGestaoEscolarEBoletimAcademic.repository;

import com.straloo.ApiGestaoEscolarEBoletimAcademic.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByTurmaId(Long turmaId);
}

