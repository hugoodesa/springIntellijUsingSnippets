package br.com.alura.springIntellij.service;

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
public class AlunoService {

    @Autowired
    AlunoRepository alunosRepository;


}
