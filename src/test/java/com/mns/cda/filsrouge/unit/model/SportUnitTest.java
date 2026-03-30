package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Sport;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SportUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du sport ne peut pas être vide
    @Test
    public void validSportAvecSportNameBlank_MustBeNotValidated(){

        Sport sport = new Sport();
        sport.setSportName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(sport),
                "sportName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
