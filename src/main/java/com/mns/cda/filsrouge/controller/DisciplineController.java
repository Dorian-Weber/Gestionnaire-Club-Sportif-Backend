package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.ICountryService;
import com.mns.cda.filsrouge.Iservice.IDisciplineService;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.view.DisciplineView;
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
@RequestMapping("/discipline")
@Tag(name = "Discipline", description = "API de gestion des différentes disciplines")
@CrossOrigin
public class DisciplineController {

    private final IDisciplineService disciplineService;


    @GetMapping("/list")
    @JsonView(DisciplineView.class)
    @Operation(summary = "Récupère la liste de toutes les disciplines",
            description = "Cette méthode permet de récupérer la liste de toutes les disciplines présentes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des disciplines récupérée avec succès")
    })
    public List<Discipline> getDisciplineList() {
        return disciplineService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(DisciplineView.class)
    @Operation(summary = "Récupérer une discipline par son ID",
            description = "Cette méthode permet de récupérer les informations d'une discipline spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discipline récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Discipline non trouvé")
    })
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable Integer id) {

        Optional<Discipline> optionalDiscipline = disciplineService.findById(id);

        if (optionalDiscipline.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalDiscipline.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute une discipline à la base de données",
            description = "Cette méthode permet de d'ajouter une nouvelle discipline en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Discipline ajoutée avec succès")
    })
    public ResponseEntity<Discipline> create(@RequestBody Discipline disciplineToInsert) {

        disciplineService.create(disciplineToInsert);

        return new ResponseEntity<>(disciplineToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une discipline par son ID",
            description = "Cette méthode permet de supprimer une discipline spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Discipline supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Discipline non trouvé")
    })
    public ResponseEntity<Discipline> delete(@PathVariable Integer id) {

        Optional<Discipline> optionalDiscipline = disciplineService.findById(id);

        if (optionalDiscipline.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        disciplineService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie une discipline par son ID",
            description = "Cette méthode permet de modifier les informations d'une discipline spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discipline modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Discipline non trouvé")
    })
    public ResponseEntity<Discipline> update(
            @PathVariable Integer id,
            @RequestBody Discipline disciplineToUpdate) {

        try {
            disciplineService.update(id, disciplineToUpdate);
            return new ResponseEntity<>(disciplineToUpdate, HttpStatus.OK);
        } catch (IDisciplineService.DisciplineNotFoundException e) {
            return new ResponseEntity<>(disciplineToUpdate, HttpStatus.NOT_FOUND);
        }

    }
}
