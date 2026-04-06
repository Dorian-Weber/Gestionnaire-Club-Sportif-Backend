package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.LevelDAO;
import com.mns.cda.filsrouge.model.Level;
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
public class LevelController {


    protected final LevelDAO levelDAO;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents niveaux",
            description = "Cette méthode permet de récupérer la liste de tous les niveaux dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des niveaux récupérée avec succès")
    })
    public List<Level> getLevelList() {
        return levelDAO.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un niveau par son ID",
            description = "Cette méthode permet de récupérer les informations d'un niveau spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Niveau récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Niveau non trouvé")
    })
    public ResponseEntity<Level> getLevelById(@PathVariable int id) {

        Optional<Level> optionalLevel = levelDAO.findById(id);

        if(optionalLevel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalLevel.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un niveau à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau niveau en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Niveau ajouté avec succès")
    })
    public ResponseEntity<Level> create(@RequestBody Level levelToInsert) {

        levelToInsert.setIdLevel(null);
        levelDAO.save(levelToInsert);

        return new ResponseEntity<>(levelToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un niveau par son ID",
            description = "Cette méthode permet de supprimer un niveau spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Niveau supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Niveau non trouvé")
    })
    public ResponseEntity<Level> delete(@PathVariable int id) {

        Optional<Level> optionalLevel = levelDAO.findById(id);

        if(optionalLevel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        levelDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un niveau par son ID",
            description = "Cette méthode permet de modifier les informations d'un niveau spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Niveau modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Niveau non trouvé")
    })
    public ResponseEntity<Level> update(
            @PathVariable int id,
            @RequestBody Level levelToUpdate) {

        Optional<Level> optionalLevel = levelDAO.findById(id);

        if(optionalLevel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        levelToUpdate.setIdLevel(id);
        levelDAO.save(levelToUpdate);

        return new ResponseEntity<>(levelToUpdate,HttpStatus.OK);
    }

}
