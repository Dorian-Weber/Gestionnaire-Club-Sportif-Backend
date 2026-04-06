package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelDAO extends JpaRepository<Level, Integer> {
}
