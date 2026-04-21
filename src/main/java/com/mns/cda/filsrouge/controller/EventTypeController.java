package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.Iservice.IEventTypeService;
import com.mns.cda.filsrouge.model.EventType;
import com.mns.cda.filsrouge.view.EventTypeView;
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
@RequestMapping("/event-type")
@Tag(name = "Type évènement", description = "API de gestion des différents types d'évènements")
@CrossOrigin
public class EventTypeController {


    protected final IEventTypeService eventTypeService;

    @GetMapping("/list")
    @JsonView(EventTypeView.class)
    @Operation(summary = "Récupère la liste des différents types d'évènements",
            description = "Cette méthode permet de récupérer la liste de tous les types d'évènements présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des types d'évènements récupérée avec succès")
    })
    public List<EventType> getEventTypeList() {
        return eventTypeService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(EventTypeView.class)
    @Operation(summary = "Récupérer un type d'évènement par son ID",
            description = "Cette méthode permet de récupérer les informations d'un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type d'évènement récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    public ResponseEntity<EventType> getEventTypeById(@PathVariable int id) {

        Optional<EventType> optionalEventType = eventTypeService.findById(id);

        if(optionalEventType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalEventType.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un type d'évènement à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau type d'évènement en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Type d'évènement ajoutée avec succès")
    })
    public ResponseEntity<EventType> create(@RequestBody EventType eventTypeToInsert) {

        eventTypeService.create(eventTypeToInsert);

        return new ResponseEntity<>(eventTypeToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un type d'évènement par son ID",
            description = "Cette méthode permet de supprimer un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Type d'évènement supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    public ResponseEntity<EventType> delete(@PathVariable int id) {

        Optional<EventType> optionalEventType = eventTypeService.findById(id);

        if(optionalEventType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        eventTypeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un type d'évènement par son ID",
            description = "Cette méthode permet de modifier les informations d'un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type d'évènement modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    public ResponseEntity<EventType> update(
            @PathVariable int id,
            @RequestBody EventType eventTypeToUpdate) {

        try {
            eventTypeService.update(id, eventTypeToUpdate);
            return new ResponseEntity<>(eventTypeToUpdate, HttpStatus.OK);
        } catch (IEventTypeService.EventTypeNotFoundException e) {
            return new ResponseEntity<>(eventTypeToUpdate, HttpStatus.NOT_FOUND);
        }
    }

}
