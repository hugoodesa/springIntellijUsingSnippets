package br.com.alura.springIntellij.controller;

import br.com.alura.springIntellij.entity.Aluno;
import br.com.alura.springIntellij.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController implements ServiceGeneric<Aluno> {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Override
    public ResponseEntity<Aluno> post(@RequestBody Aluno body) {
        try {
            Aluno save = this.repository.save(body);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Aluno> delete(@PathVariable("id") Long id) {
        try {
            this.repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Aluno> update(@PathVariable("id") Long id, @RequestBody Aluno newBody) {
        try {
            Optional<Aluno> alunoById = this.repository.findById(id);
            if (alunoById.isPresent()) {
                Long idAlunoAtualizado = alunoById.get().getId();
                newBody.setId(idAlunoAtualizado);
                this.repository.save(newBody);
                return ResponseEntity.ok(newBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Aluno> select(@PathVariable("id") Long id) {
        try {
            Optional<Aluno> alunoById = this.repository.findById(id);
            if (alunoById.isPresent()) {
                return ResponseEntity.ok(alunoById.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    @GetMapping("/allStudents")
    public Page<Aluno> getAll(@PageableDefault(size = 10,page = 0) Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @GetMapping("/email")
    public ResponseEntity<Aluno> getAlunoByEmail(@RequestParam("email") String email){
        Optional<Aluno> emailFinded = this.repository.findByEmail(email);
        if(emailFinded.isPresent()){
            return ResponseEntity.ok(emailFinded.get());
        }
        return ResponseEntity.badRequest().build();
    }

}
