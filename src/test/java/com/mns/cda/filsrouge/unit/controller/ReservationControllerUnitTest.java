package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.ReservationController;
import com.mns.cda.filsrouge.mockService.MockReservationService;
import com.mns.cda.filsrouge.mockService.MockUserDetails;
import com.mns.cda.filsrouge.dto.CanReserveDTO;
import com.mns.cda.filsrouge.dto.CreateReservation;
import com.mns.cda.filsrouge.dto.ReservationConfirmation;
import com.mns.cda.filsrouge.model.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ReservationControllerUnitTest {

    // GET ALL
    @Test
    public void getReservationList_MustReturnList() {
        ReservationController controller = new ReservationController(new MockReservationService());

        List<Reservation> response = controller.getReservationList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    // GET BY ID
    @Test
    public void getReservationByIdExist_MustReturnCode200() {
        ReservationController controller = new ReservationController(new MockReservationService());

        ResponseEntity<Reservation> response = controller.getReservationById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getReservationByIdNotExist_MustReturnCode404() {
        ReservationController controller = new ReservationController(new MockReservationService());

        ResponseEntity<Reservation> response = controller.getReservationById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CAN RESERVE
    @Test
    public void canReserve_MustReturnDTO() {
        ReservationController controller = new ReservationController(new MockReservationService());
        MockUserDetails user = new MockUserDetails(10, "USER");

        CanReserveDTO response = controller.canReserve(100, user);

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.alreadyReserved());
        Assertions.assertFalse(response.isFull());
        Assertions.assertFalse(response.isPast());

    }

    // CREATE
    @Test
    public void createReservation_MustReturnCode201() {
        ReservationController controller = new ReservationController(new MockReservationService());
        MockUserDetails user = new MockUserDetails(10, "USER");

        CreateReservation dto = new CreateReservation(100, List.of(1, 2));

        ResponseEntity<ReservationConfirmation> response = controller.createReservation(dto, user);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(99, response.getBody().reservationId());
    }

    // DELETE (USER owns reservation)
    @Test
    public void deleteReservation_UserOwner_MustReturnCode204() {
        ReservationController controller = new ReservationController(new MockReservationService());
        MockUserDetails user = new MockUserDetails(10, "ADMIN");

        ResponseEntity<Reservation> response = controller.delete(user, 1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    // DELETE (USER not owner)
    @Test
    public void deleteReservation_UserNotOwner_MustReturnCode403() {
        ReservationController controller = new ReservationController(new MockReservationService());
        MockUserDetails user = new MockUserDetails(99, "USER");

        ResponseEntity<Reservation> response = controller.delete(user, 1);

        Assertions.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    // DELETE (ADMIN can delete anything)
    @Test
    public void deleteReservation_Admin_MustReturnCode204() {
        ReservationController controller = new ReservationController(new MockReservationService());
        MockUserDetails admin = new MockUserDetails(50, "ADMIN");

        ResponseEntity<Reservation> response = controller.delete(admin, 1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    // DELETE (not exist)
    @Test
    public void deleteReservationNotExist_MustReturnCode404() {
        ReservationController controller = new ReservationController(new MockReservationService());
        MockUserDetails user = new MockUserDetails(10, "USER");

        ResponseEntity<Reservation> response = controller.delete(user, 999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateReservationExist_MustReturnCode200() {
        ReservationController controller = new ReservationController(new MockReservationService());
        Reservation reservation = new Reservation();
        reservation.setIdReservation(1);

        ResponseEntity<Reservation> response = controller.update(1, reservation);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateReservationNotExist_MustReturnCode404() {
        ReservationController controller = new ReservationController(new MockReservationService());
        Reservation reservation = new Reservation();

        ResponseEntity<Reservation> response = controller.update(999, reservation);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
