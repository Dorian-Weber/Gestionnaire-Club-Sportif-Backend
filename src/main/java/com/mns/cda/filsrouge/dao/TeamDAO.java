package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.TeamEvent;
import com.mns.cda.filsrouge.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDAO extends JpaRepository<Team, Integer> {

    @Query(" SELECT t " +
            "FROM Team t " +
            "JOIN t.events e " +
            "WHERE e.idEvent = :eventId")
    List<Team> findTeamsByEvent(Long eventId);

}
