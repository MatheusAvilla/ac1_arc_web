package com.example.ac1atividade2.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;

    private int cargaHoraria;

    private String objetivos;

    private String ementa;

    @ManyToMany(mappedBy = "cursos")
    List<Professor> professores;

    @OneToMany(mappedBy = "curso")
    List<Agenda> agendas;

}
