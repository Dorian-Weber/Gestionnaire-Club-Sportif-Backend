package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.dao.CountryDAO;
import com.mns.cda.filsrouge.model.Country;
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
public class CountryController {

    private final CountryDAO countryDAO;


    @GetMapping("/list")
    @JsonView(CountryView.class)
    @Operation(summary = "Récupère la liste de tous les pays",
            description = "Cette méthode permet de récupérer la liste de tous les pays présentes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des pays récupéré avec succès")
    })
    public List<Country> getCountryList() {
        return countryDAO.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(CountryView.class)
    @Operation(summary = "Récupérer un pays par son ID",
            description = "Cette méthode permet de récupérer les informations d'un pays spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pays récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    })
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {

        Optional<Country> optionalCountry = countryDAO.findById(id);

        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalCountry.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un pays à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau pays en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pays ajouté avec succès")
    })
    public ResponseEntity<Country> create(@RequestBody Country countryToInsert) {

        countryToInsert.setIdCountry(null);
        countryDAO.save(countryToInsert);

        return new ResponseEntity<>(countryToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un pays par son ID",
            description = "Cette méthode permet de supprimer un pays spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pays supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    })
    public ResponseEntity<Country> delete(@PathVariable Integer id) {

        Optional<Country> optionalCountry = countryDAO.findById(id);

        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryDAO.delete(optionalCountry.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un pays par son ID",
            description = "Cette méthode permet de modifier les informations d'un pays spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pays modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    })
    public ResponseEntity<Country> update(
            @PathVariable Integer id,
            @RequestBody Country countryToUpdate) {

        Optional<Country> optionalCountry = countryDAO.findById(id);

        if (optionalCountry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryToUpdate.setIdCountry(id);
        countryDAO.save(countryToUpdate);

        return new ResponseEntity<>(countryToUpdate, HttpStatus.OK);

    }
}
