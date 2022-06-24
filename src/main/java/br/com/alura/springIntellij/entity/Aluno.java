package br.com.alura.springIntellij.entity;

import br.com.alura.springIntellij.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Length(min = 5)
    @NotBlank
    @NotEmpty
    @Column(name = "name")
    private String name;

    @Length(min = 11, max = 11)
    @NotNull
    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @NotNull
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataNascimento;

    @Email
    @NotBlank
    private String email;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

}