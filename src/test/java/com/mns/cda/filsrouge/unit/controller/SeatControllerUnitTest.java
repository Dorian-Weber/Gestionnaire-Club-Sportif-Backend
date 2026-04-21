package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.SeatController;
import com.mns.cda.filsrouge.mockDAO.MockSeatDao;
import com.mns.cda.filsrouge.mockService.MockSeatService;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.Seat;
import com.mns.cda.filsrouge.model.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SeatControllerUnitTest {

    //Test de GetAll
    @Test
    public void getSeatAll_MustReturnList() {
        SeatController seatController = new SeatController(new MockSeatService());

        List<Seat> response = seatController.getSeatList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getSeatByIdExist_MustReturnCode200() {

        SeatController seatController = new SeatController(new MockSeatService());
        ResponseEntity<Seat> response = seatController.getSeatById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getSeatByIdNotExist_MustReturnCode404() {

        SeatController seatController = new SeatController(new MockSeatService());
        ResponseEntity<Seat> response = seatController.getSeatById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createSeat_MustReturnCode201() {
        SeatController seatController = new SeatController(new MockSeatService());
        Seat seat = new Seat(10,
                "Test",
                new Level(),
                new Reservation());

        ResponseEntity<Seat> response = seatController.create(seat);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdSeat());
    }

    // Test de Delete
    @Test
    public void deleteSeatExist_MustReturnCode204() {
        SeatController seatController = new SeatController(new MockSeatService());

        ResponseEntity<Seat> response = seatController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteSeatNotExist_MustReturnCode404() {
        SeatController seatController = new SeatController(new MockSeatService());

        ResponseEntity<Seat> response = seatController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateSeat_MustReturnCode200() {
        SeatController seatController = new SeatController(new MockSeatService());
        Seat seat = new Seat(10,
                "Test",
                new Level(),
                new Reservation());

        ResponseEntity<Seat> response = seatController.update(1, seat);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdSeat());
    }

    @Test
    public void updateSeatNotExist_MustReturnCode404() {
        SeatController seatController = new SeatController(new MockSeatService());
        Seat seat = new Seat(10,
                "Test",
                new Level(),
                new Reservation());

        ResponseEntity<Seat> reponse = seatController.update(2, seat);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
