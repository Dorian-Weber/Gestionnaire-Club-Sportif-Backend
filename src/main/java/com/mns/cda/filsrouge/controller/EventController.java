package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.view.EventView;
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
@RequestMapping("/event")
@Tag(name = "Événement", description = "API de gestion des différents évènements")
@CrossOrigin
public class EventController {


    protected final EventDAO eventDAO;

    @GetMapping("/list")
    @JsonView(EventView.class)
    @Operation(summary = "Récupère la liste des différents évènements",
            description = "Cette méthode permet de récupérer la liste de tous les évènements présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des évènements récupérée avec succès")
    })
    public List<Event> getEventList() {
        return eventDAO.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(EventView.class)
    @Operation(summary = "Récupérer un évènement par son ID",
            description = "Cette méthode permet de récupérer les informations d'un évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Évènement récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Évènement non trouvé")
    })
    public ResponseEntity<Event> getEventById(@PathVariable int id) {

        Optional<Event> optionalEvent = eventDAO.findById(id);

        if(optionalEvent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalEvent.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un évènement à la base de données",
            description = "Cette méthode permet de d'ajouter un nouvel évènement en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Évènement ajoutée avec succès")
    })
    public ResponseEntity<Event> create(@RequestBody Event eventToInsert) {

        eventToInsert.setIdEvent(null);
        eventDAO.save(eventToInsert);

        return new ResponseEntity<>(eventToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un évènement par son ID",
            description = "Cette méthode permet de supprimer un évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Évènement supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Évènement non trouvé")
    })
    public ResponseEntity<Event> delete(@PathVariable int id) {

        Optional<Event> optionalEvent = eventDAO.findById(id);

        if(optionalEvent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        eventDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un évènement par son ID",
            description = "Cette méthode permet de modifier les informations d'un évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Évènement modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Évènement non trouvé")
    })
    public ResponseEntity<Event> update(
            @PathVariable int id,
            @RequestBody Event eventToUpdate) {

        Optional<Event> optionalEvent = eventDAO.findById(id);

        if(optionalEvent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        eventToUpdate.setIdEvent(id);
        eventDAO.save(eventToUpdate);

        return new ResponseEntity<>(eventToUpdate,HttpStatus.OK);
    }

}
