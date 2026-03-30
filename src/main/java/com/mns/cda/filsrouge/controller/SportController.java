package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.dao.SportDAO;
import com.mns.cda.filsrouge.model.Sport;
import com.mns.cda.filsrouge.view.SportView;
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
@RequestMapping("/sport")
@Tag(name = "Sport", description = "API de gestion des différents Sports")
public class SportController {

    private final SportDAO sportDAO;

    @GetMapping("/list")
    @JsonView(SportView.class)
    @Operation(summary = "Récupère la liste de tous les sports",
            description = "Cette méthode permet de récupérer la liste de tous les sports présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des sports récupérée avec succès")
    })
    public List<Sport> getSportList() {
        return sportDAO.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(SportView.class)
    @Operation(summary = "Récupérer un sport par son ID",
            description = "Cette méthode permet de récupérer les informations d'un sport spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sport récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Sport non trouvé")
    })
    public ResponseEntity<Sport> getSportById(@PathVariable Integer id) {

        Optional<Sport> optionalSport = sportDAO.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSport.get(), HttpStatus.OK);
    }

    @PostMapping("")
    @Operation(summary = "Ajoute un sport à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau sport en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sport ajoutée avec succès")
    })
    public ResponseEntity<Sport> create(@RequestBody Sport sportToInsert) {

        sportToInsert.setIdSport(null);
        sportDAO.save(sportToInsert);

        return new ResponseEntity<>(sportToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un sport par son ID",
            description = "Cette méthode permet de supprimer un sport spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sport supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Sport non trouvé")
    })
    public ResponseEntity<Sport> delete(@PathVariable Integer id) {

        Optional<Sport> optionalSport = sportDAO.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sportDAO.delete(optionalSport.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un sport par son ID",
            description = "Cette méthode permet de modifier les informations d'un sport spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sport modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Sport non trouvé")
    })
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
