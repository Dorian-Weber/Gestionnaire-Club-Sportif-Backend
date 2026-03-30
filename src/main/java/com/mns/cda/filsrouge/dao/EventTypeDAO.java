package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeDAO extends JpaRepository<EventType, Integer> {
}
