package com.straloo.ApiGestaoEscolarEBoletimAcademic.controller;

import com.straloo.ApiGestaoEscolarEBoletimAcademic.dto.BoletimDTO;
import com.straloo.ApiGestaoEscolarEBoletimAcademic.service.NotaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    @GetMapping("/turma/{id}")
    public BoletimDTO buscar(@PathVariable Long id) {
        return service.buscarBoletimDaTurma(id);
    }
}

