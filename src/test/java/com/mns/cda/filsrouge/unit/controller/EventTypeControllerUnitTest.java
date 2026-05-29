package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.EventTypeController;
import com.mns.cda.filsrouge.mockService.MockEventTypeService;
import com.mns.cda.filsrouge.dto.EventTypeField;
import com.mns.cda.filsrouge.model.EventType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EventTypeControllerUnitTest {

    // GET FIELD LIST
    @Test
    public void findAllEventTypeField_MustReturnList() {
        EventTypeController controller = new EventTypeController(new MockEventTypeService());

        List<EventTypeField> response = controller.findAllEventTypeField();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.size());
    }

    // CREATE
    @Test
    public void createEventType_MustReturnCode201() {
        EventTypeController controller = new EventTypeController(new MockEventTypeService());
        EventType eventType = new EventType(10, "TestType", null);

        ResponseEntity<EventType> response = controller.create(eventType);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdEventType());
    }

    // DELETE
    @Test
    public void deleteEventTypeExist_MustReturnCode204() {
        EventTypeController controller = new EventTypeController(new MockEventTypeService());

        ResponseEntity<EventType> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteEventTypeNotExist_MustReturnCode404() {
        EventTypeController controller = new EventTypeController(new MockEventTypeService());

        ResponseEntity<EventType> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateEventTypeExist_MustReturnCode200() {
        EventTypeController controller = new EventTypeController(new MockEventTypeService());
        EventType eventType = new EventType(1, "UpdatedType", null);

        ResponseEntity<EventType> response = controller.update(1, eventType);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdEventType());
    }

    @Test
    public void updateEventTypeNotExist_MustReturnCode404() {
        EventTypeController controller = new EventTypeController(new MockEventTypeService());
        EventType eventType = new EventType(1, "UpdatedType", null);

        ResponseEntity<EventType> response = controller.update(999, eventType);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
