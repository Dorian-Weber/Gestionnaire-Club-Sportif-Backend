package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Level;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LevelUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // levelName : @NotBlank

    @Test
    public void levelNameBlank_MustBeNotValidated() {

        Level level = new Level();
        level.setLevelName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(level),
                "levelName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void levelNameNull_MustBeNotValidated() {

        Level level = new Level();
        level.setLevelName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(level),
                "levelName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void levelNameOnlySpaces_MustBeNotValidated() {

        Level level = new Level();
        level.setLevelName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(level),
                "levelName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void levelNameValid_MustBeValidated() {

        Level level = new Level();
        level.setLevelName("VIP");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(level),
                "levelName",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }

    // platform : @NotNull (via nullable = false)

    @Test
    public void platformNull_MustBeNotValidated() {

        Level level = new Level();
        level.setPlatform(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(level),
                "platform",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }
}
