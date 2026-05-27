package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.TestUtilitaire;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AthleteUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // athleteName : @NotBlank

    @Test
    public void athleteNameBlank_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void athleteNameNull_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void athleteNameOnlySpaces_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    // athleteFirstName : @NotBlank

    @Test
    public void athleteFirstNameBlank_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteFirstName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteFirstName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void athleteFirstNameNull_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteFirstName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteFirstName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void athleteFirstNameOnlySpaces_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteFirstName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteFirstName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    // athleteBirthDate : @NotNull, @Past

    @Test
    public void athleteBirthDateNull_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteBirthDate(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void athleteBirthDateInFuture_MustBeNotValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteBirthDate(LocalDate.now().plusDays(1));

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "Past"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void athleteBirthDateValidPast_MustBeValidated() {
        Athlete athlete = new Athlete();
        athlete.setAthleteBirthDate(LocalDate.of(1990, 5, 10));

        boolean existsNotNull = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "NotNull"
        );

        boolean existsPast = TestUtilitaire.constraintViolationExist(
                validator.validate(athlete),
                "athleteBirthDate",
                "Past"
        );

        Assertions.assertFalse(existsNotNull);
        Assertions.assertFalse(existsPast);
    }
}
