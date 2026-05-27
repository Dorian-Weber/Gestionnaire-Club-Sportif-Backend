package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Reservation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReservationUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // statusPresence : @NotNull

    @Test
    public void statusPresenceNull_MustBeNotValidated() {

        Reservation reservation = new Reservation();
        reservation.setStatusPresence(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(reservation),
                "statusPresence",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    // event : @NotNull

    @Test
    public void eventNull_MustBeNotValidated() {

        Reservation reservation = new Reservation();
        reservation.setEvent(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(reservation),
                "event",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    // user : @NotNull

    @Test
    public void userNull_MustBeNotValidated() {

        Reservation reservation = new Reservation();
        reservation.setUser(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(reservation),
                "user",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }
}
