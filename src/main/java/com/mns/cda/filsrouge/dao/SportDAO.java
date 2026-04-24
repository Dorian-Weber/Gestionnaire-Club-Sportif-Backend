package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.SportField;
import com.mns.cda.filsrouge.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportDAO extends JpaRepository<Sport, Integer> {

    @Query("SELECT new com.mns.cda.filsrouge.dto.SportField(s.idSport, s.sportName) " +
            "FROM Sport s")
    List<SportField> findAllSportField();
}
