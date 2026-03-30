package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Athlete;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AthleteUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du sportif ne peut pas être vide
    @Test
    public void validAthleteWithNameAthleteBlank_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setNameAthlete("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "nameAthlete",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le prénom du sportif ne peut pas être vide
    @Test
    public void validAthleteWithFirstNameAthleteBlank_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setFirstNameAthlete("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "firstNameAthlete",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le nom du sportif ne peut pas être vide
    @Test
    public void validAthleteWithBirthDateAthleteBlank_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setBirthDateAthlete(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "birthDateAthlete",
                "NotNull");
        Assertions.assertTrue(constraintExist);
    }
}
