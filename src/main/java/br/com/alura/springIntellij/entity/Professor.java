package br.com.alura.springIntellij.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professores")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    private BigDecimal salario;

    private LocalDate dataContratacao = LocalDate.now();

    private Integer numeroDeHoras;

    @JsonBackReference
    @OneToMany(mappedBy = "professor", orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Aluno> alunos = new ArrayList<>();

}