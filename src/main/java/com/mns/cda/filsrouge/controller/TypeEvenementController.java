package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.dao.TypeEvenementDAO;
import com.mns.cda.filsrouge.model.TypeEvenement;
import com.mns.cda.filsrouge.view.TypeEvenementView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/type-evenement")
@Tag(name = "Type évènement", description = "API de gestion des différents types d'évènements")
public class TypeEvenementController {


    protected final TypeEvenementDAO typeEvenementDAO;

    @GetMapping("/liste")
    @JsonView(TypeEvenementView.class)
    @Operation(summary = "Récupère la liste des différents types d'évènements",
            description = "Cette méthode permet de récupérer la liste de tous les types d'évènements présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des types d'évènements récupérée avec succès")
    })
    public List<TypeEvenement> getTypeEvenementList() {
        return typeEvenementDAO.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(TypeEvenementView.class)
    @Operation(summary = "Récupérer un type d'évènement par son ID",
            description = "Cette méthode permet de récupérer les informations d'un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type d'évènement récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    public ResponseEntity<TypeEvenement> getTypeEvenementById(@PathVariable int id) {

        Optional<TypeEvenement> optionalTypeEvenement = typeEvenementDAO.findById(id);

        if(optionalTypeEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTypeEvenement.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un type d'évènement à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau type d'évènement en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Type d'évènement ajoutée avec succès")
    })
    public ResponseEntity<TypeEvenement> create(@RequestBody TypeEvenement typeEvenementToInsert) {

        typeEvenementToInsert.setIdTypeEvenement(null);
        typeEvenementDAO.save(typeEvenementToInsert);

        return new ResponseEntity<>(typeEvenementToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un type d'évènement par son ID",
            description = "Cette méthode permet de supprimer un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Type d'évènement supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    public ResponseEntity<TypeEvenement> delete(@PathVariable int id) {

        Optional<TypeEvenement> optionalTypeEvenement = typeEvenementDAO.findById(id);

        if(optionalTypeEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeEvenementDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un type d'évènement par son ID",
            description = "Cette méthode permet de modifier les informations d'un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type d'évènement modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    public ResponseEntity<TypeEvenement> update(
            @PathVariable int id,
            @RequestBody TypeEvenement typeEvenementToUpdate) {

        Optional<TypeEvenement> optionalTypeEvenement = typeEvenementDAO.findById(id);

        if(optionalTypeEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeEvenementToUpdate.setIdTypeEvenement(id);
        typeEvenementDAO.save(typeEvenementToUpdate);

        return new ResponseEntity<>(typeEvenementToUpdate,HttpStatus.OK);
    }

}
