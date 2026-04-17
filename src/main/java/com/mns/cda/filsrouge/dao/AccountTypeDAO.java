package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeDAO extends JpaRepository<AccountType, Integer> {
}
