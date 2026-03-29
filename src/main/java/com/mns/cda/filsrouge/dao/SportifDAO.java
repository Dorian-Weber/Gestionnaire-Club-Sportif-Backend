package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Sport;
import com.mns.cda.filsrouge.model.Sportif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportifDAO extends JpaRepository<Sportif, Integer> {
}
