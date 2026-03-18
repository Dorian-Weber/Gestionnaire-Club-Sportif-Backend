package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportDAO extends JpaRepository<Sport, Integer> {
}
