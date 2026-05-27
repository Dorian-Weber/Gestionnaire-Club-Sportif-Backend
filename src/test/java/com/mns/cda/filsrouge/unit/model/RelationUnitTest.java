package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.model.Relation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RelationUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // relationStatus : @NotNull

    @Test
    public void relationStatusNull_MustBeNotValidated() {

        Relation relation = new Relation();
        relation.setRelationStatus(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(relation),
                "relationStatus",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void relationStatusValid_MustBeValidated() {

        Relation relation = new Relation();
        relation.setRelationStatus(RelationStatus.ACCEPTED);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(relation),
                "relationStatus",
                "NotNull"
        );

        Assertions.assertFalse(exists);
    }
}
