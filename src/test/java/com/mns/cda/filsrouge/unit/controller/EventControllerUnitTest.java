package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.EventController;
import com.mns.cda.filsrouge.mock.MockEventDao;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Sport;
import com.mns.cda.filsrouge.model.EventType;
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
        EventController eventController = new EventController(new MockEventDao());

        List<Event> response = eventController.getEventList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getEvenementByIdExist_DoitRetournerCode200() {

        EventController eventController = new EventController(new MockEventDao());
        ResponseEntity<Event> response = eventController.getEventById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getEvenementByIdNotExist_DoitRetournerCode404() {

        EventController eventController = new EventController(new MockEventDao());
        ResponseEntity<Event> response = eventController.getEventById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createEvenement_DoitRetournerCode201() {
        EventController eventController = new EventController(new MockEventDao());
        Event event = new Event(10,
                "Test",
                "Test",
                LocalDateTime.of(2026,04,26,20,00),
                new EventType(),
                new Sport(),
                List.of(new Athlete()));

        ResponseEntity<Event> response = eventController.create(event);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdEvent());
    }

    // Test de Delete
    @Test
    public void deleteEvenementExist_DoitRetournerCode204() {
        EventController eventController = new EventController(new MockEventDao());

        ResponseEntity<Event> response = eventController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteEvenementNotExist_DoitRetournerCode404() {
        EventController eventController = new EventController(new MockEventDao());

        ResponseEntity<Event> response = eventController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update
    @Test
    public void updateEvenement_DoitRetournerCode200() {
        EventController eventController = new EventController(new MockEventDao());
        Event event = new Event(10,
                "Test",
                "Test",
                LocalDateTime.of(2026,04,26,20,00),
                new EventType(),
                new Sport(),
                List.of(new Athlete()));

        ResponseEntity<Event> response = eventController.update(1, event);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdEvent());
    }

    @Test
    public void updateEvenementNotExist_DoitRetournerCode404() {
        EventController eventController = new EventController(new MockEventDao());
        Event event = new Event(10,
                "Test",
                "Test",
                LocalDateTime.of(2026,04,26,20,00),
                new EventType(),
                new Sport(),
                List.of(new Athlete()));

        ResponseEntity<Event> reponse = eventController.update(2, event);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
