package com.straloo.ApiGestaoEscolarEBoletim.controller;

import com.straloo.ApiGestaoEscolarEBoletim.dto.BoletimDTO;
import com.straloo.ApiGestaoEscolarEBoletim.service.BoletimService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boletins")
public class BoletimController {

    private final BoletimService boletimService;

    public BoletimController(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @GetMapping("/turma/{id}")
    public BoletimDTO gerar(@PathVariable Long id) {
        return boletimService.gerarBoletim(id);
    }
}

