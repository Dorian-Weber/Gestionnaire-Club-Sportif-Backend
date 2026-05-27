package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Team;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TeamUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // teamName : @NotBlank

    @Test
    public void teamNameBlank_MustBeNotValidated() {

        Team team = new Team();
        team.setTeamName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(team),
                "teamName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void teamNameNull_MustBeNotValidated() {

        Team team = new Team();
        team.setTeamName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(team),
                "teamName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void teamNameOnlySpaces_MustBeNotValidated() {

        Team team = new Team();
        team.setTeamName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(team),
                "teamName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void teamNameValid_MustBeValidated() {

        Team team = new Team();
        team.setTeamName("Team Alpha");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(team),
                "teamName",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }
}
