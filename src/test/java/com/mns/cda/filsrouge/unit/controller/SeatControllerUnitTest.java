package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.SeatController;
import com.mns.cda.filsrouge.mockService.MockSeatService;
import com.mns.cda.filsrouge.mockAggregation.MockSeatAggregationService;
import com.mns.cda.filsrouge.mockService.MockUserDetails;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.Seat;
import com.mns.cda.filsrouge.dto.SeatDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SeatControllerUnitTest {

    // GET ALL
    @Test
    public void getSeatList_MustReturnList() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());

        List<Seat> response = controller.getSeatList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getSeatByIdExist_MustReturnCode200() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());

        ResponseEntity<Seat> response = controller.getSeatById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getSeatByIdNotExist_MustReturnCode404() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());

        ResponseEntity<Seat> response = controller.getSeatById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // GET RESERVED SEATS
    @Test
    public void getReservedSeats_MustReturnList() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());
        MockUserDetails user = new MockUserDetails(10, "USER");

        List<SeatDTO> response = controller.getReservedSeatsByEventId(100, user, "Nord", "Haut");

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.size());
    }

    // CREATE
    @Test
    public void createSeat_MustReturnCode201() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());
        Seat seat = new Seat(1,
                "Test",
                new Level(),List.of(
                new Reservation()));

        ResponseEntity<Seat> response = controller.create(seat);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdSeat());
    }

    // DELETE
    @Test
    public void deleteSeatExist_MustReturnCode204() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());

        ResponseEntity<Seat> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteSeatNotExist_MustReturnCode404() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());

        ResponseEntity<Seat> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateSeatExist_MustReturnCode200() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());
        Seat seat =new Seat(1,
                "Test",
                new Level(),List.of(
                new Reservation()));

        ResponseEntity<Seat> response = controller.update(1, seat);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdSeat());
    }

    @Test
    public void updateSeatNotExist_MustReturnCode404() {
        SeatController controller = new SeatController(new MockSeatService(), new MockSeatAggregationService());
        Seat seat = new Seat(1,
                "Test",
                new Level(),List.of(
                new Reservation()));

        ResponseEntity<Seat> response = controller.update(999, seat);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
