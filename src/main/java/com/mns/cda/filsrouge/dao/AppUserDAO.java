package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser, Integer> {
}
