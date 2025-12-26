package com.straloo.ApiGestaoEscolarEBoletim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlunoBoletimDTO {
    private String nome;
    private Map<String, Double> notas = new HashMap<>();
    private Double media;
}
