package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.SportifDAO;
import com.mns.cda.filsrouge.model.Sportif;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sportif")
@Tag(name = "Sportif", description = "API de gestion des différents sportifs")
public class SportifController {


    protected final SportifDAO sportifDAO;

    @GetMapping("/liste")
    @Operation(summary = "Récupère la liste des différents sportifs",
            description = "Cette méthode permet de récupérer la liste de tous les sportifs présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des sportifs récupérée avec succès")
    })
    public List<Sportif> getSportifList() {
        return sportifDAO.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un sportif par son ID",
            description = "Cette méthode permet de récupérer les informations d'un sportif spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sportif récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Sportif non trouvé")
    })
    public ResponseEntity<Sportif> getSportifById(@PathVariable int id) {

        Optional<Sportif> optionalSportif = sportifDAO.findById(id);

        if(optionalSportif.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSportif.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un sportif à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau sportif en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sportif ajoutée avec succès")
    })
    public ResponseEntity<Sportif> create(@RequestBody Sportif sportifToInsert) {

        sportifToInsert.setIdSportif(null);
        sportifDAO.save(sportifToInsert);

        return new ResponseEntity<>(sportifToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un sportif par son ID",
            description = "Cette méthode permet de supprimer un sportif spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sportif supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Sportif non trouvé")
    })
    public ResponseEntity<Sportif> delete(@PathVariable int id) {

        Optional<Sportif> optionalSportif = sportifDAO.findById(id);

        if(optionalSportif.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sportifDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un sportif par son ID",
            description = "Cette méthode permet de modifier les informations d'un sportif spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sportif modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Sportif non trouvé")
    })
    public ResponseEntity<Sportif> update(
            @PathVariable int id,
            @RequestBody Sportif sportifToUpdate) {

        Optional<Sportif> optionalSportif = sportifDAO.findById(id);

        if(optionalSportif.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sportifToUpdate.setIdSportif(id);
        sportifDAO.save(sportifToUpdate);

        return new ResponseEntity<>(sportifToUpdate,HttpStatus.OK);
    }

}
