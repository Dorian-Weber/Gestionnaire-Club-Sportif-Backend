package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.TypeEvenementDAO;
import com.mns.cda.filsrouge.model.TypeEvenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TypeEvenementController {

    @Autowired
    protected TypeEvenementDAO typeEvenementDAO;

    @GetMapping("/type-evenement/list")
    public List<TypeEvenement> getTypeEvenementAll() {
        return typeEvenementDAO.findAll();
    }

    @GetMapping("/type-evenement/{id}")
    public ResponseEntity<TypeEvenement> getTypeEvenementById(@PathVariable int id) {

        Optional<TypeEvenement> optionalTypeEvenement = typeEvenementDAO.findById(id);

        if(optionalTypeEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTypeEvenement.get(), HttpStatus.OK);
    }

    @PostMapping("/type-evenement")
    public ResponseEntity<TypeEvenement> create(@RequestBody TypeEvenement typeEvenementToInsert) {

        typeEvenementToInsert.setIdTypeEvenement(null);
        typeEvenementDAO.save(typeEvenementToInsert);

        return new ResponseEntity<>(typeEvenementToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/type-evenement/{id}")
    public ResponseEntity<TypeEvenement> delete(@PathVariable int id) {

        Optional<TypeEvenement> optionalTypeEvenement = typeEvenementDAO.findById(id);

        if(optionalTypeEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeEvenementDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/type-evenement/{id}")
    public ResponseEntity<Void> update(
            @PathVariable int id,
            @RequestBody TypeEvenement typeEvenementToUpdate) {

        Optional<TypeEvenement> optionalTypeEvenement = typeEvenementDAO.findById(id);

        if(optionalTypeEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeEvenementToUpdate.setIdTypeEvenement(id);
        typeEvenementDAO.save(typeEvenementToUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
