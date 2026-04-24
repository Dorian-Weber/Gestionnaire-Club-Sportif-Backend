package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IEventTypeService;
import com.mns.cda.filsrouge.dao.EventTypeDAO;
import com.mns.cda.filsrouge.dto.EventTypeField;
import com.mns.cda.filsrouge.model.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventTypeService implements IEventTypeService{

    protected final EventTypeDAO eventTypeDAO;

    //GetAll
    @Override
    public List<EventType> findAll() { return eventTypeDAO.findAll(); }

    @Override
    public List<EventTypeField> findAllEventTypeField() {
        return eventTypeDAO.findAllEventTypeField();
    }

    //GetByID
    @Override
    public Optional<EventType> findById(int id) {
        return eventTypeDAO.findById(id);
    }

    //Post
    @Override
    public void create(EventType eventType) {
        eventType.setIdEventType(null);
        eventTypeDAO.save(eventType);
    }

    //Delete
    @Override
    public void delete(int id) {
        eventTypeDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, EventType eventType) throws EventTypeNotFoundException {
        Optional<EventType> eventTypeOptional = eventTypeDAO.findById(id);

        if(eventTypeOptional.isEmpty()) {
            throw new EventTypeNotFoundException();
        }
        eventType.setIdEventType(id);
        eventTypeDAO.save(eventType);
    }

}
