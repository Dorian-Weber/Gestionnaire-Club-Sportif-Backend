package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.SeatFull;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.StatusPresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Integer> {

    @Query("""
        SELECT r
        FROM Reservation r
        WHERE r.event.idEvent = :idEvent
    """)
    List<Reservation> findReservationByIdEvent(@Param("idEvent") int idEvent);

    @Query("SELECT COUNT(r) > 0 " +
            "FROM Reservation r " +
            "WHERE r.event.idEvent = :idEvent " +
            "AND r.user.idAppUser = :userId")
    boolean userHasReservation(@Param("idEvent") int eventId, @Param("userId") int userId);

    //Requête pour Aggregation
    @Query("""
        SELECT new com.mns.cda.filsrouge.dto.EventLight(
            e.idEvent,
            e.eventName,
            e.eventDate,
            s.sportName
        )
        FROM Reservation r
        JOIN r.event e
        JOIN e.sport s
        WHERE r.idReservation = :reservationId
    """)
    EventLight getEventLightByReservationId(@Param("reservationId") Integer reservationId);

    @Query("""
        SELECT new com.mns.cda.filsrouge.dto.SeatFull(
            s.idSeat,
            s.seatNumber,
            l.levelName,
            p.platformName
        )
        FROM Reservation r
        JOIN r.seats s
        JOIN s.level l
        JOIN l.platform p
        WHERE r.idReservation = :reservationId
        ORDER BY s.seatNumber
    """)
    List<SeatFull> getSeatsFullByReservationId(@Param("reservationId") Integer reservationId);

    @Query("""
        SELECT r
        FROM Reservation r
        WHERE r.user.idAppUser = :userId
        ORDER BY r.idReservation DESC
    """)
    List<Reservation> findByUserId(@Param("userId") Integer userId);
}
