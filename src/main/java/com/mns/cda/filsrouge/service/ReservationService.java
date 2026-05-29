package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IReservationService;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.dao.SeatDAO;
import com.mns.cda.filsrouge.dao.StatusPresenceDAO;
import com.mns.cda.filsrouge.dto.CanReserveDTO;
import com.mns.cda.filsrouge.dto.CreateReservation;
import com.mns.cda.filsrouge.dto.ReservationConfirmation;
import com.mns.cda.filsrouge.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    protected final ReservationDAO reservationDAO;
    protected final SeatDAO seatDAO;
    protected final EventDAO eventDAO;
    protected final StatusPresenceDAO statusPresenceDAO;

    //GetAll
    @Override
    public List<Reservation> findAll() { return reservationDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Reservation> findById(int id) {
        return reservationDAO.findById(id);
    }

    @Override
    // Vérifie si la réservation est possible pour un utilisateur donné et un événement donné
    public CanReserveDTO canReserve(int eventId, int userId) {

        boolean alreadyReserved = reservationDAO.userHasReservation(eventId, userId);

        boolean isFull = seatDAO.isFull(eventId);

        boolean isPast = eventDAO.findById(eventId)
                .map(e -> e.getEventDate().isBefore(LocalDateTime.now()))
                .orElse(true);

        return new CanReserveDTO(alreadyReserved, isFull, isPast);
    }

    //Post
    @Override
    public ReservationConfirmation createReservation(CreateReservation reservation, int userId) {

        //vérifie que l'événement existe
        Event event = eventDAO.findById(reservation.eventId())
                .orElseThrow(() -> new RuntimeException("Événement introuvable"));
        // vérifie que l'événement n'est pas déjà passé
        if (event.getEventDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Impossible de réserver pour un événement passé");
        }
        // vérifie que l'utilisateur n'a pas déjà
        boolean alreadyReserved = reservationDAO.userHasReservation(reservation.eventId(), userId);
        if (alreadyReserved) {
            throw new RuntimeException("Vous avez déjà une réservation pour cet événement");
        }
        //vérifie que les sièges ne sont pas déjà réservés
        for (Integer seatId :  reservation.seatIds()) {
            if (seatDAO.seatsAlreadyReserved(reservation.eventId(), List.of(seatId))) {
                throw new RuntimeException("Le siège " + seatId + " est déjà réservé pour cet événement");
            }
        }
        // Change les id des sièges en objet sièges.
        List<Seat> seats = new ArrayList<>();
        for (Integer seatId : reservation.seatIds()) {
            Seat seat = seatDAO.findById(seatId)
                    .orElseThrow(() -> new RuntimeException("Siège introuvable : " + seatId));
            seats.add(seat);
        }
        //affecte la valeur par défaut de statusPresence
        StatusPresence pending = statusPresenceDAO.findById(3)
                .orElseThrow(() -> new RuntimeException("Statut introuvable"));


        //Création de la réservation
        Reservation reservationToCreate = new Reservation();
        reservationToCreate.setEvent(event);
        reservationToCreate.setUser(new AppUser(userId));
        reservationToCreate.setSeats(seats);
        reservationToCreate.setStatusPresence(pending);

        Reservation saved =  reservationDAO.save(reservationToCreate);

        // Construction du DTO ReservationConfirmation de réponse
        return new ReservationConfirmation(
                saved.getIdReservation(),
                event.getEventName(),
                seats.stream().map(Seat::getSeatNumber).toList()
        );

    }

    //TODO
    @Override
    public void create(Reservation Reservation) {

    }

    //Delete
    @Override
    public void delete(int id) {
        reservationDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Reservation Reservation) throws ReservationNotFoundException {
        Optional<Reservation> ReservationOptional = reservationDAO.findById(id);

        if(ReservationOptional.isEmpty()) {
            throw new ReservationNotFoundException();
        }
        Reservation.setIdReservation(id);
        reservationDAO.save(Reservation);
    }

}
