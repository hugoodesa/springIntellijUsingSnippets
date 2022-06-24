package br.com.alura.springIntellij.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

public interface ServiceGeneric <T> {

     ResponseEntity<T> post(T body);
     ResponseEntity<T> delete(Long id);
     ResponseEntity<T> update(Long id,T newBody);
     ResponseEntity<T> select(Long id);
     Page<T> getAll(@PageableDefault(size = 10,page = 0) Pageable pageable);

}
