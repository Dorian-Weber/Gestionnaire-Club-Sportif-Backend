package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.dao.EvenementDAO;
import com.mns.cda.filsrouge.model.Evenement;
import com.mns.cda.filsrouge.view.EvenementView;
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
@RequestMapping("/evenement")
@Tag(name = "Évènement", description = "API de gestion des différents évènements")
public class EvenementController {


    protected final EvenementDAO evenementDAO;

    @GetMapping("/liste")
    @JsonView(EvenementView.class)
    @Operation(summary = "Récupère la liste des différents évènements",
            description = "Cette méthode permet de récupérer la liste de tous les évènements présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des évènements récupérée avec succès")
    })
    public List<Evenement> getEvenementList() {
        return evenementDAO.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(EvenementView.class)
    @Operation(summary = "Récupérer un évènement par son ID",
            description = "Cette méthode permet de récupérer les informations d'un évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Évènement récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Évènement non trouvé")
    })
    public ResponseEntity<Evenement> getEvenementById(@PathVariable int id) {

        Optional<Evenement> optionalEvenement = evenementDAO.findById(id);

        if(optionalEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalEvenement.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un évènement à la base de données",
            description = "Cette méthode permet de d'ajouter un nouvel évènement en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Évènement ajoutée avec succès")
    })
    public ResponseEntity<Evenement> create(@RequestBody Evenement evenementToInsert) {

        evenementToInsert.setIdEvenement(null);
        evenementDAO.save(evenementToInsert);

        return new ResponseEntity<>(evenementToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un évènement par son ID",
            description = "Cette méthode permet de supprimer un évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Évènement supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Évènement non trouvé")
    })
    public ResponseEntity<Evenement> delete(@PathVariable int id) {

        Optional<Evenement> optionalEvenement = evenementDAO.findById(id);

        if(optionalEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        evenementDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un évènement par son ID",
            description = "Cette méthode permet de modifier les informations d'un évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Évènement modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Évènement non trouvé")
    })
    public ResponseEntity<Evenement> update(
            @PathVariable int id,
            @RequestBody Evenement evenementToUpdate) {

        Optional<Evenement> optionalEvenement = evenementDAO.findById(id);

        if(optionalEvenement.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        evenementToUpdate.setIdEvenement(id);
        evenementDAO.save(evenementToUpdate);

        return new ResponseEntity<>(evenementToUpdate,HttpStatus.OK);
    }

}
