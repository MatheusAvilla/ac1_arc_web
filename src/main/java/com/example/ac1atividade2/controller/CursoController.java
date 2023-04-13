package com.example.ac1atividade2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1atividade2.model.Curso;
import com.example.ac1atividade2.repository.CursoRepository;

@RestController(value = "curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/findAll")
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @PostMapping("/create")
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurso(@PathVariable long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        curso.ifPresent(c -> cursoRepository.delete(c));
    }
    
}
