package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.model.StatusPresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPresenceDAO extends JpaRepository<StatusPresence, Integer> {
}
