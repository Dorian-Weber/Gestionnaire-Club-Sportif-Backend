package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDAO extends JpaRepository<Seat, Integer> {

    @Query("""
    SELECT s FROM Seat s
    WHERE s.level.levelName = :level
      AND s.level.platform.platformName = :platform
""")
    List<Seat> findByPlatformAndLevel(String platform, String level);

    @Query("""
SELECT CASE
    WHEN
        (SELECT COUNT(s)
         FROM Reservation r
         JOIN r.seats s
         WHERE r.event.idEvent = :eventId)
        =
        (SELECT COUNT(s2) FROM Seat s2)
    THEN TRUE
    ELSE FALSE
END
FROM Event e
WHERE e.idEvent = :eventId
""")
    boolean isFull(@Param("eventId") int eventId);


}
