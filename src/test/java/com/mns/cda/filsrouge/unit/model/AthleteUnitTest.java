package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Athlete;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AthleteUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de l'athlète ne peut pas être vide
    @Test
    public void validAthleteWithNameAthleteBlank_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setAthleteName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le prénom de l'athlète ne peut pas être vide
    @Test
    public void validAthleteWithFirstNameAthleteBlank_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setAthleteFirstName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteFirstName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la date de naissance de l'athlète ne peut pas être vide
    @Test
    public void validAthleteWithBirthDateAthleteBlank_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setAthleteBirthDate(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "NotNull");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la date de naissance ne peut être dans le futur.
    @Test
    public void validAthleteWithBirthDateAthleteNotInFuture_MustBeNotValidated(){

        Athlete athlete = new Athlete();
        athlete.setAthleteBirthDate(LocalDate.now().plusDays(1));

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "Past");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la date de naissance peut être dans le passé.
    @Test
    public void validAthleteWithBirthDateAthleteInPast_MustBeValidated(){
        Athlete athlete = new Athlete();
        athlete.setAthleteBirthDate(LocalDate.now().minusDays(1));

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "Past");
        Assertions.assertFalse(constraintExist);
    }
}
