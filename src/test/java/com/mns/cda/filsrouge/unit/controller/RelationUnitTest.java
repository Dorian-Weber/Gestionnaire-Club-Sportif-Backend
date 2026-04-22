package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.RelationController;
import com.mns.cda.filsrouge.mockService.MockRelationService;
import com.mns.cda.filsrouge.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class RelationUnitTest {

    //Test de GetAll
    @Test
    public void getRelationAll_MustReturnList() {
        RelationController relationController = new RelationController(new MockRelationService());

        List<Relation> response = relationController.getRelationList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getRelationByIdExist_MustReturnCode200() {

        RelationController relationController = new RelationController(new MockRelationService());
        ResponseEntity<Relation> response = relationController.getRelationById(1,2);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getRelationByIdNotExist_MustReturnCode404() {

        RelationController relationController = new RelationController(new MockRelationService());
        ResponseEntity<Relation> response = relationController.getRelationById(2,1);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createRelation_MustReturnCode201() {
        RelationController relationController = new RelationController(new MockRelationService());
        Relation relation = new Relation(new Relation.Key(1,2),
                new AppUser(),
                new AppUser(),
                "En attente");

        ResponseEntity<Relation> response = relationController.create(relation);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getKey());
    }

    // Test de Delete
    @Test
    public void deleteRelationExist_MustReturnCode204() {
        RelationController relationController = new RelationController(new MockRelationService());

        ResponseEntity<Relation> response = relationController.delete(1,2);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteRelationNotExist_MustReturnCode404() {
        RelationController relationController = new RelationController(new MockRelationService());

        ResponseEntity<Relation> response = relationController.delete(2,1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateRelation_MustReturnCode200() {
        RelationController relationController = new RelationController(new MockRelationService());
        Relation relation = new Relation(new Relation.Key(1,2),
                new AppUser(),
                new AppUser(),
                "En attente");

        ResponseEntity<Relation> response = relationController.update(1,2, relation);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(new Relation.Key(1,2), response.getBody().getKey());
    }

    @Test
    public void updateRelationNotExist_MustReturnCode404() {
        RelationController relationController = new RelationController(new MockRelationService());
        Relation relation = new Relation(new Relation.Key(1,2),
                new AppUser(),
                new AppUser(),
                "En attente");

        ResponseEntity<Relation> reponse = relationController.update(2,1, relation);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
