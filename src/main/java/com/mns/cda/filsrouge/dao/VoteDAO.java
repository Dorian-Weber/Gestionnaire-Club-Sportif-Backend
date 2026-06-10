package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.VoteDTO;
import com.mns.cda.filsrouge.dto.VoteEventDTO;
import com.mns.cda.filsrouge.dto.VoteInfo;
import com.mns.cda.filsrouge.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Vote.VoteKey> {

    @Query("""
    SELECT new com.mns.cda.filsrouge.dto.VoteInfo(e.idEvent, e.eventName, v.eventRating, a.idAthlete, a.athleteName, a.athleteFirstName)
    FROM Vote v
    JOIN v.event e
    JOIN v.athlete a
    JOIN v.user u
    WHERE u.idAppUser = :userId
    and v.athlete IS NOT NULL 
    ORDER BY e.eventDate ASC 
    limit 3 
""")
    List<VoteInfo> getLastVoteWithUserId(@Param("userId") Integer userId);

    //Liste de vote non fait
    @Query("""
    SELECT new com.mns.cda.filsrouge.dto.VoteDTO(
        e.idEvent,
        e.eventName,
        e.eventDate,
        v.eventRating,
        v.athlete.idAthlete
    )
    FROM Event e
    JOIN Reservation r ON r.event.idEvent = e.idEvent
    LEFT JOIN Vote v ON v.event.idEvent = e.idEvent AND v.user.idAppUser = :userId
    WHERE r.user.idAppUser = :userId
      AND r.statusPresence.statusPresenceName = 'Présent'
      AND e.eventDate < CURRENT_TIMESTAMP
      AND v.voteKey IS NULL
""")
    List<VoteDTO> findPendingVotes(Integer userId);

    //Liste de vote déjà fait
    @Query("""
    SELECT new com.mns.cda.filsrouge.dto.VoteDTO(
        e.idEvent,
        e.eventName,
        e.eventDate,
        v.eventRating,
        v.athlete.idAthlete
    )
    FROM Event e
    JOIN Reservation r ON r.event.idEvent = e.idEvent
    JOIN Vote v ON v.event.idEvent = e.idEvent AND v.user.idAppUser = :userId
    WHERE r.user.idAppUser = :userId
      AND r.statusPresence.statusPresenceName = 'Présent'
      AND e.eventDate < CURRENT_TIMESTAMP
""")
    List<VoteDTO> findCompletedVotes(Integer userId);

}
