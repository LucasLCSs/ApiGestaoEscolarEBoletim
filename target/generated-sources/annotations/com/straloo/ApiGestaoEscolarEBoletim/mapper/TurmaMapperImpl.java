package com.straloo.ApiGestaoEscolarEBoletim.mapper;

import com.straloo.ApiGestaoEscolarEBoletim.dto.TurmaDTO;
import com.straloo.ApiGestaoEscolarEBoletim.model.Turma;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-26T17:56:40-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class TurmaMapperImpl implements TurmaMapper {

    @Override
    public TurmaDTO toDTO(Turma turma) {
        if ( turma == null ) {
            return null;
        }

        String nome = null;

        nome = turma.getNome();

        TurmaDTO turmaDTO = new TurmaDTO( nome );

        return turmaDTO;
    }
}
