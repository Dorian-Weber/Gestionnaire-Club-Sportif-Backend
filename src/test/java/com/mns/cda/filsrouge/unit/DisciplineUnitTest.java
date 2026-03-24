package com.mns.cda.filsrouge.unit;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Discipline;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DisciplineUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de la discipline ne peut pas être vide
    @Test
    public void valideDisciplineAvecNomDisciplineBlank_DoitEtreNonValide(){

        Discipline discipline = new Discipline();
        discipline.setNomDiscipline("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "nomDiscipline",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test Pour valider que le record événement ne peut pas être vide
    @Test
    public void valideDisciplineAvecRecordEvenemntBlank_DoitEtreNonValide(){

        Discipline discipline = new Discipline();
        discipline.setRecordEvenement("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "recordEvenement",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test Pour valider que le record monde ne peut pas être vide
    @Test
    public void valideDisciplineAvecRecordMondeBlank_DoitEtreNonValide(){

        Discipline discipline = new Discipline();
        discipline.setRecordMonde("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "recordMonde",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }
}
