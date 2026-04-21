package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Level;

import java.util.List;
import java.util.Optional;

public interface ILevelService {

    public static class LevelNotFoundException extends Exception {}

    //GetAll
    List<Level> findAll();

    //GetByID
    Optional<Level> findById(int id);

    //Post
    void create(Level Level);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Level level) throws LevelNotFoundException;

}
