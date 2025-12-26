package com.straloo.ApiGestaoEscolarEBoletimAcademic.service;

import com.straloo.ApiGestaoEscolarEBoletimAcademic.dto.AlunoBoletimDTO;
import com.straloo.ApiGestaoEscolarEBoletimAcademic.dto.BoletimDTO;
import com.straloo.ApiGestaoEscolarEBoletimAcademic.model.Nota;
import com.straloo.ApiGestaoEscolarEBoletimAcademic.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotaService {

    private final NotaRepository repository;

    public NotaService(NotaRepository repository) {
        this.repository = repository;
    }

    public BoletimDTO buscarBoletimDaTurma(Long turmaId) {

        List<Nota> notas = repository.findByTurmaId(turmaId);

        Map<Long, AlunoBoletimDTO> mapa = new HashMap<>();

        for (Nota nota : notas) {

            mapa.putIfAbsent(
                    nota.getAlunoId(),
                    new AlunoBoletimDTO("Aluno " + nota.getAlunoId(), new HashMap<>(), nota.getValor())
            );

            mapa.get(nota.getAlunoId())
                    .getNotas()
                    .put(nota.getDisciplina(), nota.getValor());
        }

        return new BoletimDTO("Turma " + turmaId,
                new ArrayList<>(mapa.values()));
    }
}

