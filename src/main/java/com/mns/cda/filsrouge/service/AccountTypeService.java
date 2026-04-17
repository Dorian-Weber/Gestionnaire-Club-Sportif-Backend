package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.dao.AccountTypeDAO;
import com.mns.cda.filsrouge.model.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountTypeService {

    public static class UserNotFoundException extends Exception {}

    protected final AccountTypeDAO accountTypeDAO;

    //GetAll
    public List<AccountType> findAll() { return accountTypeDAO.findAll(); }

    //GetByID
    public Optional<AccountType> findById(int id) {
        return accountTypeDAO.findById(id);
    }

    //Post
    public void create(AccountType accountType) {
        accountType.setIdAccountType(null);
        accountTypeDAO.save(accountType);
    }

    //Delete
    public void delete(int id) {
        accountTypeDAO.deleteById(id);
    }

    //Put
    public void update(int id, AccountType accountType) throws UserNotFoundException{
        Optional<AccountType> accountTypeOptional = accountTypeDAO.findById(id);

        if(accountTypeOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        accountType.setIdAccountType(id);
        accountTypeDAO.save(accountType);
    }

}
