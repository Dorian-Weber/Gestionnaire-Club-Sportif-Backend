package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.DisciplineController;
import com.mns.cda.filsrouge.mockDAO.MockDisciplineDao;
import com.mns.cda.filsrouge.mockService.MockDisciplineService;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Sport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DisciplineControllerUnitTest {

    //Test de GetAll
    @Test
    public void getDisciplineListAll_MustReturnList() {
        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());

        List<Discipline> response = disciplineController.getDisciplineList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getDisciplineByIdExist_MustReturnCode200() {

        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());
        ResponseEntity<Discipline> response = disciplineController.getDisciplineById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getDisciplineByIdNotExist_MustReturnCode404() {

        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());
        ResponseEntity<Discipline> response = disciplineController.getDisciplineById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createDiscipline_MustReturnCode201() {
        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());
        Discipline discipline = new Discipline(10,
                "Test",
                "Test",
                "Test",
                new Sport(),
                List.of(new Athlete()));

        ResponseEntity<Discipline> response = disciplineController.create(discipline);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdDiscipline());
    }

    // Test de Delete
    @Test
    public void deleteDisciplineExist_MustReturnCode204() {
        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());

        ResponseEntity<Discipline> response = disciplineController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteDisciplineNotExist_MustReturnCode404() {
        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());

        ResponseEntity<Discipline> response = disciplineController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateDiscipline_MustReturnCode200() {
        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());
        Discipline discipline = new Discipline(10,
                "Test",
                "Test",
                "Test",
                new Sport(),
                List.of(new Athlete()));

        ResponseEntity<Discipline> response = disciplineController.update(1, discipline);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdDiscipline());
    }

    @Test
    public void updateDisciplineNotExist_MustReturnCode404() {
        DisciplineController disciplineController = new DisciplineController(new MockDisciplineService());
        Discipline discipline = new Discipline(10,
                "Test",
                "Test",
                "Test",
                new Sport(),
                List.of(new Athlete()));

        ResponseEntity<Discipline> reponse = disciplineController.update(2, discipline);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
