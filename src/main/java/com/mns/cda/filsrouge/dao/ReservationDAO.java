package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.StatusPresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Integer> {
}
