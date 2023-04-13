package com.example.ac1atividade2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac1atividade2.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
