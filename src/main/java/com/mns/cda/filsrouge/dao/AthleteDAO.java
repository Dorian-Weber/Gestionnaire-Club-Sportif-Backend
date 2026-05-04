package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.AthleteEvent;
import com.mns.cda.filsrouge.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteDAO extends JpaRepository<Athlete, Integer> {

    @Query("select new com.mns.cda.filsrouge.dto.AthleteEvent(a.idAthlete, " +
            "a.athleteName," +
            " a.athleteFirstName) " +
            "from Athlete a " +
            "join a.events e " +
            "WHERE e.idEvent = :idEvent")
    List<AthleteEvent> findAthleteByEvent(long idEvent);

    @Query("select new com.mns.cda.filsrouge.dto.AthleteEvent(a.idAthlete, " +
            "a.athleteName," +
            " a.athleteFirstName) " +
            "from Athlete a " +
            "join a.teams t " +
            "WHERE t.idTeam = :idTeam")
    List<AthleteEvent> findAthleteByTeam(long idTeam);
}
