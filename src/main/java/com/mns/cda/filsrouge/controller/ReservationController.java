package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.IReservationService;
import com.mns.cda.filsrouge.dto.CanReserveDTO;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.security.AppUserDetails;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
import com.mns.cda.filsrouge.view.ReservationView;
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
@RequestMapping("/reservation")
@Tag(name = "Réservation", description = "API de gestion des différents réservations")
@CrossOrigin
public class ReservationController {


    protected final IReservationService reservationService;

    @GetMapping("/list")
    @JsonView(ReservationView.class)
    @Operation(summary = "Récupère la liste des différents reservations",
            description = "Cette route permet de récupérer la liste de tous les reservations dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des reservations récupérée avec succès")
    })
    @isAdmin
    public List<Reservation> getReservationList() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView({ReservationView.class})
    @Operation(summary = "Récupérer une reservation par son ID",
            description = "Cette route permet de récupérer les informations d'une reservation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Reservation non trouvée")
    })
    @isUser
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {

        Optional<Reservation> optionalReservation = reservationService.findById(id);

        if(optionalReservation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalReservation.get(), HttpStatus.OK);
    }

    @GetMapping("/has-reserved")
    @isUser
    public boolean hasReserved(@RequestParam int idEvent,
                               @AuthenticationPrincipal AppUserDetails user
    ) {
        return reservationService.userHasReservation(idEvent, user.getUser().getIdAppUser());
    }

    @GetMapping("/can-reserve/{eventId}")
    @isUser
    public CanReserveDTO canReserve(
            @PathVariable int eventId,
            @AuthenticationPrincipal AppUserDetails user
    ) {
        return reservationService.canReserve(eventId, user.getUser().getIdAppUser());
    }


    @PostMapping
    @Operation(summary = "Ajoute une reservation à la base de données",
            description = "Cette route permet de d'ajouter une nouvelle reservation en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reservation ajoutée avec succès")
    })
    @isUser
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservationToInsert) {

        reservationService.create(reservationToInsert);

        return new ResponseEntity<>(reservationToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une reservation par son ID",
            description = "Cette route permet de supprimer une reservation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reservation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Reservation non trouvée")
    })
    @isUser
    public ResponseEntity<Reservation> delete(@AuthenticationPrincipal AppUserDetails userDetails,
                                              @PathVariable int id) {

        Optional<Reservation> optionalReservation = reservationService.findById(id);

        if(optionalReservation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!userDetails.getUser().getAccountType().getAccountTypeName().equals("ADMIN")
        && !optionalReservation.get().getUser().getIdAppUser().equals(userDetails.getUser().getIdAppUser())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        reservationService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie une reservation par son ID",
            description = "Cette méthode permet de modifier les informations d'une reservation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Reservation non trouvée")
    })
    @isAdmin
    public ResponseEntity<Reservation> update(
            @PathVariable int id,
            @RequestBody Reservation reservationToUpdate) {

        try {
            reservationService.update(id, reservationToUpdate);
            return new ResponseEntity<>(reservationToUpdate, HttpStatus.OK);
        } catch (IReservationService.ReservationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
