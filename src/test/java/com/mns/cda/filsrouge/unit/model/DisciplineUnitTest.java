package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Discipline;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DisciplineUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // disciplineName : @NotBlank

    @Test
    public void validDisciplineWithDisciplineNameBlank_MustBeNotValidated() {

        Discipline discipline = new Discipline();
        discipline.setDisciplineName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "disciplineName",
                "NotBlank"
        );

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validDisciplineWithDisciplineNameNull_MustBeNotValidated() {

        Discipline discipline = new Discipline();
        discipline.setDisciplineName(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "disciplineName",
                "NotBlank"
        );

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validDisciplineWithDisciplineNameOnlySpaces_MustBeNotValidated() {

        Discipline discipline = new Discipline();
        discipline.setDisciplineName("   ");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "disciplineName",
                "NotBlank"
        );

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validDisciplineWithValidDisciplineName_MustBeValidated() {

        Discipline discipline = new Discipline();
        discipline.setDisciplineName("100m Sprint");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "disciplineName",
                "NotBlank"
        );

        Assertions.assertFalse(constraintExist);
    }
}
