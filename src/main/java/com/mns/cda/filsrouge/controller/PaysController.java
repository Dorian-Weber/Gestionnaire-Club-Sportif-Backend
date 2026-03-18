package com.mns.cda.filsrouge.controller;


import com.mns.cda.filsrouge.dao.PaysDAO;
import com.mns.cda.filsrouge.dao.SportDAO;
import com.mns.cda.filsrouge.model.Pays;
import com.mns.cda.filsrouge.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaysController {

    @Autowired
    private PaysDAO paysDAO;

    @GetMapping("/pays/liste")
    public List<Pays> getPays(){
        return paysDAO.findAll();
    }

    @GetMapping("/pays/{id}")
    public ResponseEntity<Pays> getPaysById(@PathVariable int id){

        Optional<Pays> optionalPays = paysDAO.findById(id);

        if(optionalPays.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalPays.get(), HttpStatus.OK);
    }

    @PostMapping("/pays")
    public ResponseEntity<Pays> create(@RequestBody Pays paysToInsert){

        paysToInsert.setIdPays(null);
        paysDAO.save(paysToInsert);

        return new ResponseEntity<>(paysToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/pays/{id}")
    public ResponseEntity<Pays> delete(@PathVariable int id){

        Optional<Pays> optionalPays = paysDAO.findById(id);

        if(optionalPays.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paysDAO.delete(optionalPays.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/pays/{id}")
    public ResponseEntity<Pays> update(
            @PathVariable int id,
            @RequestBody Pays paysToUpdate){

        Optional<Pays> optionalPays = paysDAO.findById(id);

        if(optionalPays.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paysToUpdate.setIdPays(id);
        paysDAO.save(paysToUpdate);

        return new ResponseEntity<>(paysToUpdate, HttpStatus.OK);
    }
}
