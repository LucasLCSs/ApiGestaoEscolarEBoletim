package com.straloo.ApiGestaoEscolarEBoletim.mapper;

import com.straloo.ApiGestaoEscolarEBoletim.dto.AlunoDTO;
import com.straloo.ApiGestaoEscolarEBoletim.model.Aluno;
import com.straloo.ApiGestaoEscolarEBoletim.model.Turma;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-26T17:56:40-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class AlunoMapperImpl implements AlunoMapper {

    @Override
    public AlunoDTO toDTO(Aluno entity) {
        if ( entity == null ) {
            return null;
        }

        String turma = null;
        String nome = null;
        String matricula = null;

        turma = entityTurmaNome( entity );
        nome = entity.getNome();
        matricula = entity.getMatricula();

        AlunoDTO alunoDTO = new AlunoDTO( nome, matricula, turma );

        return alunoDTO;
    }

    private String entityTurmaNome(Aluno aluno) {
        Turma turma = aluno.getTurma();
        if ( turma == null ) {
            return null;
        }
        return turma.getNome();
    }
}
