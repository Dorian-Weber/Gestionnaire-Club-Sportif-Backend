package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.EventTypeField;
import com.mns.cda.filsrouge.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTypeDAO extends JpaRepository<EventType, Integer> {

    @Query("select new com.mns.cda.filsrouge.dto.EventTypeField(e.idEventType, e.eventTypeName)" +
            "FROM EventType e")
    List<EventTypeField> findAllEventTypeField();
}
