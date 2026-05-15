package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.EventController;
import com.mns.cda.filsrouge.mockService.MockEventService;
import com.mns.cda.filsrouge.model.*;
import com.mns.cda.filsrouge.aggregation.EventAggregationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class EventControllerUnitTest {

    //Test de GetAll
    @Test
    public void getEvenementAll_DoitRetournerUneList() {
        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());

        List<Event> response = eventController.getEventList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getEvenementByIdExist_DoitRetournerCode200() {

        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());
        ResponseEntity<Event> response = eventController.getEventById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getEvenementByIdNotExist_DoitRetournerCode404() {

        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());
        ResponseEntity<Event> response = eventController.getEventById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createEvenement_DoitRetournerCode201() {
        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());
        Event event = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 04, 15, 18, 00),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<Event> response = eventController.create(event);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdEvent());
    }

    // Test de Delete
    @Test
    public void deleteEvenementExist_DoitRetournerCode204() {
        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());

        ResponseEntity<Event> response = eventController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteEvenementNotExist_DoitRetournerCode404() {
        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());

        ResponseEntity<Event> response = eventController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update
    @Test
    public void updateEvenement_DoitRetournerCode200() {
        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());
        Event event = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 04, 15, 18, 00),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<Event> response = eventController.update(1, event);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdEvent());
    }

    @Test
    public void updateEvenementNotExist_DoitRetournerCode404() {
        EventController eventController = new EventController(new MockEventService(), new EventAggregationService());
        Event event = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                LocalDateTime.of(2026, 04, 15, 18, 00),
                new EventType(),
                new Sport(),
                List.of(new Team()),
                List.of(new Athlete()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<Event> reponse = eventController.update(2, event);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
