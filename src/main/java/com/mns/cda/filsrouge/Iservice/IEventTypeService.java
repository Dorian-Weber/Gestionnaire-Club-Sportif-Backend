package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.EventType;

import java.util.List;
import java.util.Optional;

public interface IEventTypeService {

    public static class EventTypeNotFoundException extends Exception {}

    //GetAll
    List<EventType> findAll();

    //GetByID
    Optional<EventType> findById(int id);

    //Post
    void create(EventType EventType);

    //Delete
    void delete(int id);

    //Put
    void update(int id, EventType eventType) throws EventTypeNotFoundException;

}
