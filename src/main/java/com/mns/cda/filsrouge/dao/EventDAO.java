package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.EventFull;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            "et.eventTypeName, " +
            "s.sportName,(select count(se) " +
            "FROM Seat se " +
            "Join se.reservations r2 " +
            "WHERE r2.event = e),(select count(se2)" +
            " FROM Seat se2)) " +
            "FROM Event e " +
            "join e.eventType et " +
            "JOIN e.sport s " +
            "WHERE e.eventDate >= current timestamp " +
            "order by e.eventDate ASC")
    List<EventMedium> findEventMedium();

    @Query("select new com.mns.cda.filsrouge.dto.EventMedium(e.idEvent, " +
            "e.eventName, " +
            "e.eventDescription, " +
            "e.eventDate, " +
            "et.eventTypeName, " +
            "s.sportName,(select count(se) " +
            "FROM Seat se " +
            "Join se.reservations r2 " +
            "WHERE r2.event = e),(select count(se2) " +
            " FROM Seat se2))  " +
            "FROM Event e " +
            "join e.eventType et " +
            "JOIN e.sport s " +
            "WHERE (:sportName IS NULL or s.sportName = :sportName) " +
            "and (:eventTypeName IS NULL or et.eventTypeName = :eventTypeName)" +
            "AND (:search IS NULL OR :search = '' OR " +
            "LOWER(e.eventName) LIKE LOWER(CONCAT( '%', :search, '%')) OR " +
            "LOWER(e.eventDescription) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "AND (e.eventDate >= :dateMin) " +
            "order by e.eventDate ASC")
    List<EventMedium> findEventMediumByFilter(
            @Param("sportName") String sportName,
            @Param("eventTypeName") String eventTypeName,
            @Param("search") String search,
            @Param("dateMin") LocalDateTime dateMin);
}
