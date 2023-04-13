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

import com.example.ac1atividade2.model.Professor;
import com.example.ac1atividade2.repository.ProfessorRepository;

@RestController(value = "professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/findAll")
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
    
    @PostMapping("/create")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfessor(@PathVariable long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        professor.ifPresent(p -> professorRepository.delete(p));
    }

}
