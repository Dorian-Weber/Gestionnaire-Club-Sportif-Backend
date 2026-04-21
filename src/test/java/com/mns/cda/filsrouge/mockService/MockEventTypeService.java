package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IEventTypeService;
import com.mns.cda.filsrouge.model.*;

import java.util.List;
import java.util.Optional;

public class MockEventTypeService implements IEventTypeService {
    @Override
    public List<EventType> findAll() {
        return List.of(new EventType(1,
                "Tournois",
                List.of(new Event())));
    }

    @Override
    public Optional<EventType> findById(int id) {
        if (id == 1) {
            return Optional.of(new EventType(1,
                    "Tournois",
                    List.of(new Event())));
        }
        return Optional.empty();
    }

    @Override
    public void create(EventType EventType) {
        EventType.setIdEventType(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, EventType EventType) throws EventTypeNotFoundException {
        if (id != 1) {
            throw new EventTypeNotFoundException();
        }
        EventType.setIdEventType(id);

    }
}
