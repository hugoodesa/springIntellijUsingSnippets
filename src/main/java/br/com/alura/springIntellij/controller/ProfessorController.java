package br.com.alura.springIntellij.controller;

import br.com.alura.springIntellij.DTO.ProfessorDto;
import br.com.alura.springIntellij.entity.Aluno;
import br.com.alura.springIntellij.entity.Professor;
import br.com.alura.springIntellij.repository.ProfessorRepository;
import br.com.alura.springIntellij.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController extends GenericController<Professor, ProfessorRepository> {

    @Autowired
    ProfessorRepository repository;
    @Autowired
    ProfessorService service;

    public ProfessorController(ProfessorRepository repository) {
        super(repository);
    }

    @PostMapping
    @Override
    public ResponseEntity post(@RequestBody Professor body) {
        return super.post(body);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity update(@PathVariable Long id, @RequestBody Professor newBody) {
        return super.update(id, newBody);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity select(@PathVariable Long id) {
       return super.select(id);
    }

    @GetMapping("/loadFull/{id}")
    public List<Professor> selectFull(@PathVariable Long id) {
        List<Professor> alunosProfessor = this.repository.getAlunosProfessor(id);
        return alunosProfessor;
    }

    @PostMapping("/removeNull")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllTeachersNull(){
        this.repository.deleteAllTeachersNull();
    }

    @GetMapping("/getAlunos/{id}")
    public ResponseEntity<List <Aluno>> findAlunosProfessor(@PathVariable Long id){
        List<Aluno> alunosProfessor = this.repository.getAlunosByProfessorId(id);
        return ResponseEntity.ok(alunosProfessor);
    }

    //5,6
    @GetMapping("/professorDTO/{id}")
    public ResponseEntity<ProfessorDto> getProfessorDTO(@PathVariable Long id){
        Optional<ProfessorDto> professorDTO = this.service.getProfessorDTO(id);
        if(professorDTO.isPresent()){
            return ResponseEntity.ok(professorDTO.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
