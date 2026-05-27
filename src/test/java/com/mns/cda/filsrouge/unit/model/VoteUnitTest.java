package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Vote;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VoteUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // user : @NotNull

    @Test
    public void userNull_MustBeNotValidated() {

        Vote vote = new Vote();
        vote.setUser(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(vote),
                "user",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    // event : @NotNull

    @Test
    public void eventNull_MustBeNotValidated() {

        Vote vote = new Vote();
        vote.setEvent(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(vote),
                "event",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    // athlete : @NotNull

    @Test
    public void athleteNull_MustBeNotValidated() {

        Vote vote = new Vote();
        vote.setAthlete(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(vote),
                "athlete",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }
}
