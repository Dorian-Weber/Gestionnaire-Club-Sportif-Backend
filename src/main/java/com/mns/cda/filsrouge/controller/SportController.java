package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.SportDAO;
import com.mns.cda.filsrouge.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SportController {

    @Autowired
    private SportDAO sportDAO;

    @GetMapping("/sport/liste")
    public List<Sport> getSportList() {
        return sportDAO.findAll();
    }

    @GetMapping("/sport/{id}")
    public ResponseEntity<Sport> getSportById(@PathVariable Integer id) {

        Optional<Sport> optionalSport = sportDAO.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSport.get(), HttpStatus.OK);
    }

    @PostMapping("/sport")
    public ResponseEntity<Sport> create(@RequestBody Sport sportToInsert) {

        sportToInsert.setIdSport(null);
        sportDAO.save(sportToInsert);

        return new ResponseEntity<>(sportToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/sport/{id}")
    public ResponseEntity<Sport> delete(@PathVariable Integer id) {

        Optional<Sport> optionalSport = sportDAO.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sportDAO.delete(optionalSport.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/sport/{id}")
    public ResponseEntity<Sport> update(
            @PathVariable Integer id,
            @RequestBody Sport sportToUpdate) {

        Optional<Sport> optionalSport = sportDAO.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sportToUpdate.setIdSport(id);
        sportDAO.save(sportToUpdate);

        return new ResponseEntity<>(sportToUpdate, HttpStatus.OK);

    }
}
