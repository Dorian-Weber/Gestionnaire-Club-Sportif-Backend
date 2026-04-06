package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDAO extends JpaRepository<Seat, Integer> {
}
