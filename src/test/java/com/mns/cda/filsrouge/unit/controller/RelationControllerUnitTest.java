package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.RelationController;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.mockService.MockRelationService;
import com.mns.cda.filsrouge.mockService.MockUserDetails;
import com.mns.cda.filsrouge.model.Relation;
import com.mns.cda.filsrouge.dto.UpdateRelationStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationControllerUnitTest {

    // DELETE
    @Test
    public void deleteRelationExist_MustReturnCode204() {
        RelationController controller = new RelationController(new MockRelationService());
        MockUserDetails user = new MockUserDetails(1, "USER");

        ResponseEntity<Relation> response = controller.delete(user, 2);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteRelationNotExist_MustReturnCode404() {
        RelationController controller = new RelationController(new MockRelationService());
        MockUserDetails user = new MockUserDetails(9, "USER");

        ResponseEntity<Relation> response = controller.delete(user, 9);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // SEND REQUEST
    @Test
    public void sendRequestRelation_MustReturnCode201() {
        RelationController controller = new RelationController(new MockRelationService());
        MockUserDetails user = new MockUserDetails(1, "USER");
        Map<String, Integer> body = new HashMap<>();
        body.put("secondId", 2);

        ResponseEntity<?> response = controller.sendRequest(user, body);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    // UPDATE RELATION STATUS
    @Test
    public void updateRelationStatus_MustComplete() throws Exception {
        RelationController controller = new RelationController(new MockRelationService());
        MockUserDetails user = new MockUserDetails(1, "USER");
        UpdateRelationStatus status = new UpdateRelationStatus(RelationStatus.ACCEPTED);

        controller.updateRelationStatus(user, 2, status);
        // If no exception thrown, test passes
        Assertions.assertNotNull(user);
    }
}
