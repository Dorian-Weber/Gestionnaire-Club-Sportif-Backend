package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.AccountType;

import java.util.List;
import java.util.Optional;

public interface IAccountTypeService {

    public static class AccountTypeNotFoundException extends Exception {}

    //GetAll
    List<AccountType> findAll();

    //GetByID
    Optional<AccountType> findById(int id);

    //Post
    void create(AccountType accountType);

    //Delete
    void delete(int id);

    //Put
    void update(int id, AccountType accountType) throws AccountTypeNotFoundException;


}
