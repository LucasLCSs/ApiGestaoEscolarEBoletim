package com.straloo.ApiGestaoEscolarEBoletim.service;

import com.straloo.ApiGestaoEscolarEBoletim.dto.TurmaDTO;
import com.straloo.ApiGestaoEscolarEBoletim.exception.AlunoNaoEncontrado;
import com.straloo.ApiGestaoEscolarEBoletim.mapper.TurmaMapper;
import com.straloo.ApiGestaoEscolarEBoletim.model.Aluno;
import com.straloo.ApiGestaoEscolarEBoletim.repository.AlunoRepository;
import com.straloo.ApiGestaoEscolarEBoletim.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaMapper mapper;

    public List<TurmaDTO> listarTurmas() {
        return turmaRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<TurmaDTO> listarTurmasComUmAluno(Long idAluno) {

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() ->
                        new AlunoNaoEncontrado("Aluno não encontrado")
                );

        return List.of(
                mapper.toDTO(aluno.getTurma())
        );
    }
}
