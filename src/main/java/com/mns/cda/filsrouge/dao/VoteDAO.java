package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.VoteLight;
import com.mns.cda.filsrouge.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Vote.VoteKey> {

    @Query("""
    SELECT new com.mns.cda.filsrouge.dto.VoteLight(e.idEvent, e.eventName, v.eventRating, a.idAthlete, a.athleteName, a.athleteFirstName)
    FROM Vote v
    JOIN v.event e
    JOIN v.athlete a
    JOIN v.user u
    WHERE u.idAppUser = :userId
    and v.athlete IS NOT NULL 
    ORDER BY e.eventDate ASC 
    limit 3 
""")
    List<VoteLight> getLastVoteWithUserId(@Param("userId") Integer userId);
}
