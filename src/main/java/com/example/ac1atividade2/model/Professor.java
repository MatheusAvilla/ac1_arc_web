package com.example.ac1atividade2.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cpf;

    private String rg;

    private String endereco;

    private String celular;

    @ManyToMany
    @JoinTable(name = "professor_curso", 
               joinColumns = { @JoinColumn(name = "professor_id" ) },
               inverseJoinColumns = { @JoinColumn(name = "curso_id") } )
    List<Curso> cursos;

    @OneToMany(mappedBy = "professor")
    List<Agenda> agendas;

}
