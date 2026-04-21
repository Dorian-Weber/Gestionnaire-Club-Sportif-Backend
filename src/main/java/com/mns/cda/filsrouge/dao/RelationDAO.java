package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationDAO extends JpaRepository<Relation, Relation.Key> {
}
