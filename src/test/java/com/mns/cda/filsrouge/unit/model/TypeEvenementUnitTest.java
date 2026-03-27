package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.TypeEvenement;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TypeEvenementUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du typeevenement ne peut pas être vide
    @Test
    public void valideTypeEvenementAvecNomTypeEvenementBlank_DoitEtreNonValide(){

        TypeEvenement  typeevenement = new TypeEvenement();
        typeevenement.setNomTypeEvenement("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(typeevenement),
                "nomTypeEvenement",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
