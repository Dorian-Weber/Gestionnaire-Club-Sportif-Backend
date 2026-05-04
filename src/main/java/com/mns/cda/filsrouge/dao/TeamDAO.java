package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamDAO extends JpaRepository<Team, Integer> {

    @Query(" SELECT t " +
            "FROM Team t " +
            "JOIN t.events e " +
            "WHERE e.idEvent = :idEvent")
    List<Team> findTeamByEventId(@Param("idEvent") int idEvent);
}
