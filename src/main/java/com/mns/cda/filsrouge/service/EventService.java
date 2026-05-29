package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{

    protected final EventDAO eventDAO;

    //GetByID
    @Override
    public Optional<Event> findById(int id) {
        return eventDAO.findById(id);
    }

    //GetEventMediumById
    @Override
    public List<EventMedium> findEventMedium() {
        return eventDAO.findEventMedium();
    }

    @Override
    public Optional<EventMedium> findEventMediumById(int idEvent) {
        if (eventDAO.findById(idEvent).isEmpty()) {
            return Optional.empty();
        }
        EventMedium dto = eventDAO.findEventMediumByEventId(idEvent);
        return Optional.ofNullable(dto);
    }

    //GetEventLight 3 prochains dans le temps
    @Override
    public List<EventLight> findNextEventLight() {
        return eventDAO.findNextEventLight();
    }

    //GetEventLight by id
    @Override
    public Optional<EventLight> findEventLightById(int idEvent) {
        if (eventDAO.findById(idEvent).isEmpty()) {
            return Optional.empty();
        }
        EventLight dto = eventDAO.findEventLightByEventId(idEvent);
        return Optional.ofNullable(dto);
    }

    //GetEventMediumByFilter
    @Override
    public List<EventMedium> findEventMediumByFilter(String sportName, String eventTypeName, String search, LocalDate dateMin) {
        LocalDateTime dateMinLdt;
        if (dateMin != null) {
            dateMinLdt = dateMin.atStartOfDay();
        } else {
            dateMinLdt = LocalDate.now().atStartOfDay();
        }
        return eventDAO.findEventMediumByFilter(sportName, eventTypeName, search, dateMinLdt);
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
