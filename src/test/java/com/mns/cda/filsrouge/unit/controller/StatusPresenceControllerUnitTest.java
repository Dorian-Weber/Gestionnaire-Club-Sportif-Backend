package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.StatusPresenceController;
import com.mns.cda.filsrouge.mockService.MockStatusPresenceService;
import com.mns.cda.filsrouge.model.StatusPresence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class StatusPresenceControllerUnitTest {

    // GET ALL
    @Test
    public void getStatusPresenceList_MustReturnList() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());

        List<StatusPresence> response = controller.getStatusPresenceList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getStatusPresenceByIdExist_MustReturnCode200() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());

        ResponseEntity<StatusPresence> response = controller.getStatusPresenceById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getStatusPresenceByIdNotExist_MustReturnCode404() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());

        ResponseEntity<StatusPresence> response = controller.getStatusPresenceById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createStatusPresence_MustReturnCode201() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());
        StatusPresence sp = new StatusPresence(10, "Test");

        ResponseEntity<StatusPresence> response = controller.create(sp);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdStatusPresence());
    }

    // DELETE
    @Test
    public void deleteStatusPresenceExist_MustReturnCode204() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());

        ResponseEntity<StatusPresence> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteStatusPresenceNotExist_MustReturnCode404() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());

        ResponseEntity<StatusPresence> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateStatusPresenceExist_MustReturnCode200() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());
        StatusPresence sp = new StatusPresence(1, "Updated");

        ResponseEntity<StatusPresence> response = controller.update(1, sp);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdStatusPresence());
    }

    @Test
    public void updateStatusPresenceNotExist_MustReturnCode404() {
        StatusPresenceController controller = new StatusPresenceController(new MockStatusPresenceService());
        StatusPresence sp = new StatusPresence(1, "Updated");

        ResponseEntity<StatusPresence> response = controller.update(999, sp);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
