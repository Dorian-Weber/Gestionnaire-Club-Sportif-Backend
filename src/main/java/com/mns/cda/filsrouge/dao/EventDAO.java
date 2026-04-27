package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventDAO extends JpaRepository<Event, Integer> {

 @Query("SELECT new com.mns.cda.filsrouge.dto.EventLight(e.idEvent, e.eventName, e.eventDate, s.sportName) " +
         "FROM Event e " +
         "INNER JOIN e.sport s " +
         "WHERE e.eventDate >= current timestamp " +
         "ORDER BY e.eventDate ASC " +
         "LIMIT 3")
    List<EventLight> findNextEventLight();

 @Query("SELECT new com.mns.cda.filsrouge.dto.EventMedium (e.idEvent, " +
         "e.eventName, " +
         "e.eventDescription, " +
         "e.eventDate, " +
         "e.sport.sportName,(select count(se) " +
                        "FROM Seat se " +
                        "Join se.reservations r2 " +
                        "WHERE r2.event = e),(select count(se2)" +
                                            " FROM Seat se2)) " +
         "FROM Event e " +
         "JOIN e.sport s ")
 List<EventMedium> findEventMediumById();
}
