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

 @Query()
 // SELECT COUNT(se)
     // from Seat se

 List<EventMedium> findAllEventMedium();
}
