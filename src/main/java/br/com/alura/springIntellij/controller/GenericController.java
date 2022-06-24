package br.com.alura.springIntellij.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

public abstract class GenericController <T,Repository extends JpaRepository<T,Long>> implements ServiceGeneric<T>{

    @Autowired
    Repository repository;

    public GenericController(Repository repository) {
        this.repository = repository;
    }

    protected ResponseEntity<T> badRequest() {
        return badRequest();
    }

    @Override
    public ResponseEntity post(T body) {
        try {
            T saved = repository.save(body);
            return ResponseEntity.ok(saved);
        }catch (Exception e){
            e.printStackTrace();
        }
        return badRequest();
    }

    @Override
    public ResponseEntity delete(Long id) {
        try {
           this.repository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return badRequest();
    }

    @Override
    @GetMapping("")
    public ResponseEntity select(Long id) {
        try {
            Optional<T> entityFound = repository.findById(id);
            if(entityFound.isPresent()){
                return ResponseEntity.ok(entityFound.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return badRequest();
    }

    @Override
    public ResponseEntity update(Long id, T newBody) {
        try {
            Optional<T> entityFound = this.repository.findById(id);
            if(entityFound.isPresent()){
                return ResponseEntity.ok(entityFound.get());
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return badRequest();
    }

    @GetMapping("/getAll")
    @Override
    public Page<T> getAll(@PageableDefault(size = 10,page = 0) Pageable pageable){
        Page<T> all = this.repository.findAll(pageable);
        return all;
    }
}
