package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.DisciplineController;
import com.mns.cda.filsrouge.mockService.MockDisciplineService;
import com.mns.cda.filsrouge.model.Discipline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DisciplineControllerUnitTest {

    // GET ALL
    @Test
    public void getDisciplineList_MustReturnList() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());

        List<Discipline> response = controller.getDisciplineList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getDisciplineByIdExist_MustReturnCode200() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());

        ResponseEntity<Discipline> response = controller.getDisciplineById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getDisciplineByIdNotExist_MustReturnCode404() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());

        ResponseEntity<Discipline> response = controller.getDisciplineById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createDiscipline_MustReturnCode201() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());
        Discipline discipline = new Discipline(10, "Test Discipline", null, null, null, null);

        ResponseEntity<Discipline> response = controller.create(discipline);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdDiscipline());
    }

    // DELETE
    @Test
    public void deleteDisciplineExist_MustReturnCode204() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());

        ResponseEntity<Discipline> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteDisciplineNotExist_MustReturnCode404() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());

        ResponseEntity<Discipline> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateDisciplineExist_MustReturnCode200() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());
        Discipline discipline = new Discipline(1, "Updated Discipline", null, null, null, null);

        ResponseEntity<Discipline> response = controller.update(1, discipline);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdDiscipline());
    }

    @Test
    public void updateDisciplineNotExist_MustReturnCode404() {
        DisciplineController controller = new DisciplineController(new MockDisciplineService());
        Discipline discipline = new Discipline(1, "Updated Discipline", null, null, null, null);

        ResponseEntity<Discipline> response = controller.update(999, discipline);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
