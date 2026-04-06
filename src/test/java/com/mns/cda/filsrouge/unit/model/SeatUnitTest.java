package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Seat;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SeatUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du type de compte ne peut pas être vide
    @Test
    public void validSeatWithSeatNameBlank_MustBeNotValidated(){

        Seat seat = new Seat();
        seat.setSeatNumber("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(seat),
                "seatNumber",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
