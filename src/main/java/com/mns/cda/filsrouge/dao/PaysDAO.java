package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysDAO extends JpaRepository<Pays, Integer> {
}
