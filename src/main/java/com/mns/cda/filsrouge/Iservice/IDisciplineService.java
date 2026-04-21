package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Discipline;

import java.util.List;
import java.util.Optional;

public interface IDisciplineService {

    public static class DisciplineNotFoundException extends Exception {}

    //GetAll
    List<Discipline> findAll();

    //GetByID
    Optional<Discipline> findById(int id);

    //Post
    void create(Discipline discipline);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Discipline discipline) throws DisciplineNotFoundException;

}
