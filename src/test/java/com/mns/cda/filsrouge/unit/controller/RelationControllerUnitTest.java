package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.RelationController;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.mockService.MockRelationService;
import com.mns.cda.filsrouge.model.Relation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RelationControllerUnitTest {

    // GET ALL
    @Test
    public void getRelationList_MustReturnList() {
        RelationController controller = new RelationController(new MockRelationService());

        List<Relation> response = controller.getRelationList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getRelationByIdExist_MustReturnCode200() {
        RelationController controller = new RelationController(new MockRelationService());

        ResponseEntity<Relation> response = controller.getRelationById(1, 2);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getRelationByIdNotExist_MustReturnCode404() {
        RelationController controller = new RelationController(new MockRelationService());

        ResponseEntity<Relation> response = controller.getRelationById(9, 9);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createRelation_MustReturnCode201() {
        RelationController controller = new RelationController(new MockRelationService());
        Relation relation = new Relation(new Relation.Key(5, 6), null, null, RelationStatus.PENDING);

        ResponseEntity<Relation> response = controller.create(relation);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getKey());
    }

    // DELETE
    @Test
    public void deleteRelationExist_MustReturnCode204() {
        RelationController controller = new RelationController(new MockRelationService());

        ResponseEntity<Relation> response = controller.delete(1, 2);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteRelationNotExist_MustReturnCode404() {
        RelationController controller = new RelationController(new MockRelationService());

        ResponseEntity<Relation> response = controller.delete(9, 9);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateRelationExist_MustReturnCode200() {
        RelationController controller = new RelationController(new MockRelationService());
        Relation relation = new Relation(new Relation.Key(1, 2), null, null, RelationStatus.PENDING);

        ResponseEntity<Relation> response = controller.update(1, 2, relation);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(new Relation.Key(1,2), response.getBody().getKey());
    }

    @Test
    public void updateRelationNotExist_MustReturnCode404() {
        RelationController controller = new RelationController(new MockRelationService());
        Relation relation = new Relation(new Relation.Key(9, 9), null, null, RelationStatus.PENDING);

        ResponseEntity<Relation> response = controller.update(9, 9, relation);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
