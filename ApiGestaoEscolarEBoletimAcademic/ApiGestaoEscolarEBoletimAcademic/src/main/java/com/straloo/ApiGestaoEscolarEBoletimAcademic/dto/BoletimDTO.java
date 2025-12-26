package com.straloo.ApiGestaoEscolarEBoletimAcademic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoletimDTO {
    private String turma;
    private List<AlunoBoletimDTO> alunos;
}

