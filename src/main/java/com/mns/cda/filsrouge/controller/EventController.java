package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.dto.EventFull;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.service.EventAggregationService;
import com.mns.cda.filsrouge.view.EventView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
@Tag(name = "Événement", description = "API de gestion des différents évènements")
@CrossOrigin
public class EventController {


    protected final IEventService eventService;
    private final EventAggregationService eventAggregationService;

    @GetMapping("/list")
    @JsonView(EventView.class)
    @Operation(summary = "Récupère la liste des différents évènements",
            description = "Cette méthode permet de récupérer la liste de tous les évènements présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des évènements récupérée avec succès")
    })
    public List<Event> getEventList() {
        return eventService.findAll();
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

        Optional<Event> optionalEvent = eventService.findById(id);

        if(optionalEvent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalEvent.get(), HttpStatus.OK);
    }

    // Mapping requêtes personnalisées en GET
    @GetMapping("/next")
    public List<EventLight> getEventLight() {
        return eventService.findNextEventLight();
    }

    @GetMapping("/list-event")
    public List<EventMedium> getEventMedium() {
        return eventService.findEventMedium();
    }

    @GetMapping("/eventMedium/{idEvent}")
    public ResponseEntity<EventMedium> getEventMediumById(@PathVariable int idEvent) {

        Optional<EventMedium> optionalEventMedium = eventService.findEventMediumById(idEvent);

        if(optionalEventMedium.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalEventMedium.get(), HttpStatus.OK);
    }

    @GetMapping("/list-event/search")
    public List<EventMedium> getEventMediumByFilter(
            @RequestParam(required = false) String sportName,
            @RequestParam(required = false) String eventTypeName,
            @RequestParam(required = false) String search,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateMin) {

        if (dateMin != null && dateMin.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La date minimale doit être supérieure ou égale à la date actuelle.");
        } else if (dateMin == null) {
            dateMin = LocalDate.now();
        }
        return eventService.findEventMediumByFilter(sportName, eventTypeName, search, dateMin);
    }

    @GetMapping("/{idEvent}/full")
    public EventFull getEventFull(@PathVariable int idEvent) {
        return eventAggregationService.getEventFull(idEvent);
    }


    @PostMapping
    @Operation(summary = "Ajoute un évènement à la base de données",
            description = "Cette méthode permet de d'ajouter un nouvel évènement en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Évènement ajoutée avec succès")
    })
    public ResponseEntity<Event> create(@RequestBody Event eventToInsert) {

        eventService.create(eventToInsert);

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

        Optional<Event> optionalEvent = eventService.findById(id);

        if(optionalEvent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        eventService.delete(id);

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

        try {
            eventService.update(id, eventToUpdate);
            return new ResponseEntity<>(eventToUpdate, HttpStatus.OK);
        } catch (IEventService.EventNotFoundException e) {
            return new ResponseEntity<>(eventToUpdate, HttpStatus.NOT_FOUND);
        }
    }

}
