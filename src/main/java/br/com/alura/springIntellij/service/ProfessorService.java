package br.com.alura.springIntellij.service;

import br.com.alura.springIntellij.DTO.AlunoDto;
import br.com.alura.springIntellij.DTO.ProfessorDto;
import br.com.alura.springIntellij.entity.Aluno;
import br.com.alura.springIntellij.entity.Professor;
import br.com.alura.springIntellij.repository.AlunoRepository;
import br.com.alura.springIntellij.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;
    @Autowired
    AlunoRepository alunosRepository;

    public Optional<ProfessorDto> getProfessorDTO(Long idProfessor){
        Optional<Professor> professorFound = this.repository.findById(idProfessor);
        ProfessorDto professorDto = new ProfessorDto();
        AlunoDto alunoDto = new AlunoDto();

        if(professorFound.isPresent()){
            professorDto = new ProfessorDto(professorFound.get());

            //obtido lista de alunos
            List<Aluno> listaDeAlunosProfessor = this.alunosRepository.findByProfessor_Id(idProfessor);

            //converter lista de alunos para aluno dto
            List<AlunoDto> listaDeAlunosProfessorDTO = alunoDto.converter(listaDeAlunosProfessor);
            //atribuir a lista de alunos dto ao professor
            professorDto.setAlunosDto(listaDeAlunosProfessorDTO);
        }
        return Optional.ofNullable(professorDto);
    }

}
