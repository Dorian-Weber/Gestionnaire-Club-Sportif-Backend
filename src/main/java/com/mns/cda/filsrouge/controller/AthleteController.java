package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IAthleteService;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.security.isAdmin;
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
@CrossOrigin
public class AthleteController {


    protected final IAthleteService athleteService;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents Athlètes",
            description = "Cette route permet de récupérer la liste de tous les Athlètes présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des Athlètes récupéré avec succès")
    })
    @isAdmin
    public List<Athlete> getAthleteList() {
        return athleteService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un Athlète par son ID",
            description = "Cette route permet de récupérer les informations d'un Athlète spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Athlète récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Athlète non trouvé")
    })
    @isAdmin
    public ResponseEntity<Athlete> getAthleteById(@PathVariable int id) {

        Optional<Athlete> optionalAthlete = athleteService.findById(id);

        if(optionalAthlete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAthlete.get(), HttpStatus.OK);
    }

    @GetMapping("/event/{idEvent}")
    @Operation(summary = "Récupérer les Athlètes d'un événement par l'ID de l'événement",
            description = "Cette route permet de récupérer la liste des Athlète qui participe a un événement.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste d'Athlète récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Liste d'Athlète non trouvé")
    })
    public List<AthleteDTO> findAthleteByEvent(@PathVariable int idEvent) {
        return athleteService.findAthleteByEvent(idEvent);
    }

    @GetMapping("/team/{idTeam}")
    @Operation(summary = "Récupérer la liste des Athlètes d'une équipe par son l'ID de l'équipe",
            description = "Cette route permet de récupérer la liste des Athlètes faisant partie de la même équipe par l'ID de l'équipe.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste d'Athlètes récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Liste d'Athlète non trouvée")
    })
    public List<AthleteDTO> findAthleteByTeam(@PathVariable int idTeam) {
        return athleteService.findAthleteByTeam(idTeam);
    }


    @PostMapping
    @Operation(summary = "Ajoute un Athlète à la base de données",
            description = "Cette route permet de d'ajouter un nouveau Athlète en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Athlète ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<Athlete> create(@RequestBody Athlete athleteToInsert) {

        athleteService.create(athleteToInsert);

        return new ResponseEntity<>(athleteToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un Athlète par son ID",
            description = "Cette route permet de supprimer un Athlète spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Athlète supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Athlète non trouvé")
    })
    @isAdmin
    public ResponseEntity<Athlete> delete(@PathVariable int id) {

        Optional<Athlete> optionalAthlete = athleteService.findById(id);

        if(optionalAthlete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        athleteService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un Athlète par son ID",
            description = "Cette route permet de modifier les informations d'un Athlète spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Athlète modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Athlète non trouvé")
    })
    @isAdmin
    public ResponseEntity<Athlete> update(
            @PathVariable int id,
            @RequestBody Athlete athleteToUpdate) {

        try {
            athleteService.update(id, athleteToUpdate);
            return new ResponseEntity<>(athleteToUpdate, HttpStatus.OK);
        } catch (IAthleteService.AthleteNotFoundException e) {
            return new ResponseEntity<>(athleteToUpdate, HttpStatus.NOT_FOUND);
        }
    }

}
