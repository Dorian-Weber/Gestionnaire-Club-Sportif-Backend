package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Vote.VoteKey> {
}
