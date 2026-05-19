package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.ISeatService;
import com.mns.cda.filsrouge.Iservice.ISportService;
import com.mns.cda.filsrouge.dto.SportField;
import com.mns.cda.filsrouge.model.Sport;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
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
@CrossOrigin
public class SportController {

    private final ISportService sportService;

    @GetMapping("/field")
    @Operation(summary = "Récupère la liste de tous les sports",
            description = "Cette route permet de récupérer la liste de tous les sports présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des sports récupérée avec succès")
    })
    public List<SportField> getSportFieldList() {
        return sportService.findAllSportField();
    }

    @GetMapping("/{id}")
    @JsonView(SportView.class)
    @Operation(summary = "Récupérer un sport par son ID",
            description = "Cette route permet de récupérer les informations d'un sport spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sport récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Sport non trouvé")
    })
    @isUser
    public ResponseEntity<Sport> getSportById(@PathVariable Integer id) {

        Optional<Sport> optionalSport = sportService.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSport.get(), HttpStatus.OK);
    }

    @PostMapping("")
    @Operation(summary = "Ajoute un sport à la base de données",
            description = "Cette route permet de d'ajouter un nouveau sport en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sport ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<Sport> create(@RequestBody Sport sportToInsert) {

        sportService.create(sportToInsert);

        return new ResponseEntity<>(sportToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un sport par son ID",
            description = "Cette route permet de supprimer un sport spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sport supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Sport non trouvé")
    })
    @isAdmin
    public ResponseEntity<Sport> delete(@PathVariable Integer id) {

        Optional<Sport> optionalSport = sportService.findById(id);

        if (optionalSport.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sportService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un sport par son ID",
            description = "Cette route permet de modifier les informations d'un sport spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sport modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Sport non trouvé")
    })
    @isAdmin
    public ResponseEntity<Sport> update(
            @PathVariable Integer id,
            @RequestBody Sport sportToUpdate) {

        try {
            sportService.update(id, sportToUpdate);
            return new ResponseEntity<>(sportToUpdate, HttpStatus.OK);
        } catch (ISportService.SportNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
