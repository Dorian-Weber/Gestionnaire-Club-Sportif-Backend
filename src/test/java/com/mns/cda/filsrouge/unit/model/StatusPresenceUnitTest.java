package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.StatusPresence;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StatusPresenceUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du type de compte ne peut pas être vide
    @Test
    public void validStatusPresenceWithStatusPresenceNameBlank_MustBeNotValidated(){

        StatusPresence statusPresence = new StatusPresence();
        statusPresence.setStatusPresenceName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(statusPresence),
                "StatusPresenceName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
