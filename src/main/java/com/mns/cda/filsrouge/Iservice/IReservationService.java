package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface IReservationService {

    public static class ReservationNotFoundException extends Exception {}

    //GetAll
    List<Reservation> findAll();

    //GetByID
    Optional<Reservation> findById(int id);

    //Post
    void create(Reservation Reservation);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Reservation Reservation) throws ReservationNotFoundException;

}
