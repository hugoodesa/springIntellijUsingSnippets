package br.com.alura.springIntellij.repository;

import br.com.alura.springIntellij.entity.Aluno;
import br.com.alura.springIntellij.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Transactional
    @Modifying
    @Query("delete from Professor p where p.salario is null")
    void deleteAllTeachersNull();

    @Query("select p from Professor p join fetch p.alunos where p.id =:id")
    public List<Professor> getAlunosProfessor(Long id);

    @Query("select a from Aluno a join fetch a.professor prof where prof.id =:id")
    public List<Aluno> findAlunosProfessor(Long id);

//    @Query("select a from Aluno a where a.professor.id = ?1")
//    List<Aluno> getAlunosByProfessorId(Long id);

//    @Query(value = " select * from alunos a " +
//            " join professores p on p.id = a.professor_id" +
//            "where a.professor_id = ?1 ",nativeQuery = true)
    @Query("select a from Aluno a where a.professor.id =:id")
    List<Aluno> getAlunosByProfessorId(Long id);


}