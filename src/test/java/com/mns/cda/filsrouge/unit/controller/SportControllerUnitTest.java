package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.SportController;
import com.mns.cda.filsrouge.mockService.MockSportService;
import com.mns.cda.filsrouge.dto.SportField;
import com.mns.cda.filsrouge.model.Sport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SportControllerUnitTest {

    // GET FIELD LIST
    @Test
    public void getSportFieldList_MustReturnList() {
        SportController controller = new SportController(new MockSportService());

        List<SportField> response = controller.getSportFieldList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.size());
    }

    // GET BY ID
    @Test
    public void getSportByIdExist_MustReturnCode200() {
        SportController controller = new SportController(new MockSportService());

        ResponseEntity<Sport> response = controller.getSportById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getSportByIdNotExist_MustReturnCode404() {
        SportController controller = new SportController(new MockSportService());

        ResponseEntity<Sport> response = controller.getSportById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createSport_MustReturnCode201() {
        SportController controller = new SportController(new MockSportService());
        Sport sport = new Sport(10, "TestSport", null, null);

        ResponseEntity<Sport> response = controller.create(sport);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdSport());
    }

    // DELETE
    @Test
    public void deleteSportExist_MustReturnCode204() {
        SportController controller = new SportController(new MockSportService());

        ResponseEntity<Sport> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteSportNotExist_MustReturnCode404() {
        SportController controller = new SportController(new MockSportService());

        ResponseEntity<Sport> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateSportExist_MustReturnCode200() {
        SportController controller = new SportController(new MockSportService());
        Sport sport = new Sport(1, "UpdatedSport", null, null);

        ResponseEntity<Sport> response = controller.update(1, sport);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdSport());
    }

    @Test
    public void updateSportNotExist_MustReturnCode404() {
        SportController controller = new SportController(new MockSportService());
        Sport sport = new Sport(1, "UpdatedSport", null, null);

        ResponseEntity<Sport> response = controller.update(999, sport);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
