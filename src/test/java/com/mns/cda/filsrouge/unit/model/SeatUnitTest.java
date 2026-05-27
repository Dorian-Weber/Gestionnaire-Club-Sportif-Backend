package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Seat;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SeatUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // seatNumber : @NotBlank

    @Test
    public void seatNumberBlank_MustBeNotValidated() {

        Seat seat = new Seat();
        seat.setSeatNumber("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(seat),
                "seatNumber",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void seatNumberNull_MustBeNotValidated() {

        Seat seat = new Seat();
        seat.setSeatNumber(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(seat),
                "seatNumber",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void seatNumberOnlySpaces_MustBeNotValidated() {

        Seat seat = new Seat();
        seat.setSeatNumber("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(seat),
                "seatNumber",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void seatNumberValid_MustBeValidated() {

        Seat seat = new Seat();
        seat.setSeatNumber("A12");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(seat),
                "seatNumber",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }
}
