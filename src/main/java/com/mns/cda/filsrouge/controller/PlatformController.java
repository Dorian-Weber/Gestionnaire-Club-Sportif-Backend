package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.IPlatformService;
import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.view.PlatformView;
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


    protected final IPlatformService platformService;

    @GetMapping("/list")
    @JsonView(PlatformView.class)
    @Operation(summary = "Récupère la liste des différents tribunes",
            description = "Cette méthode permet de récupérer la liste de tous les tribunes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des tribunes récupérée avec succès")
    })
    public List<Platform> getPlatformList() {
        return platformService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(PlatformView.class)
    @Operation(summary = "Récupérer un tribune par son ID",
            description = "Cette méthode permet de récupérer les informations d'un tribune spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tribune récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Tribune non trouvée")
    })
    public ResponseEntity<Platform> getPlatformById(@PathVariable int id) {

        Optional<Platform> optionalPlatform = platformService.findById(id);

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

        platformService.create(platformToInsert);

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

        Optional<Platform> optionalPlatform = platformService.findById(id);

        if(optionalPlatform.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        platformService.delete(id);

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

        try {
            platformService.update(id, platformToUpdate);
            return new ResponseEntity<>(platformToUpdate, HttpStatus.OK);
        } catch (IPlatformService.PlatformNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
