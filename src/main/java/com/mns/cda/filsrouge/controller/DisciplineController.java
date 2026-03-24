package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.DisciplineDAO;
import com.mns.cda.filsrouge.model.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DisciplineController {

    private DisciplineDAO disciplineDAO;

    @Autowired
    public DisciplineController(DisciplineDAO disciplineDAO) {
        this.disciplineDAO = disciplineDAO;
    }

    @GetMapping("/discipline/liste")
    public List<Discipline> getDisciplineList() {
        return disciplineDAO.findAll();
    }

    @GetMapping("/discipline/{id}")
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable Integer id) {

        Optional<Discipline> optionalDiscipline = disciplineDAO.findById(id);

        if (optionalDiscipline.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalDiscipline.get(), HttpStatus.OK);
    }

    @PostMapping("/discipline")
    public ResponseEntity<Discipline> create(@RequestBody Discipline disciplineToInsert) {

        disciplineToInsert.setIdDiscipline(null);
        disciplineDAO.save(disciplineToInsert);

        return new ResponseEntity<>(disciplineToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/discipline/{id}")
    public ResponseEntity<Discipline> delete(@PathVariable Integer id) {

        Optional<Discipline> optionalDiscipline = disciplineDAO.findById(id);

        if (optionalDiscipline.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        disciplineDAO.delete(optionalDiscipline.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/discipline/{id}")
    public ResponseEntity<Discipline> update(
            @PathVariable Integer id,
            @RequestBody Discipline disciplineToUpdate) {

        Optional<Discipline> optionalDiscipline = disciplineDAO.findById(id);

        if (optionalDiscipline.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        disciplineToUpdate.setIdDiscipline(id);
        disciplineDAO.save(disciplineToUpdate);

        return new ResponseEntity<>(disciplineToUpdate, HttpStatus.OK);

    }
}
