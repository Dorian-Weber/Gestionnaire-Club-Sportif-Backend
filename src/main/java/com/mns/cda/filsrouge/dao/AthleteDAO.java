package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteDAO extends JpaRepository<Athlete, Integer> {

    @Query()

}
