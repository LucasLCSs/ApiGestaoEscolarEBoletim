package com.straloo.ApiGestaoEscolarEBoletim.service;


import com.straloo.ApiGestaoEscolarEBoletim.dto.BoletimDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class BoletimService {

    private final RestTemplate restTemplate;

    public BoletimDTO gerarBoletim(Long idTurma) {

        String url = "http://localhost:8081/notas/turma/" + idTurma;

        return restTemplate.getForObject(url, BoletimDTO.class);
    }
}


