package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteDAO extends JpaRepository<Athlete, Integer> {

    @Query("select new com.mns.cda.filsrouge.dto.AthleteDTO (a.idAthlete, " +
            "a.athleteName," +
            " a.athleteFirstName) " +
            "from Athlete a " +
            "join a.events e " +
            "WHERE e.idEvent = :idEvent")
    List<AthleteDTO> findAthleteByEvent(@Param("idEvent") int idEvent);

    @Query("select new com.mns.cda.filsrouge.dto.AthleteDTO (a.idAthlete, " +
            "a.athleteName," +
            " a.athleteFirstName) " +
            "from Athlete a " +
            "join a.teams t " +
            "WHERE t.idTeam = :idTeam")
    List<AthleteDTO> findAthleteByTeam(@Param("idTeam") int idTeam);
}
