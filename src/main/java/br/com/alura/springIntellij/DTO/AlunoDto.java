package br.com.alura.springIntellij.DTO;

import br.com.alura.springIntellij.entity.Aluno;
import br.com.alura.springIntellij.enums.Status;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AlunoDto implements Serializable {
    @Length(min = 5)
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    private Status status;

    public AlunoDto(Aluno aluno) {
        this.converter(aluno);
    }

    public AlunoDto() {}

    public void converter (Aluno aluno){
        this.name=aluno.getName();
        this.status=aluno.getStatus();
    }

    public List<AlunoDto> converter (List<Aluno> alunos){
        ArrayList<AlunoDto> alunosDTO = new ArrayList<>();
        alunos.forEach(aluno->{
            alunosDTO.add(new AlunoDto(aluno));
        });
        return alunosDTO;
    }

}
