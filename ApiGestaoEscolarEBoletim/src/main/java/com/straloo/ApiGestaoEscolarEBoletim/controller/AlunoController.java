package com.straloo.ApiGestaoEscolarEBoletim.controller;

import com.straloo.ApiGestaoEscolarEBoletim.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<?> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @GetMapping("/turma/{idTurma}")
    public ResponseEntity<?> listarAlunosDeUmaTurma(@PathVariable Long idTurma) {
        return ResponseEntity.ok(alunoService.listarAlunosDeUmaTurma(idTurma));
    }
}
