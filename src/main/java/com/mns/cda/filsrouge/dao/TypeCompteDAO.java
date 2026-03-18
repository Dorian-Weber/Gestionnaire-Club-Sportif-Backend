package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCompteDAO extends JpaRepository<TypeCompte, Integer> {
}
