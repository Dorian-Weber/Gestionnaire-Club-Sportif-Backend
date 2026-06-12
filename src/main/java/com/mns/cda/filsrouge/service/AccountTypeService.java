package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IAccountTypeService;
import com.mns.cda.filsrouge.dao.AccountTypeDAO;
import com.mns.cda.filsrouge.model.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountTypeService implements IAccountTypeService {

    protected final AccountTypeDAO accountTypeDAO;

    //GetAll
    @Override
    public List<AccountType> findAll() { return accountTypeDAO.findAll(); }

    //GetByID
    @Override
    public Optional<AccountType> findById(int id) {
        return accountTypeDAO.findById(id);
    }

    //Post
    @Override
    public void create(AccountType accountType) {
        accountType.setIdAccountType(null);
        accountTypeDAO.save(accountType);
    }


    //Delete
    @Override
    public void delete(int id) {
        accountTypeDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, AccountType accountType) throws AccountTypeNotFoundException {
        Optional<AccountType> accountTypeOptional = accountTypeDAO.findById(id);

        if(accountTypeOptional.isEmpty()) {
            throw new AccountTypeNotFoundException();
        }
        accountType.setIdAccountType(id);
        accountTypeDAO.save(accountType);
    }

}
