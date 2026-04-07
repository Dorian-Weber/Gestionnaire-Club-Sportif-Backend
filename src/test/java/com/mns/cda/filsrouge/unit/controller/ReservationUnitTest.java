package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.ReservationController;
import com.mns.cda.filsrouge.mock.MockReservationDao;
import com.mns.cda.filsrouge.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationUnitTest {

    //Test de GetAll
    @Test
    public void getReservationAll_MustReturnList() {
        ReservationController reservationController = new ReservationController(new MockReservationDao());

        List<Reservation> response = reservationController.getReservationList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getReservationByIdExist_MustReturnCode200() {

        ReservationController reservationController = new ReservationController(new MockReservationDao());
        ResponseEntity<Reservation> response = reservationController.getReservationById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getReservationByIdNotExist_MustReturnCode404() {

        ReservationController reservationController = new ReservationController(new MockReservationDao());
        ResponseEntity<Reservation> response = reservationController.getReservationById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createReservation_MustReturnCode201() {
        ReservationController reservationController = new ReservationController(new MockReservationDao());
        Reservation reservation = new Reservation(1,
                LocalDateTime.now(),
                new StatusPresence(),
                new Event(),
                new AppUser(),
                List.of(new Seat()));

        ResponseEntity<Reservation> response = reservationController.create(reservation);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdReservation());
    }

    // Test de Delete
    @Test
    public void deleteReservationExist_MustReturnCode204() {
        ReservationController reservationController = new ReservationController(new MockReservationDao());

        ResponseEntity<Reservation> response = reservationController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteReservationNotExist_MustReturnCode404() {
        ReservationController reservationController = new ReservationController(new MockReservationDao());

        ResponseEntity<Reservation> response = reservationController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateReservation_MustReturnCode200() {
        ReservationController reservationController = new ReservationController(new MockReservationDao());
        Reservation reservation = new Reservation(1,
                LocalDateTime.now(),
                new StatusPresence(),
                new Event(),
                new AppUser(),
                List.of(new Seat()));

        ResponseEntity<Reservation> response = reservationController.update(1, reservation);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdReservation());
    }

    @Test
    public void updateReservationNotExist_MustReturnCode404() {
        ReservationController reservationController = new ReservationController(new MockReservationDao());
        Reservation reservation = new Reservation(1,
                LocalDateTime.now(),
                new StatusPresence(),
                new Event(),
                new AppUser(),
                List.of(new Seat()));

        ResponseEntity<Reservation> reponse = reservationController.update(2, reservation);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
