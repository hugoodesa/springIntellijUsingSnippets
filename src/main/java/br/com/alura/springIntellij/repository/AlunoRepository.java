package br.com.alura.springIntellij.repository;

import br.com.alura.springIntellij.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByNameLikeIgnoreCase(String name);
    Optional<Aluno> findByDataNascimentoBetween(LocalDate dataNascimentoStart, LocalDate dataNascimentoEnd);

    @Query("select a from Aluno a where upper(a.email) like upper(:email)")
    Optional<Aluno> findByEmail(String email);

    @Query("select a from Aluno a where a.professor.id = ?1")
    List<Aluno> findByProfessor_Id(Long id);


}