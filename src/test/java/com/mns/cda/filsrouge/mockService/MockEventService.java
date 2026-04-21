package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MockEventService implements IEventService {
    @Override
    public List<Event> findAll() {
        return List.of(new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 4, 15, 18, 0),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation())
        ));
    }

    @Override
    public Optional<Event> findById(int id) {
        if (id == 1) {
            return Optional.of(new Event(1,
                    "Match de Football",
                    "Rencontre amicale entre deux équipes locales",
                    LocalDateTime.of(2026, 4, 15, 18, 0),
                    new EventType(),
                    new Sport(),
                    List.of(new Team()),
                    List.of(new Athlete()),
                    List.of(new Vote()),
                    List.of(new Reservation())
            ));
        }
        return Optional.empty();
    }

    @Override
    public void create(Event Event) {
        Event.setIdEvent(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Event Event) throws EventNotFoundException {
        if (id != 1) {
            throw new EventNotFoundException();
        }
        Event.setIdEvent(id);

    }
}
