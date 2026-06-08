package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.model.Relation;
import com.mns.cda.filsrouge.security.AppUserDetails;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            description = "Cette route permet de récupérer la liste de toutes les relations dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des relations récupérée avec succès")
    })
    @isAdmin
    public List<Relation> getRelationList() {
        return relationService.findAll();
    }

    @GetMapping("/user")
    @Operation(summary = "Récupérer la liste d'amis d'un utilisateur.",
            description = "Cette route permet de récupérer la liste d'amis d'un utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    @isUser
    public List<FriendDTO> getFriends(@AuthenticationPrincipal AppUserDetails appUserDetails) {
        return relationService.getFriends(appUserDetails.getUser().getIdAppUser());
    }

    @GetMapping("/{firstId}/{secondId}")
    @Operation(summary = "Récupérer une relation entre deux utilisateur par leurs ID.",
            description = "Cette route permet de récupérer une relation spécifique entre deux utilisateur par leur ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    @isUser
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
    @Operation(summary = "Ajoute une relation entre deux utilisateur en base de données",
            description = "Cette route permet d'ajouter une nouvelle relation entre utilisateur en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Relation ajoutée avec succès")
    })
    @isUser
    public ResponseEntity<Relation> create(@RequestBody Relation relationToInsert) {

        relationService.create(relationToInsert);

        return new ResponseEntity<>(relationToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{secondId}")
    @Operation(summary = "Supprime une relation entre deux utilisateur par leurs ID",
            description = "Cette route permet de supprimer une relation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Relation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    @isUser
    public ResponseEntity<Relation> delete(@AuthenticationPrincipal AppUserDetails appUserDetails,
                                           @PathVariable int secondId) {

        Optional<Relation> optionalRelation = relationService.findRelationBetween(
                appUserDetails.getUser().getIdAppUser(),
                secondId);

        if(optionalRelation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        relationService.delete(optionalRelation.get().getKey());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{firstId}/{secondId}")
    @Operation(summary = "Modifie une relation par son ID",
            description = "Cette route permet de modifier une relation spécifique entre deux utilisateur par leurs ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    @isUser
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
