package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IEventService {

    public static class EventNotFoundException extends Exception {}

    //GetAll
    List<Event> findAll();

    //GetByID
    Optional<Event> findById(int id);

    //Post
    void create(Event Event);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Event event) throws EventNotFoundException;

    //Requêtes personnalisées

    //GetEventMedium
    List<EventMedium> findEventMedium();

    //GetEventMedium par eventId
    Optional<EventMedium> findEventMediumById(int idEvent);

    //GetEventLight 3 prochains dans le temps
    List<EventLight> findNextEventLight();

    //GetEventMediumByFilter
    List<EventMedium> findEventMediumByFilter(String sportName, String eventTypeName, String search, LocalDate dateMin);
}
