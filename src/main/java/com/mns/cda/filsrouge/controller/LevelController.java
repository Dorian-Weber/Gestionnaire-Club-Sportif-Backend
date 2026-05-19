package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.IAccountTypeService;
import com.mns.cda.filsrouge.Iservice.ILevelService;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
import com.mns.cda.filsrouge.view.LevelView;
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
@RequestMapping("/level")
@Tag(name = "Niveau", description = "API de gestion des différents niveaux")
@CrossOrigin
public class LevelController {


    protected final ILevelService levelService;

    @GetMapping("/list")
    @JsonView(LevelView.class)
    @Operation(summary = "Récupère la liste des différents niveaux",
            description = "Cette route permet de récupérer la liste de tous les niveaux dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des niveaux récupérée avec succès")
    })
    @isUser
    public List<Level> getLevelList() {
        return levelService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(LevelView.class)
    @Operation(summary = "Récupère un niveau par son ID",
            description = "Cette route permet de récupérer les informations d'un niveau spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Niveau récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Niveau non trouvé")
    })
    @isUser
    public ResponseEntity<Level> getLevelById(@PathVariable int id) {

        Optional<Level> optionalLevel = levelService.findById(id);

        if (optionalLevel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalLevel.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un niveau à la base de données",
            description = "Cette route permet de d'ajouter un nouveau niveau en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Niveau ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<Level> create(@RequestBody Level levelToInsert) {

        levelService.create(levelToInsert);

        return new ResponseEntity<>(levelToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un niveau par son ID",
            description = "Cette route permet de supprimer un niveau spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Niveau supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Niveau non trouvé")
    })
    @isAdmin
    public ResponseEntity<Level> delete(@PathVariable int id) {

        Optional<Level> optionalLevel = levelService.findById(id);

        if (optionalLevel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        levelService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un niveau par son ID",
            description = "Cette route permet de modifier les informations d'un niveau spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Niveau modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Niveau non trouvé")
    })
    @isAdmin
    public ResponseEntity<Level> update(
            @PathVariable int id,
            @RequestBody Level levelToUpdate) {

        try {
            levelService.update(id, levelToUpdate);
            return new ResponseEntity<>(levelToUpdate, HttpStatus.OK);
        } catch (ILevelService.LevelNotFoundException e) {
            return new ResponseEntity<>(levelToUpdate, HttpStatus.NOT_FOUND);
        }

    }
}
