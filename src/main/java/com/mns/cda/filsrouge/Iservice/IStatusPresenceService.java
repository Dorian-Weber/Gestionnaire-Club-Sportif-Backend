package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.StatusPresence;

import java.util.List;
import java.util.Optional;

public interface IStatusPresenceService {

    public static class StatusPresenceNotFoundException extends Exception {}

    //GetAll
    List<StatusPresence> findAll();

    //GetByID
    Optional<StatusPresence> findById(int id);

    //Post
    void create(StatusPresence StatusPresence);

    //Delete
    void delete(int id);

    //Put
    void update(int id, StatusPresence StatusPresence) throws StatusPresenceNotFoundException;

}
