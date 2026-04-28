package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{

    protected final EventDAO eventDAO;

    //GetAll
    @Override
    public List<Event> findAll() { return eventDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Event> findById(int id) {
        return eventDAO.findById(id);
    }

    //GetEventMediumById
    @Override
    public List<EventMedium> findEventMediumById() {
        return eventDAO.findEventMedium();
    }

    //GetEventLight 3 prochains dans le temps
    @Override
    public List<EventLight> findNextEventLight() {
        return eventDAO.findNextEventLight();
    }

    //Post
    @Override
    public void create(Event event) {
        event.setIdEvent(null);
        eventDAO.save(event);
    }

    //Delete
    @Override
    public void delete(int id) {
        eventDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Event event) throws EventNotFoundException {
        Optional<Event> eventOptional = eventDAO.findById(id);

        if(eventOptional.isEmpty()) {
            throw new EventNotFoundException();
        }
        event.setIdEvent(id);
        eventDAO.save(event);
    }

}
