package com.straloo.ApiGestaoEscolarEBoletim.mapper;

import com.straloo.ApiGestaoEscolarEBoletim.dto.TurmaDTO;
import com.straloo.ApiGestaoEscolarEBoletim.model.Turma;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TurmaMapper {

    TurmaDTO toDTO(Turma turma);
}
