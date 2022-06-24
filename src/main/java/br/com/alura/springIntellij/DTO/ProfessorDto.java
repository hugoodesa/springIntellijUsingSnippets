package br.com.alura.springIntellij.DTO;

import br.com.alura.springIntellij.entity.Aluno;
import br.com.alura.springIntellij.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ProfessorDto implements Serializable {

    @NotNull
    private String nome;
    private Integer numeroDeHoras;
    private List<AlunoDto> alunosDto;

    public ProfessorDto(Professor professor) {
        this.converter(professor);
    }

    public ProfessorDto() {
    }

    public void converter(Professor professor){
        this.nome=professor.getNome();
        this.numeroDeHoras=professor.getNumeroDeHoras();
    }
}
