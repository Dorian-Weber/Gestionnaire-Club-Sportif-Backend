package com.mns.cda.filsrouge.dao;

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

}
