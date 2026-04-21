package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Seat;

import java.util.List;
import java.util.Optional;

public interface ISeatService {

    public static class SeatNotFoundException extends Exception {}

    //GetAll
    List<Seat> findAll();

    //GetByID
    Optional<Seat> findById(int id);

    //Post
    void create(Seat Seat);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Seat Seat) throws SeatNotFoundException;

}
