package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.PlatformDAO;
import com.mns.cda.filsrouge.model.Platform;
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
@RequestMapping("/platform")
@Tag(name = "Tribune", description = "API de gestion des différents tribunes")
@CrossOrigin
public class PlatformController {


    protected final PlatformDAO platformDAO;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents tribunes",
            description = "Cette méthode permet de récupérer la liste de tous les tribunes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des tribunes récupérée avec succès")
    })
    public List<Platform> getPlatformList() {
        return platformDAO.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un tribune par son ID",
            description = "Cette méthode permet de récupérer les informations d'un tribune spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tribune récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Tribune non trouvée")
    })
    public ResponseEntity<Platform> getPlatformById(@PathVariable int id) {

        Optional<Platform> optionalPlatform = platformDAO.findById(id);

        if(optionalPlatform.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalPlatform.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute une tribune à la base de données",
            description = "Cette méthode permet de d'ajouter une nouvelle tribune en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tribune ajoutée avec succès")
    })
    public ResponseEntity<Platform> create(@RequestBody Platform platformToInsert) {

        platformToInsert.setIdPlatform(null);
        platformDAO.save(platformToInsert);

        return new ResponseEntity<>(platformToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une tribune par son ID",
            description = "Cette méthode permet de supprimer une tribune spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tribune supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Tribune non trouvée")
    })
    public ResponseEntity<Platform> delete(@PathVariable int id) {

        Optional<Platform> optionalPlatform = platformDAO.findById(id);

        if(optionalPlatform.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        platformDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie une tribune par son ID",
            description = "Cette méthode permet de modifier les informations d'une tribune spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tribune modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Tribune non trouvée")
    })
    public ResponseEntity<Platform> update(
            @PathVariable int id,
            @RequestBody Platform platformToUpdate) {

        Optional<Platform> optionalPlatform = platformDAO.findById(id);

        if(optionalPlatform.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        platformToUpdate.setIdPlatform(id);
        platformDAO.save(platformToUpdate);

        return new ResponseEntity<>(platformToUpdate,HttpStatus.OK);
    }

}
