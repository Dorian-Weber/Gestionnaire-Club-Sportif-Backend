package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.EvenementController;
import com.mns.cda.filsrouge.mock.MockEvenementDao;
import com.mns.cda.filsrouge.model.Evenement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class EvenementControllerUnitTest {

    //Test de GetAll
    @Test
    public void getEvenementAll_DoitRetournerUneList() {
        EvenementController evenementController = new EvenementController(new MockEvenementDao());

        List<Evenement> response = evenementController.getEvenementList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getEvenementByIdExist_DoitRetournerCode200() {

        EvenementController evenementController = new EvenementController(new MockEvenementDao());
        ResponseEntity<Evenement> response = evenementController.getEvenementById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getEvenementByIdNotExist_DoitRetournerCode404() {

        EvenementController evenementController = new EvenementController(new MockEvenementDao());
        ResponseEntity<Evenement> response = evenementController.getEvenementById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createEvenement_DoitRetournerCode201() {
        EvenementController evenementController = new EvenementController(new MockEvenementDao());
        Evenement evenement = new Evenement(10, "Test","Test", LocalDateTime.of(2026,04,26,20,00));

        ResponseEntity<Evenement> response = evenementController.create(evenement);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdEvenement());
    }

    // Test de Delete
    @Test
    public void deleteEvenementExist_DoitRetournerCode204() {
        EvenementController evenementController = new EvenementController(new MockEvenementDao());

        ResponseEntity<Evenement> response = evenementController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteEvenementNotExist_DoitRetournerCode404() {
        EvenementController evenementController = new EvenementController(new MockEvenementDao());

        ResponseEntity<Evenement> response = evenementController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Uptade

    @Test
    public void updateEvenement_DoitRetournerCode200() {
        EvenementController evenementController = new EvenementController(new MockEvenementDao());
        Evenement evenement = new Evenement(10, "Test","Test", LocalDateTime.of(2026,04,26,20,00));

        ResponseEntity<Evenement> response = evenementController.update(1, evenement);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdEvenement());
    }

    @Test
    public void updateEvenementNotExist_DoitRetournerCode404() {
        EvenementController evenementController = new EvenementController(new MockEvenementDao());
        Evenement evenement = new Evenement(10, "Test","Test", LocalDateTime.of(2026,04,26,20,00));

        ResponseEntity<Evenement> reponse = evenementController.update(2, evenement);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
