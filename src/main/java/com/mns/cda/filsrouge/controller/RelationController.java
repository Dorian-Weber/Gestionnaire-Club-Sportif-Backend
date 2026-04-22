package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.model.Relation;
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
@RequestMapping("/relation")
@Tag(name = "Relation", description = "API de gestion des différentes relations")
@CrossOrigin
public class RelationController {


    protected final IRelationService relationService;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différentes relations",
            description = "Cette méthode permet de récupérer la liste de toutes les relations dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des relations récupérée avec succès")
    })
    public List<Relation> getRelationList() {
        return relationService.findAll();
    }

    @GetMapping("/{firstId}/{secondId}")
    @Operation(summary = "Récupérer une relation par son ID",
            description = "Cette méthode permet de récupérer les informations d'une relation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    public ResponseEntity<Relation> getRelationById(@PathVariable int firstId,
                                                    @PathVariable int secondId) {

        Relation.Key key = new Relation.Key(firstId, secondId);
        Optional<Relation> optionalRelation = relationService.findById(key);

        if(optionalRelation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalRelation.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute une relation à la base de données",
            description = "Cette méthode permet de d'ajouter une nouvelle relation en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Relation ajoutée avec succès")
    })
    public ResponseEntity<Relation> create(@RequestBody Relation relationToInsert) {

        relationService.create(relationToInsert);

        return new ResponseEntity<>(relationToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{firstId}/[{secondId}")
    @Operation(summary = "Supprime une relation par son ID",
            description = "Cette méthode permet de supprimer une relation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Relation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    public ResponseEntity<Relation> delete(@PathVariable int firstId,
                                           @PathVariable int secondId) {

        Relation.Key key = new Relation.Key(firstId, secondId);
        Optional<Relation> optionalRelation = relationService.findById(key);

        if(optionalRelation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        relationService.delete(key);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{firstId}/{secondId}")
    @Operation(summary = "Modifie une relation par son ID",
            description = "Cette méthode permet de modifier les informations d'une relation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    public ResponseEntity<Relation> update(
            @PathVariable int firstId,
            @PathVariable int secondId,
            @RequestBody Relation relationToUpdate) {

        Relation.Key key = new Relation.Key(firstId, secondId);
        try {
            relationService.update(key, relationToUpdate);
            return new ResponseEntity<>(relationToUpdate, HttpStatus.OK);
        } catch (IRelationService.RelationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
