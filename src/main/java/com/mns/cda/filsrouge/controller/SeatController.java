package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.ISeatService;
import com.mns.cda.filsrouge.aggregation.SeatAggregationService;
import com.mns.cda.filsrouge.dto.SeatDTO;
import com.mns.cda.filsrouge.model.Seat;
import com.mns.cda.filsrouge.security.AppUserDetails;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
import com.mns.cda.filsrouge.view.SeatView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seat")
@Tag(name = "Siège", description = "API de gestion des différents sièges")
@CrossOrigin
public class SeatController {


    protected final ISeatService seatService;
    private final SeatAggregationService seatAggregationService;

    @GetMapping("/list")
    @JsonView(SeatView.class)
    @Operation(summary = "Récupère la liste des différents sièges",
            description = "Cette route permet de récupérer la liste de tous les sièges dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des sièges récupérée avec succès")
    })
    @isAdmin
    public List<Seat> getSeatList() {
        return seatService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(SeatView.class)
    @Operation(summary = "Récupérer un siège par son ID",
            description = "Cette route permet de récupérer les informations d'un siège spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Siège récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Siège non trouvé")
    })
    @isAdmin
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {

        Optional<Seat> optionalSeat = seatService.findById(id);

        if(optionalSeat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSeat.get(), HttpStatus.OK);
    }

    @GetMapping("/reserved/{eventId}")
    @Operation(summary = "Récupère les listes des différents sièges libre, réserver, réserver par un ami pour un événement",
            description = "Cette route permet de récupérer les listes de tous les sièges libre, réservé, réservé par un amis dans une tribune et un niveau choisi pour un événement.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des sièges récupérée avec succès")
    })
    public List<SeatDTO> getReservedSeatsByEventId(@PathVariable int eventId,
                                                   @AuthenticationPrincipal AppUserDetails currentUser,
                                                   @RequestParam String platform,
                                                   @RequestParam String level
    ) {

        return seatAggregationService.getSeatsForEvent(
                eventId, currentUser.getUser().getIdAppUser(), platform, level
        );
    }


    @PostMapping
    @Operation(summary = "Ajoute un siège à la base de données",
            description = "Cette route permet d'ajouter un nouveau siège en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Siège ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<Seat> create(@RequestBody Seat seatToInsert) {

        seatService.create(seatToInsert);

        return new ResponseEntity<>(seatToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un siège par son ID",
            description = "Cette route permet de supprimer un siège spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Siège supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Siège non trouvé")
    })
    @isAdmin
    public ResponseEntity<Seat> delete(@PathVariable int id) {

        Optional<Seat> optionalSeat = seatService.findById(id);

        if(optionalSeat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        seatService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un siège par son ID",
            description = "Cette route permet de modifier les informations d'un siège spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Siège modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Siège non trouvé")
    })
    @isAdmin
    public ResponseEntity<Seat> update(
            @PathVariable int id,
            @RequestBody Seat seatToUpdate) {

        try {
            seatService.update(id, seatToUpdate);
            return new ResponseEntity<>(seatToUpdate, HttpStatus.OK);
        } catch (ISeatService.SeatNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
