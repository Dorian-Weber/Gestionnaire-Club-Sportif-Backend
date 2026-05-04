package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.ITeamService;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Team;
import com.mns.cda.filsrouge.service.TeamService;
import com.mns.cda.filsrouge.view.TeamView;
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
@RequestMapping("/team")
@Tag(name = "Équipe", description = "API de gestion des différentes équipes")
@CrossOrigin
public class TeamController {

    private final TeamService teamService;


    @GetMapping("/list")
    @JsonView(TeamView.class)
    @Operation(summary = "Récupère la liste de toutes les équipes",
            description = "Cette méthode permet de récupérer la liste de toutes les équipes présentes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des équipes récupérée avec succès")
    })
    public List<Team> getTeamList() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(TeamView.class)
    @Operation(summary = "Récupérer une équipe par son ID",
            description = "Cette méthode permet de récupérer les informations d'une équipe spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Équipe récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Équipe non trouvé")
    })
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {

        Optional<Team> optionalTeam = teamService.findById(id);

        if (optionalTeam.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTeam.get(), HttpStatus.OK);
    }

    @GetMapping("/Event/{idEvent}")
    public List<TeamDTO> getTeamEvents(@PathVariable Integer idEvent) {
        return List.of();
    }

    @GetMapping("/TeamDTO/{idTeam}")
    public TeamDTO getTeamDTO(@PathVariable Integer idTeam) {
        return teamService.getTeamDTO(idTeam);
    }

    @PostMapping
    @Operation(summary = "Ajoute une équipe à la base de données",
            description = "Cette méthode permet de d'ajouter une nouvelle équipe en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Équipe ajoutée avec succès")
    })
    public ResponseEntity<Team> create(@RequestBody Team teamToInsert) {

        teamService.create(teamToInsert);

        return new ResponseEntity<>(teamToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une équipe par son ID",
            description = "Cette méthode permet de supprimer une équipe spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Équipe supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Équipe non trouvé")
    })
    public ResponseEntity<Team> delete(@PathVariable Integer id) {

        Optional<Team> optionalTeam = teamService.findById(id);

        if (optionalTeam.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teamService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie une équipe par son ID",
            description = "Cette méthode permet de modifier les informations d'une équipe spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Équipe modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Équipe non trouvé")
    })
    public ResponseEntity<Team> update(
            @PathVariable Integer id,
            @RequestBody Team teamToUpdate) {

        try {
            teamService.update(id, teamToUpdate);
            return new ResponseEntity<>(teamToUpdate, HttpStatus.OK);
        } catch (ITeamService.TeamNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
