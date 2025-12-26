package com.straloo.ApiGestaoEscolarEBoletim.controller;

import com.straloo.ApiGestaoEscolarEBoletim.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<?> listarTurmas() {
        return ResponseEntity.ok(turmaService.listarTurmas());
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<?> listarTurmaDeUmAluno(@PathVariable Long idAluno) {
        return ResponseEntity.ok(turmaService.listarTurmasComUmAluno(idAluno));
    }
}
