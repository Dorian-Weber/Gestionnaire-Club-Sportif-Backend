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

    //Test de GetAll
    @Test
    public void getStatusPresenceAll_MustReturnList() {
        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());

        List<StatusPresence> response = statusPresenceController.getStatusPresenceList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getStatusPresenceByIdExist_MustReturnCode200() {

        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());
        ResponseEntity<StatusPresence> response = statusPresenceController.getStatusPresenceById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getStatusPresenceByIdNotExist_MustReturnCode404() {

        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());
        ResponseEntity<StatusPresence> response = statusPresenceController.getStatusPresenceById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createStatusPresence_MustReturnCode201() {
        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());
        StatusPresence statusPresence = new StatusPresence(10,
                "Test");

        ResponseEntity<StatusPresence> response = statusPresenceController.create(statusPresence);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdStatusPresence());
    }

    // Test de Delete
    @Test
    public void deleteStatusPresenceExist_MustReturnCode204() {
        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());

        ResponseEntity<StatusPresence> response = statusPresenceController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteStatusPresenceNotExist_MustReturnCode404() {
        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());

        ResponseEntity<StatusPresence> response = statusPresenceController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateStatusPresence_MustReturnCode200() {
        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());
        StatusPresence statusPresence = new StatusPresence(10,
                "Test");

        ResponseEntity<StatusPresence> response = statusPresenceController.update(1, statusPresence);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdStatusPresence());
    }

    @Test
    public void updateStatusPresenceNotExist_MustReturnCode404() {
        StatusPresenceController statusPresenceController = new StatusPresenceController(new MockStatusPresenceService());
        StatusPresence statusPresence = new StatusPresence(10, "Test");

        ResponseEntity<StatusPresence> reponse = statusPresenceController.update(2, statusPresence);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
