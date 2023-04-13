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

import com.example.ac1atividade2.model.Agenda;
import com.example.ac1atividade2.repository.AgendaRepository;

@RestController(value = "agenda")
public class AgendaController {
    
    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping("/findAll")
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @PostMapping("/create")
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAgenda(@PathVariable long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        agenda.ifPresent(a -> agendaRepository.delete(a));
    }

    public boolean validateProfessor(Agenda agenda) {
        if(agenda.getCurso().getProfessores() != null) {
            return true;
        }
        return false;
    }

}
