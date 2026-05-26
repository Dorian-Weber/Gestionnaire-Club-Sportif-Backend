package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.CanReserveDTO;
import com.mns.cda.filsrouge.dto.CreateReservation;
import com.mns.cda.filsrouge.dto.ReservationConfirmation;
import com.mns.cda.filsrouge.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IReservationService {

    public static class ReservationNotFoundException extends Exception {}

    //GetAll
    List<Reservation> findAll();

    //GetByID
    Optional<Reservation> findById(int id);

    public boolean userHasReservation(int eventId, int userId);

    public CanReserveDTO canReserve(int eventId, int userId);

    //Post
    public ReservationConfirmation createReservation(CreateReservation Reservation, int userId);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Reservation Reservation) throws ReservationNotFoundException;

}
