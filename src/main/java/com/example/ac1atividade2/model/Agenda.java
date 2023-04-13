package com.example.ac1atividade2.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Curso curso;

    private Date dataInicio;

    private Date dataFim;

    private String cidade;

    private String estado;

    private String cep;

    private String resumo;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
