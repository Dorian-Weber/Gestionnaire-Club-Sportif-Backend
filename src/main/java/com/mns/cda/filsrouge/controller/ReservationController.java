package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.model.Reservation;
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
@RequestMapping("/reservation")
@Tag(name = "Réservation", description = "API de gestion des différents réservations")
@CrossOrigin
public class ReservationController {


    protected final ReservationDAO reservationDAO;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents reservations",
            description = "Cette méthode permet de récupérer la liste de tous les reservations dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des reservations récupérée avec succès")
    })
    public List<Reservation> getReservationList() {
        return reservationDAO.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une reservation par son ID",
            description = "Cette méthode permet de récupérer les informations d'une reservation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Reservation non trouvée")
    })
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {

        Optional<Reservation> optionalReservation = reservationDAO.findById(id);

        if(optionalReservation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalReservation.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute une reservation à la base de données",
            description = "Cette méthode permet de d'ajouter une nouvelle reservation en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reservation ajoutée avec succès")
    })
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservationToInsert) {

        reservationToInsert.setIdReservation(null);
        reservationDAO.save(reservationToInsert);

        return new ResponseEntity<>(reservationToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une reservation par son ID",
            description = "Cette méthode permet de supprimer une reservation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reservation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Reservation non trouvée")
    })
    public ResponseEntity<Reservation> delete(@PathVariable int id) {

        Optional<Reservation> optionalReservation = reservationDAO.findById(id);

        if(optionalReservation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reservationDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie une reservation par son ID",
            description = "Cette méthode permet de modifier les informations d'une reservation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Reservation non trouvée")
    })
    public ResponseEntity<Reservation> update(
            @PathVariable int id,
            @RequestBody Reservation reservationToUpdate) {

        Optional<Reservation> optionalReservation = reservationDAO.findById(id);

        if(optionalReservation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reservationToUpdate.setIdReservation(id);
        reservationDAO.save(reservationToUpdate);

        return new ResponseEntity<>(reservationToUpdate,HttpStatus.OK);
    }

}
