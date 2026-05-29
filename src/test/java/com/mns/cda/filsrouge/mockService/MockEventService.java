package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.aggregation.EventAggregationService;
import com.mns.cda.filsrouge.dto.EventFull;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MockEventService implements IEventService {

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
    public List<EventMedium> findEventMedium() {
        return List.of(new EventMedium(1, "Event 1", null, null, null, null, 10, 100));
    }


    @Override
    public Optional<EventMedium> findEventMediumById(int id) {
        if (id == 1) {
            return Optional.of(new EventMedium(1, "Event 1", null, null, null, null, 10, 100));
        }
        return Optional.empty();
    }

    @Override
    public List<EventLight> findNextEventLight() {
        return List.of(new EventLight(1, "Event 1", LocalDateTime.now(), "Sport"),
                new EventLight(2, "Event 2", LocalDateTime.now(), "Sport"),
                new EventLight(3, "Event 3", LocalDateTime.now(), "Sport"));
    }

    @Override
    public Optional<EventLight> findEventLightById(int id) {
        if (id == 1) {
            return Optional.of(new EventLight(1, "Event 1", LocalDateTime.now(), "Sport"));
        }
        return Optional.empty();
    }

    @Override
    public List<EventMedium> findEventMediumByFilter(String sport, String type, String search, LocalDate dateMin) {
        return List.of(new EventMedium(1, "Filtered Event", null, null, null, null, 5, 50));
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
