package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;

import java.util.EventListenerProxy;
import java.util.List;
import java.util.Optional;

public interface IEventService {

    public static class EventNotFoundException extends Exception {}

    //GetAll
    List<Event> findAll();

    //GetByID
    Optional<Event> findById(int id);

    //GetEventMediumById
    List<EventMedium> findEventMediumById();


    //GetEventLight 3 prochains dans le temps
    List<EventLight> findNextEventLight();

    //Post
    void create(Event Event);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Event event) throws EventNotFoundException;

}
