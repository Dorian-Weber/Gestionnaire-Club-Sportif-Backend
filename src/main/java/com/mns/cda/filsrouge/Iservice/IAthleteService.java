package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Athlete;

import java.util.List;
import java.util.Optional;

public interface IAthleteService {

    public static class AthleteNotFoundException extends Exception {}

    //GetAll
    List<Athlete> findAll();

    //GetByID
    Optional<Athlete> findById(int id);

    //Post
    void create(Athlete athlete);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Athlete athlete) throws AthleteNotFoundException;

}
