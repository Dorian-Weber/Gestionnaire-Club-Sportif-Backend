package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Relation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RelationUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le status de relation status ne peut pas être vide
    @Test
    public void validRelationWithRelationStatusNotBlank_MustBeNotValidated(){

        Relation relation = new Relation();
        relation.setRelationStatus("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(relation),
                "relationStatus",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
