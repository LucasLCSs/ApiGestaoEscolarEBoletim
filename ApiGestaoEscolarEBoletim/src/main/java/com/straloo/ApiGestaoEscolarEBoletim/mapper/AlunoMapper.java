package com.straloo.ApiGestaoEscolarEBoletim.mapper;

import com.straloo.ApiGestaoEscolarEBoletim.dto.AlunoDTO;
import com.straloo.ApiGestaoEscolarEBoletim.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(source = "turma.nome", target = "turma")
    AlunoDTO toDTO(Aluno entity);
}
