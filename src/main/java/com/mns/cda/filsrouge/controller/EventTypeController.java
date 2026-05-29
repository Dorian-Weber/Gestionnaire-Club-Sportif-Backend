package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IEventTypeService;
import com.mns.cda.filsrouge.dto.EventTypeField;
import com.mns.cda.filsrouge.model.EventType;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
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

    @GetMapping("/field")
    @Operation(summary = "Récupère la liste des différents types d'évènements",
            description = "Cette route permet de récupérer la liste de tous les types d'évènements présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des types d'évènements récupérée avec succès")
    })
    public List<EventTypeField> findAllEventTypeField() {
        return eventTypeService.findAllEventTypeField();
    }


    @PostMapping
    @Operation(summary = "Ajoute un type d'évènement à la base de données",
            description = "Cette route permet de d'ajouter un nouveau type d'évènement en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Type d'évènement ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<EventType> create(@RequestBody EventType eventTypeToInsert) {

        eventTypeService.create(eventTypeToInsert);

        return new ResponseEntity<>(eventTypeToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un type d'évènement par son ID",
            description = "Cette route permet de supprimer un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Type d'évènement supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    @isAdmin
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
            description = "Cette route permet de modifier les informations d'un type d'évènement spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type d'évènement modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Type d'évènement non trouvé")
    })
    @isAdmin
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
