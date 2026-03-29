package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.TypeEvenementController;
import com.mns.cda.filsrouge.mock.MockTypeEvenementDao;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Evenement;
import com.mns.cda.filsrouge.model.TypeEvenement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TypeEvenementControllerUnitTest {

    //Test de GetAll
    @Test
    public void getTypeEvenementAll_DoitRetournerUneList() {
        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());

        List<TypeEvenement> response = typeEvenementController.getTypeEvenementList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getTypeEvenementByIdExist_DoitRetournerCode200() {

        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());
        ResponseEntity<TypeEvenement> response = typeEvenementController.getTypeEvenementById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getTypeEvenementByIdNotExist_DoitRetournerCode404() {

        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());
        ResponseEntity<TypeEvenement> response = typeEvenementController.getTypeEvenementById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createTypeEvenement_DoitRetournerCode201() {
        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());
        TypeEvenement typeEvenement = new TypeEvenement(10,
                "Test",
                List.of(new Evenement()));

        ResponseEntity<TypeEvenement> response = typeEvenementController.create(typeEvenement);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdTypeEvenement());
    }

    // Test de Delete
    @Test
    public void deleteTypeEvenementExist_DoitRetournerCode204() {
        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());

        ResponseEntity<TypeEvenement> response = typeEvenementController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteTypeEvenementNotExist_DoitRetournerCode404() {
        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());

        ResponseEntity<TypeEvenement> response = typeEvenementController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Uptade

    @Test
    public void updateTypeEvenement_DoitRetournerCode200() {
        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());
        TypeEvenement typeEvenement = new TypeEvenement(10,
                "Test",
                List.of(new Evenement()));

        ResponseEntity<TypeEvenement> response = typeEvenementController.update(1, typeEvenement);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdTypeEvenement());
    }

    @Test
    public void updateTypeEvenementNotExist_DoitRetournerCode404() {
        TypeEvenementController typeEvenementController = new TypeEvenementController(new MockTypeEvenementDao());
        TypeEvenement typeEvenement = new TypeEvenement(10,
                "Test",
                List.of(new Evenement()));

        ResponseEntity<TypeEvenement> reponse = typeEvenementController.update(2, typeEvenement);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
