package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.TypeCompteDAO;
import com.mns.cda.filsrouge.model.TypeCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TypeCompteController {

    @Autowired
    protected TypeCompteDAO typeCompteDAO;

    @GetMapping("/type-compte/list")
    public List<TypeCompte> getTypeCompteAll() {
        return typeCompteDAO.findAll();
    }

    @GetMapping("/type-compte/{id}")
    public ResponseEntity<TypeCompte> getTypeCompteById(@PathVariable int id) {

        Optional<TypeCompte> optionalTypeCompte = typeCompteDAO.findById(id);

        if(optionalTypeCompte.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTypeCompte.get(), HttpStatus.OK);
    }

    @PostMapping("/type-compte")
    public ResponseEntity<TypeCompte> create(@RequestBody TypeCompte typeComptetoInsert) {

        typeComptetoInsert.setIdTypeCompte(null);
        typeCompteDAO.save(typeComptetoInsert);

        return new ResponseEntity<>(typeComptetoInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/type-compte/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<TypeCompte> optionalTypeCompte = typeCompteDAO.findById(id);

        if (optionalTypeCompte.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
        typeCompteDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/type-compte/{id}")
    public ResponseEntity<Void> update(
            @PathVariable int id,
            @RequestBody TypeCompte typeComptetoUpdate) {

        Optional<TypeCompte> optionalTypeCompte = typeCompteDAO.findById(id);

        if(optionalTypeCompte.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
        typeComptetoUpdate.setIdTypeCompte(id);
        typeCompteDAO.save(typeComptetoUpdate);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
