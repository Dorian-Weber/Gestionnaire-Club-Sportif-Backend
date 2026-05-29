package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.EventController;
import com.mns.cda.filsrouge.mockService.MockEventService;
import com.mns.cda.filsrouge.mockAggregation.MockEventAggregationService;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.dto.EventFull;
import com.mns.cda.filsrouge.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EventControllerUnitTest {

    // NEXT EVENTS
    @Test
    public void getEventLight_MustReturnList() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        List<EventLight> response = controller.getEventLight();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    // LIGHT BY ID
    @Test
    public void getEventLightByIdExist_MustReturnCode200() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        ResponseEntity<EventLight> response = controller.getEventLightById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getEventLightByIdNotExist_MustReturnCode404() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        ResponseEntity<EventLight> response = controller.getEventLightById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // MEDIUM LIST
    @Test
    public void getEventMedium_MustReturnList() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        List<EventMedium> response = controller.getEventMedium();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    // MEDIUM BY ID
    @Test
    public void getEventMediumByIdExist_MustReturnCode200() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        ResponseEntity<EventMedium> response = controller.getEventMediumById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getEventMediumByIdNotExist_MustReturnCode404() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        ResponseEntity<EventMedium> response = controller.getEventMediumById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // FILTER
    @Test
    public void getEventMediumByFilter_MustReturnList() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        List<EventMedium> response = controller.getEventMediumByFilter(null, null, null, LocalDate.now());

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    @Test
    public void getEventMediumByFilter_InvalidDate_MustThrowException() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                controller.getEventMediumByFilter(null, null, null, LocalDate.now().minusDays(1))
        );
    }

    // FULL EVENT
    @Test
    public void getEventFull_MustReturnObject() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        EventFull response = controller.getEventFull(1);

        Assertions.assertNotNull(response);
    }

    // CREATE
    @Test
    public void createEvent_MustReturnCode201() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());
        Event event = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 4, 15, 18, 0),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<Event> response = controller.create(event);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdEvent());
    }

    // DELETE
    @Test
    public void deleteEventExist_MustReturnCode204() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        ResponseEntity<Event> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteEventNotExist_MustReturnCode404() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());

        ResponseEntity<Event> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateEventExist_MustReturnCode200() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());
        Event event = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 4, 15, 18, 0),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<Event> response = controller.update(1, event);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdEvent());
    }

    @Test
    public void updateEventNotExist_MustReturnCode404() {
        EventController controller = new EventController(new MockEventService(), new MockEventAggregationService());
        Event event = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 4, 15, 18, 0),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<Event> response = controller.update(999, event);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
