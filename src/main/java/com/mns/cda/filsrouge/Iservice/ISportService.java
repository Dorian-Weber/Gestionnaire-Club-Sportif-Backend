package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.SportField;
import com.mns.cda.filsrouge.model.Sport;

import java.util.List;
import java.util.Optional;

public interface ISportService {

    public static class SportNotFoundException extends Exception {}

    //GetAll
    List<Sport> findAll();

    //GetAllbyDTO
    List<SportField>  findAllSportField();

    //GetByID
    Optional<Sport> findById(int id);

    //Post
    void create(Sport Sport);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Sport Sport) throws SportNotFoundException;

}
