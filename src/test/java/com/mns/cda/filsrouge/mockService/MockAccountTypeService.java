package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IAccountTypeService;
import com.mns.cda.filsrouge.model.AccountType;

import java.util.List;
import java.util.Optional;

public class MockAccountTypeService implements IAccountTypeService {
    @Override
    public List<AccountType> findAll() {
        return List.of(new AccountType(1, "Admin"), new AccountType(2, "User"));
    }

    @Override
    public Optional<AccountType> findById(int id) {
        if (id == 1) {
            return Optional.of(new AccountType(1, "Admin"));
        }
        return Optional.empty();
    }

    @Override
    public void create(AccountType accountType) {
        accountType.setIdAccountType(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, AccountType accountType) throws AccountTypeNotFoundException {
        if (id != 1) {
            throw new AccountTypeNotFoundException();
        }
        accountType.setIdAccountType(id);

    }
}
