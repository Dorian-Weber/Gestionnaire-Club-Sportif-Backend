package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Country;
import com.mns.cda.filsrouge.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDAO extends JpaRepository<Country, Integer> {
}
