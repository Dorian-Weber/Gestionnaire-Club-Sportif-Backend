package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
         "et.idEventType, " +
         "s.idSport, " +
         "s.sportName,(select count(se) " +
                        "FROM Seat se " +
                        "Join se.reservations r2 " +
                        "WHERE r2.event = e),(select count(se2)" +
                                            " FROM Seat se2)) " +
         "FROM Event e " +
         "join e.eventType et " +
         "JOIN e.sport s " +
         "order by e.eventDate ASC")
 List<EventMedium> findEventMedium();
}
