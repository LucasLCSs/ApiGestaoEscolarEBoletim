package com.straloo.ApiGestaoEscolarEBoletim.service;

import com.straloo.ApiGestaoEscolarEBoletim.dto.AlunoDTO;
import com.straloo.ApiGestaoEscolarEBoletim.exception.TurmaNaoEncontrada;
import com.straloo.ApiGestaoEscolarEBoletim.mapper.AlunoMapper;
import com.straloo.ApiGestaoEscolarEBoletim.model.Turma;
import com.straloo.ApiGestaoEscolarEBoletim.repository.AlunoRepository;
import com.straloo.ApiGestaoEscolarEBoletim.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunosRepository;
    private final TurmaRepository turmaRepository;
    private final AlunoMapper mapper;

    public List<AlunoDTO> listarAlunos() {
        return alunosRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<AlunoDTO> listarAlunosDeUmaTurma(Long idTurma) {
        Turma turma = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new TurmaNaoEncontrada("Turma não encontrada"));

        return alunosRepository.findByTurma(turma)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
