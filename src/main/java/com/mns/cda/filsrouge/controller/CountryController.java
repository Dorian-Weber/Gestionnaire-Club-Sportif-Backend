package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.ICountryService;
import com.mns.cda.filsrouge.model.Country;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.view.CountryView;
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
@RequestMapping("/country")
@Tag(name = "Pays", description = "API de gestion des différents pays")
@CrossOrigin
public class CountryController {

    private final ICountryService countryService;


    @GetMapping("/list")
    @JsonView(CountryView.class)
    @Operation(summary = "Récupère la liste de tous les pays",
            description = "Cette route permet de récupérer la liste de tous les pays présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des pays récupérée avec succès")
    })
    public List<Country> getCountryList() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(CountryView.class)
    @Operation(summary = "Récupère un pays par son ID",
            description = "Cette route permet de récupérer les informations d'un pays spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pays récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    })
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {

        Optional<Country> optionalCountry = countryService.findById(id);

        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalCountry.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un pays à la base de données",
            description = "Cette route permet de d'ajouter un nouveau pays en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pays ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<Country> create(@RequestBody Country countryToInsert) {

        countryService.create(countryToInsert);

        return new ResponseEntity<>(countryToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un pays par son ID",
            description = "Cette route permet de supprimer un pays spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pays supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    })
    @isAdmin
    public ResponseEntity<Country> delete(@PathVariable Integer id) {

        Optional<Country> optionalCountry = countryService.findById(id);

        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un pays par son ID",
            description = "Cette route permet de modifier les informations d'un pays spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pays modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    })
    @isAdmin
    public ResponseEntity<Country> update(
            @PathVariable Integer id,
            @RequestBody Country countryToUpdate) {

        try {
            countryService.update(id, countryToUpdate);
            return new ResponseEntity<>(countryToUpdate, HttpStatus.OK);
        } catch (ICountryService.CountryNotFoundException e) {
            return new ResponseEntity<>(countryToUpdate, HttpStatus.NOT_FOUND);
        }

    }
}
