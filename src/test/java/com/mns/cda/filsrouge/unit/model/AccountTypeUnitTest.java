package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.TestUtilitaire;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTypeUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // accountTypeName - @NotBlank

    @Test
    public void validAccountTypeWithAccountTypeNameBlank_MustBeNotValidated() {

        AccountType accountType = new AccountType();
        accountType.setAccountTypeName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(accountType),
                "accountTypeName",
                "NotBlank");

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validAccountTypeWithAccountTypeNameNull_MustBeNotValidated() {

        AccountType accountType = new AccountType();
        accountType.setAccountTypeName(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(accountType),
                "accountTypeName",
                "NotBlank");

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validAccountTypeWithAccountTypeNameOnlySpaces_MustBeNotValidated() {

        AccountType accountType = new AccountType();
        accountType.setAccountTypeName("   ");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(accountType),
                "accountTypeName",
                "NotBlank");

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validAccountTypeWithValidAccountTypeName_MustBeValidated() {

        AccountType accountType = new AccountType();
        accountType.setAccountTypeName("Admin");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(accountType),
                "accountTypeName",
                "NotBlank");

        Assertions.assertFalse(constraintExist);
    }
}
