package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.AthleteDAO;
import com.mns.cda.filsrouge.model.Athlete;
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
@RequestMapping("/Athlete")
@Tag(name = "Athlete", description = "API de gestion des différents Athlètes")
public class AthleteController {


    protected final AthleteDAO athleteDAO;

    @GetMapping("/liste")
    @Operation(summary = "Récupère la liste des différents Athlètes",
            description = "Cette méthode permet de récupérer la liste de tous les Athlètes présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des Athlètes récupérée avec succès")
    })
    public List<Athlete> getAthleteList() {
        return athleteDAO.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un Athlète par son ID",
            description = "Cette méthode permet de récupérer les informations d'un Athlète spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Athlète récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Athlète non trouvé")
    })
    public ResponseEntity<Athlete> getAthleteById(@PathVariable int id) {

        Optional<Athlete> optionalAthlete = athleteDAO.findById(id);

        if(optionalAthlete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAthlete.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un Athlète à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau Athlète en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Athlète ajoutée avec succès")
    })
    public ResponseEntity<Athlete> create(@RequestBody Athlete athleteToInsert) {

        athleteToInsert.setIdAthlete(null);
        athleteDAO.save(athleteToInsert);

        return new ResponseEntity<>(athleteToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un Athlète par son ID",
            description = "Cette méthode permet de supprimer un Athlète spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Athlète supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Athlète non trouvé")
    })
    public ResponseEntity<Athlete> delete(@PathVariable int id) {

        Optional<Athlete> optionalAthlete = athleteDAO.findById(id);

        if(optionalAthlete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        athleteDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un Athlète par son ID",
            description = "Cette méthode permet de modifier les informations d'un Athlète spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Athlète modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Athlète non trouvé")
    })
    public ResponseEntity<Athlete> update(
            @PathVariable int id,
            @RequestBody Athlete athleteToUpdate) {

        Optional<Athlete> optionalAthlete = athleteDAO.findById(id);

        if(optionalAthlete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        athleteToUpdate.setIdAthlete(id);
        athleteDAO.save(athleteToUpdate);

        return new ResponseEntity<>(athleteToUpdate,HttpStatus.OK);
    }

}
