package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.TypeEvenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEvenementDAO extends JpaRepository<TypeEvenement, Integer> {
}
