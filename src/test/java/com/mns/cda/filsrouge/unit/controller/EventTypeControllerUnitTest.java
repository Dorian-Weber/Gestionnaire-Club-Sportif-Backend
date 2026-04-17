package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.EventTypeController;
import com.mns.cda.filsrouge.mockDAO.MockEventTypeDao;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.EventType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EventTypeControllerUnitTest {

    //Test de GetAll
    @Test
    public void getEventTypeAll_MustReturnList() {
        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());

        List<EventType> response = eventTypeController.getEventTypeList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getEventTypeByIdExist_MustReturnCode200() {

        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());
        ResponseEntity<EventType> response = eventTypeController.getEventTypeById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getEventTypeByIdNotExist_MustReturnCode404() {

        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());
        ResponseEntity<EventType> response = eventTypeController.getEventTypeById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createEventType_MustReturnCode201() {
        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());
        EventType eventType = new EventType(10,
                "Test",
                List.of(new Event()));

        ResponseEntity<EventType> response = eventTypeController.create(eventType);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdEventType());
    }

    // Test de Delete
    @Test
    public void deleteEventTypeExist_MustReturnCode204() {
        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());

        ResponseEntity<EventType> response = eventTypeController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteEventTypeNotExist_MustReturnCode404() {
        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());

        ResponseEntity<EventType> response = eventTypeController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateEventType_MustReturnCode200() {
        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());
        EventType eventType = new EventType(10,
                "Test",
                List.of(new Event()));

        ResponseEntity<EventType> response = eventTypeController.update(1, eventType);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdEventType());
    }

    @Test
    public void updateEventTypeNotExist_MustReturnCode404() {
        EventTypeController eventTypeController = new EventTypeController(new MockEventTypeDao());
        EventType eventType = new EventType(10, "Test",
                List.of(new Event()));

        ResponseEntity<EventType> reponse = eventTypeController.update(2, eventType);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
